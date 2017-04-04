package com.lex.showcase.algorithm.interview;


import java.util.Scanner;

/**
 * 阿里在线笔试题 附加题3
 * 求两个字符串最大的连续出现的公共部分 列如query为acbac，text为acaccbabb那么公共子串为cba 长度为3
 */
public class FindMaxSubString {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("请输入query");
/*String str1 = "acbac";
String str2 = "acaccbabb";
*/
        String str1 = s.nextLine();
        System.out.println("请输入text");
        String str2 = s.nextLine();
        String result = getMaxString(str1, str2);
        if (result != null) {
            System.out.println(result.length());
        } else {
            System.out.println("没有公共子串");
        }
    }

    private static String getMaxString(String str1, String str2) {
        String max = null;
        String min = null;
        max = (str1.length() > str2.length() ? str1 : str2);
        min = max.equals(str1) ? str2 : str1;
        for (int i = 0; i < min.length(); i++) {
            for (int start = 0, end = min.length() - i; end != min.length() + 1; start++, end++) {
                String sub = min.substring(start, end);
                if (max.contains(sub))
                    return sub;
            }
        }
        return null;
    }
}
