package me.jaehoon.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class HelloControllerTest {
    @Test
    void testHelloController() {
        HelloController helloController = new HelloController((name) -> name);
        String ret = helloController.hello("jaehoon");
        Assertions.assertThat(ret).isEqualTo("jaehoon");
    }

    @Test
    void testHelloControllerFail() {
        HelloController helloController = new HelloController((name) -> name);
        Assertions.assertThatThrownBy(() -> {
            String ret = helloController.hello(null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void testHelloControllerFail2() {
        HelloController helloController = new HelloController((name) -> name);
        Assertions.assertThatThrownBy(() -> {
            String ret = helloController.hello(" ");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
