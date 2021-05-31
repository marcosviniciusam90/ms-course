package com.devsuperior.hrpayroll.resources;

import com.devsuperior.hrpayroll.entities.Payment;
import com.devsuperior.hrpayroll.services.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentResource {

    @Autowired
    private PaymentService paymentService;

    @HystrixCommand(fallbackMethod = "getPaymentAlternative" )
    @GetMapping("/{workerId}/days/{days}")
    public Payment getPayment(@PathVariable Long workerId, @PathVariable Integer days) {
        return paymentService.getPayment(workerId, days);
    }

    public Payment getPaymentAlternative(Long workerId, Integer days) {
        return new Payment("Marcos", 400.0, days);
    }
}
