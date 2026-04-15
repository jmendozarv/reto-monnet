package com.monnetpayments.challenge.api.config;

import com.monnetpayments.challenge.api.domain.EnglishQ;
import com.monnetpayments.challenge.api.domain.SpainQ;
import com.monnetpayments.challenge.api.domain.Q;
import com.monnetpayments.challenge.api.domain.UppercaseQ;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public final class Config {

    @Bean
    Q getQ(){
        return new SpainQ();
    }

    @Bean
    Q getQ2(){
        return new EnglishQ();
    }

    @Bean
    Q getQ3(){
        return new UppercaseQ(new SpainQ());
    }
}