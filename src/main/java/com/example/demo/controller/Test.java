package com.example.demo.controller;

import org.eclipse.paho.mqttv5.client.MqttClient;
import org.eclipse.paho.mqttv5.common.MqttException;
import org.eclipse.paho.mqttv5.common.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("mqtt")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class Test {

  private final MqttClient client;

  @PostMapping
  public void test() throws MqttException {
    client.publish("test", new MqttMessage("Test".getBytes()));
  }

}
