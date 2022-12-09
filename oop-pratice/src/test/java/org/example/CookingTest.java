package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CookingTest {
    @DisplayName("�޴��� �ش��ϴ� ������ �����.")
    @Test
    void makeCookTest() {
        Cooking cooking = new Cooking();
        Menuitem menuitem = new Menuitem("���",5000);

        Cook cook = cooking.makeCook(menuitem);

        assertThat(cook).isEqualTo(new Cook("���",5000));
    }
}
