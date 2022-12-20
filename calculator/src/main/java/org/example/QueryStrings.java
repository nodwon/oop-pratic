package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//operand1=10&operator=-&operand2=55
public class QueryStrings {
    private List<QueryString> queryStrings = new ArrayList<>();
    // queryStringline�� ������ &�����ڸ� ������ ������ ��ü�� ������ �� ������ ��ü��  =  key value�� �ɰ����� List�� �ʱ�ȭ ����
    //operand1=10  operator=-  operand2=55
    public QueryStrings(String queryStringLine){
        String[] queryStringTokens = queryStringLine.split("&");
        Arrays.stream(queryStringTokens)
                .forEach(queryString ->{
                    String[] values = queryString.split("=");
                    if(values.length !=2){
                        throw new IllegalArgumentException("�߸��� QueryString ������ ���� ���ڿ��Դϴ�.");
                    }
                    queryStrings.add(new QueryString(values[0], values[1]));
                });
    }

    public String getValue(String key) {
        return this.queryStrings.stream()
                .filter(queryString -> queryString.exists(key))
                .map(QueryString::getValue)
                .findFirst()
                .orElse(null);
    }

}
