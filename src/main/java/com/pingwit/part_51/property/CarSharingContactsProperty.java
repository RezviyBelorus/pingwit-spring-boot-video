package com.pingwit.part_51.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "api.car-sharing.contacts")
public record CarSharingContactsProperty(String phone, String email) {
}
