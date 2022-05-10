package com.self.leetcode.medium;

/**
 * 5. 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 输入：s = "cbbd"
 * 输出："bb"
 * @author issuser
 */
public class LongestPalindrome {
	public static void main(String[] args) {
		System.out.println("正确答案是aba-》:" + method1("aabad"));
		System.out.println("正确答案是bab-》:" + method1("babad"));
		System.out.println("正确答案是aaaa-》:" + method1("aaaa"));
	}
	
	/**
	 * 动态规划就是以空间换时间的
	 * 但这个dp还是O(n^2)的，真的有必要用dp吗。去查找以每个字符为中心的最长回文串同样也是O(n^2)的，而且使用的空间更少。
	 * 如果真要更快的算法的话，直接manacher算法就可以O(n)了。疑问：manacher算法是什么算法？
	 * https://www.bilibili.com/video/BV1rX4y157Ve?spm_id_from=333.999.0.0
	 * @param str
	 * @return
	 */
	public static String method1(String str) {
		int len = str.length();
		if (len >= 1) {
			String maxStr = str.substring(0, 1);//假如str的长度为1,这就是默认的答案
			boolean[][] dp = new boolean[len][len];//默认都是false，
			for (int right = 1; right < len; right ++) {//找子串
				for (int left =0; left<right; left++) {
					if (str.charAt(left) != str.charAt(right)) {
						dp[left][right] = false;//把状态记下来,false不是回文串,
						continue;
					}
					if (left + 1 >= right -1) {//这里处理aa和aba这种情况,a和a中间只有一个字符或者a和a中间没有字符了,默认就是true
						dp[left][right] = true;//left,right属于回文串
					} else {//代码能走到else这里说明俩段肯定相等了一样了,肯定是addsa这种情况
						//dp[left][right]addsa是不是回问串,要看dp[left+1][right-1]dds是不是回文串
						//addsa这个字符串属不属于回文串,要看d(left+1)和s(right-1)是不是回文串
						//这里要特别注意,里面这个循环永远都是从0开始和Right对比的,最开始left是0,right1,第二次循环left是0,right是2，每次循环left都加1;
						//注意，你仔细思考,如果left是0right是3,那说明left为1活right为2肯定已经比过了.所以left+1,right-1肯定能取到值.
						dp[left][right] = dp[left+1][right-1];
					}
					if (dp[left][right] && (right - left + 1) > maxStr.length()) {
						maxStr = str.substring(left, right + 1);
					}
				}
			}
			return maxStr;
		} else {
			return "";
		}
	}
}
