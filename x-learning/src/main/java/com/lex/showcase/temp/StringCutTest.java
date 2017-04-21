package com.lex.showcase.temp;

import java.io.UnsupportedEncodingException;

/**
 * 字符串截取及简单地修复潜在乱码问题测试
 */
public class StringCutTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        final int len = 30;
        final String name = "你好啊基本原理虹口区哈哈呵呵u中uvwxyz";
        final byte[] gbkBytes = name.getBytes("GBK");

        System.out.println(gbkBytes.length);
        String nameCut = new String(gbkBytes, 0, len, "GBK");
        System.out.println("nameCut: " + nameCut);

        char endChar = nameCut.charAt(nameCut.length() - 1);
        System.out.println("endChar: " + endChar);
        String endCharacter = nameCut.substring(nameCut.length() - 1);
        System.out.println("endCharacter: " + endCharacter);
        System.out.println("endCharacter bytes length: " + endCharacter.getBytes("GBK").length);

        if (endCharacter.getBytes("GBK").length != 1) {
            return;
        }

        if (Character.isDigit(endChar) || Character.isAlphabetic(endChar)){
            System.out.println("endCharacter is not Chinese!");
        } else {
            System.out.println("endCharacter is messy code!");
        }

        System.out.println(Character.isAlphabetic('a'));

    }
}
