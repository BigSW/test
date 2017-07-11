package com.core.regular_expression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionTest {
	public static void main(String[] args) {
		/*
		 * String str = "18854992409";
		 * String regex = "^1[3|5|7|8][0-9]\\d{8}$";
		 */

		String str = "028-88888888";
		String regex = "\\d{3}-\\d{8}|\\d{4}-\\d{7}";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		boolean flag = matcher.matches();
		System.out.println(flag);

	}
}
