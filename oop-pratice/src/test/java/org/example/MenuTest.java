package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;


public class MenuTest {
    @DisplayName("�޴��̸��� �ش��ϴ� �޴��� ��ȯ�Ѵ�.")
    @Test
    void chooseTest() {
        Menu menu = new Menu(List.of(new Menuitem("���",5000), new Menuitem("�ø�",7000)));
        menu.choose("���");
        Menuitem menuitem = menu.choose("���");
        assertThat(menuitem).isEqualTo(new Menuitem("���",5000));
    }
    @DisplayName("�޴��ǿ� ���� �޴��� �����ҽ� ���ܸ�  ��ȯ�Ѵ�.")
    @Test
    void chooseTest() {
        Menu menu = new Menu(List.of(new Menuitem("���",5000), new Menuitem("�ø�",7000)));

        assertThatCode(() -> menu.choose("���")).isInstanceOf(IllegalStateException.class)
                .hasMessage("�߸��� �޴� �̸�.");
    }
}
