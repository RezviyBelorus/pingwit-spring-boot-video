package com.pingwit.part_50;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class TransactionalCupcakeServiceExample {

    @PostConstruct
    private void init() {
        save("Non-transaction cake");
    }


    @Transactional
    public void save(String cake) {
        System.out.println(cake);
        // do something
    }
}
