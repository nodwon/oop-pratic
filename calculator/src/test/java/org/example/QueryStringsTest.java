package org.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
//operand1=10&operator=-&operand2=55
public class QueryStringsTest {


    @Test
    void createTest() {
        //QueryString�� �Ѱ��ε�
        // �������� �������� list���·� �����;��Ѵ�
        QueryStrings queryStrings = new QueryStrings("operand1=10&operator=-&operand2=55"); // �������� queryString�� ����
        //List<QueryString>

        assertThat(queryStrings).isNotNull();
    }
}
