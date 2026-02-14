package com.LearningSpringWithSuraj.WorkingofSpringBoot;


import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name="payment.provider" , havingValue = "razer")
public class RazerPayment implements PaymentService {

    @Override
    public String Pay() {
        String Payment = "Razer Pay";
        System.out.println("Payment From : "+ Payment);
        return Payment;
    }
}
