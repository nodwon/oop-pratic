package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//operand1=10&operator=-&operand2=55
public class QueryStrings {
    private List<QueryString> queryStrings = new ArrayList<>();
    // queryStringline이 들어오면 &연산자를 가지고 세가지 객체로 나누고 그 세가지 객체를  =  key value로 쪼갠다음 List에 초기화 해줌
    //operand1=10  operator=-  operand2=55
    public QueryStrings(String queryStringLine){
        String[] queryStringTokens = queryStringLine.split("&");
        Arrays.stream(queryStringTokens)
                .forEach(queryString ->{
                    String[] values = queryString.split("=");
                    if(values.length !=2){
                        throw new IllegalArgumentException("잘못된 QueryString 포맷을 가진 문자열입니다.");
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
