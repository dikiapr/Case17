package com.example.demo.configuration;

import org.eclipse.paho.mqttv5.client.MqttClient;
import org.eclipse.paho.mqttv5.client.MqttConnectionOptionsBuilder;
import org.eclipse.paho.mqttv5.common.MqttException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.configuration.properties.MqttProp;

@Configuration
public class ApplicationConfig {

  @Bean
  public MqttClient mqttClient(MqttProp prop) throws MqttException {
    var options = new MqttConnectionOptionsBuilder()
        .automaticReconnect(true)
        .cleanStart(true)
        .connectionTimeout(30)
        .username(prop.getUsername())
        .password(prop.getPasswordBytes())
        .build();

    var client = new MqttClient(prop.getBrokerAddress(), prop.getClientId());
    System.out.println("Attempting to connect to MQTT broker");

    try {
      if (!client.isConnected()) {
        client.connect(options);
        System.out.println("Successfully connected to MQTT broker");
      } else {
        System.out.println("Client is already connected");
      }
    } catch (MqttException e) {
      System.err.println("Connection failed: " + e.getMessage());
      throw e;
    }

    return client;
  }


}
