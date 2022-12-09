package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/*
 * 요구사항
 * 간단한 사칙연산을 할수 있다.
 * 양수로만 계산할수 있다.
 * 나눗셈에서  0으로 나눈경우 illegealArguent 예외를 발생시킨다.
 * MVC 패턴 기반으로 구한다.
 */
public class CalculatorTest {
    @DisplayName("덧셈 연산을 정상적으로 수행한다.")
    @Test
    @MethodSource("formulaAndResult")
    void additionTest(int operand1, String operater, int operand2, int result) {

        int calculateResult = Calculator.calculate(operand1,operater,operand2);

        assertThat(result).isEqualTo(result);
    }

    private static Stream<Arguments> formulaAndResult(){
        return Stream.of(
                arguments(1,"+",2,3),
                arguments(1,"-",2,-1),
                arguments(4,"*",2,8),
                arguments(4,"/",2,2)
        );
    }
}
