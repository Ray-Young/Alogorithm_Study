package com.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



//\d 数字等价于[0-9]
//
//\D 非数字等价于[^0-9]
//
//\s 空白符号 [\t\n\x0B\f\r]
//
//\S 非空白符号 [^\t\n\x0B\f\r]
//
//\w 单独字符 [a-zA-Z_0-9]
//
//\W 非单独字符 [^a-zA-Z_0-9]
//		
//		加入特定限制条件「[]」
//
//		[a-z] 条件限制在小写a to z范围中一个字符
//
//		[A-Z] 条件限制在大写A to Z范围中一个字符
//
//		[a-zA-Z] 条件限制在小写a to z或大写A to Z范围中一个字符
//
//		[0-9] 条件限制在小写0 to 9范围中一个字符
//
//		[0-9a-z] 条件限制在小写0 to 9或a to z范围中一个字符
//
//		[0-9[a-z]] 条件限制在小写0 to 9或a to z范围中一个字符(交集)
//
//		[]中加入^后加再次限制条件「[^]」
//
//		[^a-z] 条件限制在非小写a to z范围中一个字符
//
//		[^A-Z] 条件限制在非大写A to Z范围中一个字符
//
//		[^a-zA-Z] 条件限制在非小写a to z或大写A to Z范围中一个字符
//
//		[^0-9] 条件限制在非小写0 to 9范围中一个字符
//
//		[^0-9a-z] 条件限制在非小写0 to 9或a to z范围中一个字符
//
//		[^0-9[a-z]] 条件限制在非小写0 to 9或a to z范围中一个字符(交集)






//将字符串中所有的空格和其他特殊字符移除
//方法一可以看做方法二的源代码

public class Regular_Expression {
	public static String removeSpaceByRegex(String str)
	{
		String regex= "[^[\\d]+[a-z]]"; 
		//String regex= "[^[a-z A-Z]$]";                      //这两个正则都成立
		//String regex="[^\\S+[a-z A-Z]$]"; 
		
		//[^[a-z A-Z]$]和[^a-z A-Z]是不同的
		//[^[a-z A-Z]$]的意思是匹配以a-z A-Z开头，a-z A-Z结尾的字符串
		//[^a-z A-Z]   的意思是匹配非a-z A-Z的字符串
		//[^\\w]       非字母
		//[^[\\w]]     字母
		//^字符在不加[]时候表示取非，在加了[]后表示以其开始
		Pattern pattern;
		Matcher matcher;
		pattern=Pattern.compile(regex);
		matcher=pattern.matcher(str);
		StringBuffer buffer=new StringBuffer();
		while(matcher.find())
		{
			buffer.append(matcher.group().trim());          //必须使用trim进行修剪，否则格式会混乱
		}
		String result = buffer.toString();
		//result=result.replaceAll("\\d", "");              //将“以数字开头”的字符串精简为只含a-z字母的字符串
		return result;
	}

	public static String removeSpaceByString(String str) {
		String Rstr;
		Rstr = str.replaceAll("[^a-z]", "");                //使用replace方法，将非a-z的所有字符排除
		return Rstr;
	}

	public static void main(String args[]) {
		
		System.out.println(removeSpaceByRegex("4242 a bv c. d e & f g%^&&*( f\\h i j"));
		//System.out.println(removeSpaceByRegex("a b c. d e& f g%^&&*( f\\h i j"));
		//System.out.println(removeSpaceByString("a b c. d e& f g%^&&*( f\\h i j"));

	}

}
