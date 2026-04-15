package com.monnetpayments.challenge.api.config;

import com.monnetpayments.challenge.api.domain.EnglishQ;
import com.monnetpayments.challenge.api.domain.SpainQ;
import com.monnetpayments.challenge.api.domain.Q;
import com.monnetpayments.challenge.api.domain.UppercaseQ;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class Config {

    @Bean
//    @Primary
    Q getQ(){
        return new SpainQ();
    }

    @Bean
//    @Primary
    Q getQ2(){
        return new EnglishQ();
    }

    @Bean
    @Primary
    Q getQ3(){
        return new UppercaseQ(new SpainQ());
    }
}