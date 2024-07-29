package com.example.demo.configuration.properties;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Validated
@Data
@Component
@ConfigurationProperties("application.mqtt")
public class MqttProp {

  private String clientId = UUID.randomUUID().toString();

  @NotNull
  private String brokerAddress;

  private String username;
  private String password;

  public byte[] getPasswordBytes() {
    if (password != null) {
      return password.getBytes(StandardCharsets.UTF_8);
    }
    return new byte[0];
  }

}
