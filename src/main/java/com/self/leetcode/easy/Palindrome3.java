package com.self.leetcode.easy;

/*
 * 680. 验证回文字符串 Ⅱ
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * 示例 1: 输入: "aba" 输出: True
 * 示例 2: 输入: "abca" 输出: True 解释: 你可以删除c字符
 * 注意:字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
 */
public class Palindrome3 {
	public static void main(String[] args) {
		Palindrome3 p3 = new Palindrome3();
		System.out.println(p3.palindrome("abcdcdcbxa"));
		System.out.println(p3.palindrome("abcbxa"));
	}
	/**
	 * 使用双指针法
	 * @param str
	 * @return
	 */
	public static boolean palindrome(String str) {
		int start = 0;
		int end = str.length()-1;
		while(start < end) {
			if (str.charAt(start) == str.charAt(end)) {//忽略大小写
				start ++;
				end --;
			} else {
				/*
				 * 如果不相等把剩下的字符串再当成一个字符串,再验证一次这个字符串是否是回文字符串就行了
				 * 如果不相等把左边的删一个或者右边的删一个,如果左右都删了,还不是回文字符串,那就肯定不是回文字符串了。
				 * 比如abcbxa->把俩边的a删了,在验证一次bcbx,把左边的删一个或者右边的删一个,看看还是不是回文字符串
				 */
				return palindrome1(str, start+1, end) || palindrome1(str, start, end -1);
			}
		}
		return true;
	}
	
	/*
	 * 这个方法验证严格回文字符串,aba就是回文数,abac就不是回文字符串
	 */
	public static boolean palindrome1(String str, int i, int j) {
		while(i<=j) {
			if (str.charAt(i) == str.charAt(j)) {
				i++;
				j--;
			} else {//不一样直接返回false
				return false;
			}
		}
		return true;
	}
}
