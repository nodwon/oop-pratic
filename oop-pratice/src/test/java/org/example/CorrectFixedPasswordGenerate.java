package org.example;


public class CorrectFixedPasswordGenerate implements PasswordGeneratePolicy{
    @Override
    public String generatePassword() {
        return "abcdefgh"; //8±ÛÀÚ
    }
}
