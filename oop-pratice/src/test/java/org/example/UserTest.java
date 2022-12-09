package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class UserTest {

    @DisplayName("�н����带 �ʱ�ȭ�Ѵ�.")
    @Test
    void passwordTest() { // ���������� ���������� �����Ҽ��� �ְ� ���� ���Ҽ� ����
        User user = new User();

        //when
      //  user.initPassword(new CorrectFixedPasswordGenerate());
        user.initPassword(() ->"abcedefgh");

        //then
        assertThat(user.getPassword()).isNotNull();
    }
    @DisplayName("�н����尡 �䱸���׿� ���յ��� �ʾ� �ʱ�ȭ�� ���� �ʴ´�.")
    @Test
    void passwordTest2() { // ���������� ���������� �����Ҽ��� �ְ� ���� ���Ҽ� ����
        User user = new User();

        //when
        //user.initPassword(new WrongFixedPasswordGenerate());
        user.initPassword(() ->"ab");

        //then
        assertThat(user.getPassword()).isNull();
    }


}