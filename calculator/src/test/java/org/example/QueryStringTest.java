package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
public class QueryStringTest {


    @Test
    void createTest() {
        //QueryString은 한개인데
        // 여러개를 받을려면 list형태로 가져와야한다
        QueryString queryString = new QueryString("operand1","11");

        assertThat(queryString).isNotNull();
    }
}
