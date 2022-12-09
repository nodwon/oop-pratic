package org.example;

public class User {
    private String password;
    public void initPassword(PasswordGeneratePolicy passwordGeneratePolicy){
        //���������� �����н����带 �ȿ� �����ߴٸ� ���ǿ� �°� �ʱ�ȭ ������ �̷��Ѱ�� �׽�Ʋ�Ұ�� �װ��� ��Ʈ�� �Ҽ� ������
        //���� �ڵ忡���� randompassword�� �ְ� testƮ�Ұ�� �����ؼ� �ִ´�.
        //RandomPasswordGenerator randomPasswordGenerator = new RandomPasswordGenerator();
        // �׽�Ʈ �ڵ带 ������ϴ°�찡 ������  randomPasswordGenerator ����ڸ� �������� �𸣱� �����̴�.
        //���ο������� ���� �����̻���Ƿ� �������̽��� �����Ͽ� ���յ��� �����.
        String password = passwordGeneratePolicy.generatePassword();
        /*
        ��й�ȣ�� �ּ� 8���̻� 12�����Ͽ����Ѵ�.
         */
        if(password.length() >=8 && password.length()<=12){
            this.password = password;
        }
    }
    public String getPassword(){
        return password;
    }
}
