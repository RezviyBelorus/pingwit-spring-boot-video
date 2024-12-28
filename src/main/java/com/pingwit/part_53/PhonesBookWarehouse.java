package com.pingwit.part_53;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class PhonesBookWarehouse {
    private Map<String, Integer> namesPhones = new HashMap<>();

    public Integer newContact(String name, Integer number) {
        return namesPhones.put(name, number);
    }

    public Integer removeContact(String name) {
        return namesPhones.remove(name);
    }

    public Integer getPhone(String name) {
        return namesPhones.get(name);
    }

    public Integer getTotalContacts() {
        return namesPhones.size();
    }

    public Map<String, Integer> exportPhoneBook() {
        return namesPhones;
    }
}
