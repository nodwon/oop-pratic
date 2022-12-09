package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class UserTest {

    @DisplayName("패스워드를 초기화한다.")
    @Test
    void passwordTest() { // 랜덤을으로 만들어진경우 성공할수도 있고 성공 못할수 있음
        User user = new User();

        //when
      //  user.initPassword(new CorrectFixedPasswordGenerate());
        user.initPassword(() ->"abcedefgh");

        //then
        assertThat(user.getPassword()).isNotNull();
    }
    @DisplayName("패스워드가 요구사항에 부합되지 않아 초기화가 되지 않는다.")
    @Test
    void passwordTest2() { // 랜덤을으로 만들어진경우 성공할수도 있고 성공 못할수 있음
        User user = new User();

        //when
        //user.initPassword(new WrongFixedPasswordGenerate());
        user.initPassword(() ->"ab");

        //then
        assertThat(user.getPassword()).isNull();
    }


}