package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
//operand1=10&operator=-&operand2=55
public class QueryStringsTest {


    @Test
    void createTest() {
        //QueryString은 한개인데
        // 여러개를 받을려면 list형태로 가져와야한다
        QueryStrings queryStrings = new QueryStrings("operand1=10&operator=-&operand2=55"); // 여러개의 queryString을 가짐
        //List<QueryString>

        assertThat(queryStrings).isNotNull();
    }
}
