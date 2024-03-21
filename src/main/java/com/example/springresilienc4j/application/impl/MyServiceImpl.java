package com.example.springresilienc4j.application.impl;

import com.example.springresilienc4j.application.MyService;
import com.example.springresilienc4j.application.exception.CircuitException;
import com.example.springresilienc4j.application.exception.IgnoreException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;

@Service
class MyServiceImpl implements MyService {

    @Override
    @CircuitBreaker(name = "myCircuit", fallbackMethod = "doFallback")
    public String doService(long id) {
        if (id == 1L) {
            throw new CircuitException("CircuitException!");
        }

        if (id == 2L) {
            throw new IgnoreException("IgnoreException !");
        }

        return "안녕하세요. 이건 정상적인 상황입니다.";
    }

    @SuppressWarnings("unused")
    private String doFallback(long id, Exception exception) throws Exception {
        System.out.println("예외메시지는 " + exception.getMessage());
        return "fallbackMethod";
    }
}
