package org.example.calculator.domain;
import org.example.calculator.tobe.AdditionOperator;
import org.example.calculator.tobe.ArithmeticOperator;
import org.example.calculator.tobe.DivisionOperator;
import org.example.calculator.tobe.SubtractionOperator;

import java.util.Arrays;
import java.util.List;

public class Calculator {
    private static final List<ArithmeticOperator> arithmeticOperators = Arrays.asList(new AdditionOperator(), new DivisionOperator(), new SubtractionOperator());
    /**
     *     private static final List<ArithmeticOperator> arithmeticOperators = list.of(new AdditionOperator(), new DivisionOperator(), new SubtractionOperator());
     * ������ ��Ģ������ �� �� �ִ�.
     * ����θ� ����� �� �ִ�.
     * ���������� 0�� ������ ��� IllegalArgument ���ܸ� �߻���Ų��. MVC����(Model-View-Controller) ������� �����Ѵ�
     */
    public static int calculate(PositiveNumber positiveOperand1, String operator, PositiveNumber positiveOperand2) {
        try {
            Thread.sleep(5_000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return arithmeticOperators.stream()
                .filter(arithmeticOperator -> arithmeticOperator.supports(operator))
                .map(arithmeticOperator -> arithmeticOperator.calculate(positiveOperand1, positiveOperand2))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("�ùٸ� ��Ģ������ �ƴմϴ�."));
    }
}
