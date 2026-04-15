package com.monnetpayments.challenge.api.infrastructure.services;

import com.monnetpayments.challenge.api.application.services.Service;
import com.monnetpayments.challenge.api.domain.Q;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class ServiceWithQ implements Service {

    @Autowired
    Q q;

    @Override
    public String doAGreet() {
        return q.greet();
    }
}
