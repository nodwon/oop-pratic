package org.example;

public class User {
    private String password;
    public void initPassword(PasswordGeneratePolicy passwordGeneratePolicy){
        //기존에서는 랜덤패스워드를 안에 생성했다면 조건에 맞게 초기화 됬지만 이러한경우 테스틀할경우 그것을 컨트롤 할수 없지만
        //실제 코드에서는 randompassword를 넣고 test트할경우 고정해서 넣는다.
        //RandomPasswordGenerator randomPasswordGenerator = new RandomPasswordGenerator();
        // 테스트 코드를 통과못하는경우가 생긴경우  randomPasswordGenerator 몇글자를 생성할지 모르기 때문이다.
        //내부에생성한 강한 결합이생기므로 인터페이스를 생성하여 결합도를 낮춘다.
        String password = passwordGeneratePolicy.generatePassword();
        /*
        비밀번호는 최소 8자이상 12자이하여야한다.
         */
        if(password.length() >=8 && password.length()<=12){
            this.password = password;
        }
    }
    public String getPassword(){
        return password;
    }
}
