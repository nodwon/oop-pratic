package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

public class MenuitemTest {
    @DisplayName("�޴��׸��� �����Ѵ�,")
    @Test
    void createTest() {
        assertThatCode(() -> new Menuitem("����", 5000))
                .doesNotThrowAnyException();
    }
}
