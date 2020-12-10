package com.self.leetcode.easy;

/*
 * 125. 验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * 示例 1:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * 输入: "race a car"
 * 输出: false
 */
public class Palindrome2 {

	public static void main(String[] args) {
		//"A man, a plan, a canal: Panama" 和"A man, a plan, a canal: Panama"
		System.out.println("A man, a plan, a canal: Panama" +  Palindrome2.palindrome("A man, a plan, a canal: Panama"));
	}
	
	/**
	 * 使用双指针法
	 * @param str
	 * @return
	 */
	public static boolean palindrome(String str) {
		if(str.length()==0 || str.trim().length() ==0) {
			return true;//说明：本题中，我们将空字符串定义为有效的回文串。
		}
		int start = 0;
		int end = str.length()-1;
		while(start < end) {
			while (start<end && !Character.isLetterOrDigit(str.charAt(start))) {//不是字母或者数字,while循环可以把连续多个逗号都跳过去
				System.out.println("1:" + start);
				System.out.println("1:" + str.charAt(start));
				start++;
			}
			while (start<end && !Character.isLetterOrDigit(str.charAt(end))) {//不是字母或者数字
				end--;
			}
//			//用if判断不行,if循环只能跳过一个空格或者逗号或者别的特殊符号,比如a,,这个时候if判断只能跳过一个,然后下面的if取出来的就是逗号了
//			if (!Character.isLetterOrDigit(str.charAt(start))) {//不是字母或者数字
//				start++;
//			}
//			if (!Character.isLetterOrDigit(str.charAt(end))) {//不是字母或者数字
//				end--;
//			}
			if (Character.toLowerCase(str.charAt(start)) != Character.toLowerCase(str.charAt(end))) {//忽略大小写
				System.out.println(start);
				System.out.println(str.charAt(start));
				System.out.println(end);
				System.out.println(str.charAt(end));
				return false;
			}
			start ++;
			end --;
		}
		return true;
	}
	
	public static boolean palindrome1(int x) {
		if (x <0) {
			 return false;
		}
		//如果x%10=0说明x是10的倍数,10 20 200 这种肯定不是回文数
		if (x!=0 && x %10==0) {
			return false;
		}
		int a = x;
		int tmp =0;//把x的数字颠倒过来
		while(a != 0) {
			int carry = a % 10;//得到个位数
			tmp = tmp * 10 + carry;//把个位数放在最前面
			a = a/10;//把a这个值变小,等于说把个位数去掉,比如121/10=12
		}
		return x == tmp;
	}
	
	
	public static boolean isPalindrom2(int x) {
		if (x<0 || (x!=0 && x%10==0)) {
			return false;
		}
		int rev = 0;
		while(x>rev){
			rev = rev*10 + x%10;//rev 1 12
			x = x/10;//x 12 2
		}
		return (x==rev || x==rev/10);
	}
	
	
   public boolean isPalindrome(int x) {//字符串翻转
        String reversedStr = (new StringBuilder(x + "")).reverse().toString();
        return (x + "").equals(reversedStr);
   }

}
