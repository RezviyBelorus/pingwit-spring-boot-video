package com.pingwit.part_53;

import org.springframework.stereotype.Service;

@Service
public class NumbersConverterService {
    public Integer valueOf(String input) {
        if (input.matches("-?\\d+")) {
            return Integer.valueOf(input);
        } else {
            return null;
        }
    }
}
