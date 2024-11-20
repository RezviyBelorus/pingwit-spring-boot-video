package com.pingwit.part_50.controller;

import com.pingwit.part_50.entity.Phone;
import com.pingwit.part_50.service.PhonesTransactionalClassService;
import com.pingwit.part_50.service.PhonesTransactionalPropagationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/phones")
@RequiredArgsConstructor
public class PhoneController {

    private final PhonesTransactionalClassService phonesTransactionalClassService;
    private final PhonesTransactionalPropagationService propagationService;

    @PostMapping
    public Phone save(@RequestBody Phone phone) throws Exception {
        return phonesTransactionalClassService.save(phone);
    }

    @PostMapping("/no/rollback")
    public Phone saveCheckedException(@RequestBody Phone phone) throws Exception {
        return phonesTransactionalClassService.saveCheckedException(phone);
    }

    @PostMapping("/rollback/for")
    public Phone saveRollbackFor(@RequestBody Phone phone) throws Exception {
        return phonesTransactionalClassService.saveRollbackFor(phone);
    }

    @PostMapping("/no/rollback/for")
    public Phone saveNoRollbackFor(@RequestBody Phone phone) {
        return phonesTransactionalClassService.saveNoRollbackFor(phone);
    }

    @PostMapping("/rollback/read")
    public Phone saveReadOnlyTrue(@RequestBody Phone phone) {
        return phonesTransactionalClassService.saveReadOnlyTrue(phone);
    }

    @PostMapping("/propagation/new")
    public Phone savePropagationRequiresNew(@RequestBody Phone phone) {
        return propagationService.savePropagationRequiresNew(phone);
    }

    @PostMapping("/propagation/never")
    public Phone savePropagationNever(@RequestBody Phone phone) {
        return propagationService.savePropagationNever(phone);
    }
}
