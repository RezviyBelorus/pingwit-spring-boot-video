package com.pingwit.part_50;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionalBunServiceExample {
    private final TransactionalCupcakeServiceExample cupcakeServiceExample;

    @PostConstruct
    private void init() {
        cupcakeServiceExample.save("Transactional cupcake is in the rush");
    }
}
