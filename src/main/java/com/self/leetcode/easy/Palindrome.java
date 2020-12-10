package com.self.leetcode.easy;

/*
 * 9. 回文数
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 121
 * 0也是回文数
 */
public class Palindrome {

	public static void main(String[] args) {
		System.out.println(0%10);
		System.out.println("1221是回文数吗" +  Palindrome.palindrome(1221));
		System.out.println("1221是回文数吗" +  Palindrome.palindrome1(0));
	}
	
	public static boolean palindrome(int x) {
		if (x <0) {
			 return false;
		}
		//如果x%10=0说明x是10的倍数,10 20 200 这种肯定不是回文数
		if (x!=0 && x %10==0) {
			return false;
		}
		String str = Integer.toString(x);
		int start = 0;//双指针,从俩头一个一个对比
		int end = str.length()-1;
		while (start<=end) {
			if (str.charAt(start) != str.charAt(end)) {
				return false;
			}
			start++;//往前走
			end --;//都往前走
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
