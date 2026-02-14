package com.LearningSpringWithSuraj.WorkingofSpringBoot;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name="payment.provider", havingValue = "strip")
public class StripPayment implements PaymentService{

    @Override
    public String Pay() {
        String Payment = "Sprip Payment";
        System.out.println("Strip From : "+Payment);
        return Payment;
    }
}
