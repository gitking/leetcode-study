package com.self.leetcode.easy;

/*
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 * 示例 1：
 * 输入： 2
 * 输出： 2
 *	解释： 有两种方法可以爬到楼顶。
 *	1.  1 阶 + 1 阶
 * 	2.  2 阶
 * 示例 2：
 * 输入： 3
	输出： 3
	解释： 有三种方法可以爬到楼顶。
	1.  1 阶 + 1 阶 + 1 阶
	2.  1 阶 + 2 阶
	3.  2 阶 + 1 阶
 * 这道题跟菲波那切数列是一个意思 
 */
public class ClimbStairs {
	public static void main(String[] args) {
		ClimbStairs cs = new ClimbStairs();
		long start = System.currentTimeMillis();
		int res = cs.climbStairs(45);
		long end = System.currentTimeMillis();
		System.out.println("结果:" + res + ",花费时间:" + (end-start) + "毫秒");
		
		int res1 = cs.climbStairs1(45);
		long end1 = System.currentTimeMillis();
		System.out.println("结果:" + res1 + ",花费时间:" + (end1-end) + "毫秒");
		
		int res2 =  cs.climbStairs2(45);
		long end2 = System.currentTimeMillis();
		System.out.println("结果:" + res2 + ",花费时间:" + (end2-end1) + "毫秒");
	}
	
	
	/**
	 * 动态规划
	 * 假如有10个台阶,你最终到第10个台阶的方式只有俩种,要么是从第9个台阶，一次上一个台阶上到第10个台阶,
	 * 要么是从第8个台阶,一次上俩个台阶,上到第10个台阶,所以你想到第10个台阶,你首先需要到达第8个台阶或者第9个台阶。所以你上到第10个台阶的方法就等于你上到第8个台阶的总方法加上
	 * 你上到第9个台阶的总方法.
	 * @param n
	 * @return
	 */
	public int climbStairs(int n) {
		if (n < 1) {
			return 1;
		}
		if (n==1) {
			return n;
		}
		if (n==2) {
			return n;
		}
		int[] arr = new int[n];//假设有n个台阶，数组容量有限,内存有限
		arr[0] = 1;
		arr[1] = 2;
		for (int i=2;i<arr.length;i++) {
			arr[i] = arr[i-2] + arr[i-1];
		}
		return arr[n-1];
	}
	
	
	
	/**
	 * 这个方法更好,节省内存空间
	 * 动态规划
	 * 假如有10个台阶,你最终到第10个台阶的方式只有俩种,要么是从第9个台阶，一次上一个台阶上到第10个台阶,
	 * 要么是从第8个台阶,一次上俩个台阶,上到第10个台阶,所以你想到第10个台阶,你首先需要到达第8个台阶或者第9个台阶。所以你上到第10个台阶的方法就等于你上到第8个台阶的总方法加上
	 * 你上到第9个台阶的总方法.
	 * @param n
	 * @return
	 */
	public int climbStairs1(int n) {
		if (n < 1) {
			return 1;
		}
		if (n==1) {
			return n;
		}
		if (n==2) {
			return n;
		}
		int pre = 1;
		int prepre = 2;
		int res = 0;
		for (int i=2; i<n; i++) {
			res = pre + prepre;
			pre = prepre;
			prepre = res;
		}
		return res;
	}
	
	
	/**
	 * 傻递归的方式,会做大量的重复计算
	 * @param n
	 * @return
	 */
	public int climbStairs2(int n) {
		if (n < 1) {
			return 1;
		}
		if (n ==1) {
			return n;
		}
		if(n ==2) {
			return n;
		}
		return climbStairs2(n-1) + climbStairs2(n-2);
	}
}
