package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

/*
 * �䱸����
 * ������ ��Ģ������ �Ҽ� �ִ�.
 * ����θ� ����Ҽ� �ִ�.
 * ����������  0���� ������� illegealArguent ���ܸ� �߻���Ų��.
 * MVC ���� ������� ���Ѵ�.
 */
public class CalculatorTest {
    @DisplayName("���� ������ ���������� �����Ѵ�.")
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