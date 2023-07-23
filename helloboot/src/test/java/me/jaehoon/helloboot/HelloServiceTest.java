package me.jaehoon.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class HelloServiceTest {
    @Test
    void serviceTest() {
        HelloDecorator decorator = new HelloDecorator(name -> name);
        String ret = decorator.sayHello("jaehoon");
        Assertions.assertThat(ret).isEqualTo("jaehoon!!");
    }
}
