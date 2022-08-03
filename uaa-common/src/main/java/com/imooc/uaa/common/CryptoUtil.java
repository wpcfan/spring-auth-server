package com.imooc.uaa.common;

import lombok.val;
import org.passay.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
public class CryptoUtil {

    public String randomAlphanumeric(int targetStringLength) {
        int leftLimit = 48; // 数字 '0'
        int rightLimit = 122; // 字母 'z'
        val random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
            .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97)) // 过滤掉 Unicode 65 和 90 之间的字符
            .limit(targetStringLength)
            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
            .toString();
    }

    public String buildDefaultPassword() {
        val passwordGenerator = new PasswordGenerator();
        val password = passwordGenerator.generatePassword(8,
            // 至少有一个大写字母
            new CharacterRule(EnglishCharacterData.UpperCase, 1),
            // 至少有一个小写字母
            new CharacterRule(EnglishCharacterData.LowerCase, 1),
            // 至少有一个数字
            new CharacterRule(EnglishCharacterData.Digit, 1),
            // 至少有一个特殊字符
            new CharacterRule(EnglishCharacterData.Special, 1));
        if (!validatePassword(password)) {
            buildDefaultPassword();
        }
        return password;
    }

    public boolean validatePassword(String password) {
        val validator = new PasswordValidator(getPasswordRules());
        val result = validator.validate(new PasswordData(password));
        return result.isValid();
    }

    public List<Rule> getPasswordRules() {
        return Arrays.asList(
            // 长度规则：8 - 30 位
            new LengthRule(8, 30),
            // 至少有一个大写字母
            new CharacterRule(EnglishCharacterData.UpperCase, 1),
            // 至少有一个小写字母
            new CharacterRule(EnglishCharacterData.LowerCase, 1),
            // 至少有一个数字
            new CharacterRule(EnglishCharacterData.Digit, 1),
            // 至少有一个特殊字符
            new CharacterRule(EnglishCharacterData.Special, 1),
            // 不允许连续 3 个字母，按字母表顺序
            // alphabetical is of the form 'abcde', numerical is '34567', qwery is 'asdfg'
            // the false parameter indicates that wrapped sequences are allowed; e.g. 'xyzabc'
            new IllegalSequenceRule(EnglishSequenceData.Alphabetical, 5, false),
            // 不允许 3 个连续数字
            new IllegalSequenceRule(EnglishSequenceData.Numerical, 5, false),
            // 不允许 QWERTY 键盘上的三个连续相邻的按键所代表的字符
            new IllegalSequenceRule(EnglishSequenceData.USQwerty, 5, false),
            // 不允许包含空格
            new WhitespaceRule());
    }
}
