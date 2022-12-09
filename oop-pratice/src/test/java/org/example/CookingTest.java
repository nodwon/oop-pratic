package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CookingTest {
    @DisplayName("메뉴에 해당하는 음식을 만든다.")
    @Test
    void makeCookTest() {
        Cooking cooking = new Cooking();
        Menuitem menuitem = new Menuitem("돈까스",5000);

        Cook cook = cooking.makeCook(menuitem);

        assertThat(cook).isEqualTo(new Cook("돈까스",5000));
    }
}
