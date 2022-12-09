package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * 음식점에서 음식 주문하는 과정구현
 * 요구사항
 * 1. 도메인을 구성하는 객체에는 어떤것들이 있는지 고민
 *      손님, 메뉴판, 돈까스/ 냉면, 만두, 요리사,요리
 * 2. 객체들 간의 관계고민
 *      손님 -- 메뉴판
 *      손님 -- 요리사
 *      요리사 -- 요리
 * 3. 동적인 객체를 정적인 타입으로 추상화하여 도메인 모델링하기
 *      손님 -- 손님타입
 *      돈까스 냉면 만두 -- 요리타입
 *      메뉴판 -- 메뉴판타입
 *      메뉴 -- 메뉴 타입
 * 4. 협력을 설계
 * 5. 객체들을 포함하는 타입에 적절한 책임을 할당
 * 6. 구현하기
 */
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;

public class CustomerTest {
    @DisplayName("메뉴이름에 해결하는 요르를 주문한다.")
    @Test
    void orderTest() {
        Customer customer = new Customer();
        Menu menu = new Menu(List.of(new Menuitem("돈까스",5000), new Menuitem("냉면",7000)));
        Cooking cooking = new Cooking();
        assertThatCode(() -> customer.order("만두",  menu, cooking))
                .doesNotThrowAnyException();


    }
}
