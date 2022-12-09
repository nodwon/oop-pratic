package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;


public class MenuTest {
    @DisplayName("메뉴이름에 해당하는 메뉴룰 반환한다.")
    @Test
    void chooseTest() {
        Menu menu = new Menu(List.of(new Menuitem("돈까스",5000), new Menuitem("냉면",7000)));
        menu.choose("돈까스");
        Menuitem menuitem = menu.choose("돈까스");
        assertThat(menuitem).isEqualTo(new Menuitem("돈까스",5000));
    }
    @DisplayName("메뉴판에 없는 메뉴를 선택할시 예외를  반환한다.")
    @Test
    void chooseTest() {
        Menu menu = new Menu(List.of(new Menuitem("돈까스",5000), new Menuitem("냉면",7000)));

        assertThatCode(() -> menu.choose("통닭")).isInstanceOf(IllegalStateException.class)
                .hasMessage("잘못된 메뉴 이름.");
    }
}
