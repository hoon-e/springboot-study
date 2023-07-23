package me.jaehoon.helloboot;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public interface HelloService {
    String sayHello(String name);
}
