package com.lex.showcase.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo {

	public static void main(String[] args) {
		String regex = "(get|is)([A-Z]\\w*)";
		Pattern pattern = Pattern.compile(regex);
//		Matcher matcher = pattern.matcher("getName");
		Matcher matcher = pattern.matcher("getName");
		if (matcher.find() && matcher.matches()) {
			System.out.println(matcher.matches());
			System.out.println(matcher.group(0));
			System.out.println(matcher.group(1));
			System.out.println(matcher.group(2));
		}
		
		// 匹配给定的任意单个字符
//		regex = "(w.x)";
		regex = "(t[aeiou]m)";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher("tam");
		if (matcher.find() && matcher.matches()) {
			System.out.println(matcher.matches());
			System.out.println(matcher.group(0));
			System.out.println(matcher.group(1));
		}
		
		// 匹配重复出现次数
		regex = "\\(?\\d{3|4}\\)?.(\\d{8})";
		pattern = Pattern.compile(regex);
//		matcher = pattern.matcher("021-28961280"); // "(021)-28961280"
		matcher = pattern.matcher("0731-28961280"); // "(021)-28961280"
		if (matcher.find() && matcher.matches()) {
			System.out.println(matcher.matches());
			System.out.println(matcher.group(0));
//			System.out.println(matcher.group(1));
		}
	}

}
