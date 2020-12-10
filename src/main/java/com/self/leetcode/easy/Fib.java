package com.self.leetcode.easy;

public class Fib {
	public static void main(String[] args) {
		Fib fib = new Fib();
		System.out.println("5的菲波那切数列为:" + fib.fib(7));
		System.out.println("5的菲波那切数列为:" + fib.fibSec(7));
		System.out.println("5的菲波那切数列为:" + fib.fibThird(7));
		System.out.println("60的菲波那切数列为:" + fib.fincache(30));
	}
	
	
	/**
	 * 菲波那切数列,从第二个数字开始,后面的数字等于前面俩个数字之和
	 * 0 1 1 2 3 5 8 13
	 * 第一种解决方法:傻递归,会做大量的重复计算
	 * @param n
	 * @return
	 */
	public int fib(int n){
		if (n<0) {
			return 0;
		}
		if (n ==0 || n ==1) {//递归退出条件,永远都不要忘记写
			return n;
		}
		return fib(n-1) + fib(n-2);
	}
	
	/*
	 * 第二种写法
	 * 空间换时间,动态规划,缺点空间有限
	 */
	public int fibSec(int n) {
		if (n<0) {
			return 0;
		}
		if (n ==0 || n ==1) {//递归退出条件,永远都不要忘记写
			return n;
		}
		//状态容器
		int[] sum = new int[n+1];//缺点,数组容器有限
		//初始化
		sum[0]=0;
		sum[1]=1;
		//状态转移方程
		for(int i=2;i<=n;i++){
			sum[i] = sum[i-1] + sum[i-2];
		}
		//返回结果
		return sum[n];
	}
	
	/*
	 * 第三种写法,这种最好
	 * 把容器删掉
	 * Time complexity: O(n)
	 * Space complexity: O(1)
	 */
	public int fibThird(int n){
		if (n<0) {
			return 0;
		}
		if (n ==0 || n ==1) {//递归退出条件,永远都不要忘记写
			return n;
		}
		//初始化
		int pre1 =0; 
		int pre2 =1;
		int res = 0;
		//状态转移方程
		for(int i=2;i<=n;i++) {
			res = pre1 + pre2;
			pre1 = pre2;//把pre2往前移
			pre2 = res;
		}
		return res;//返回结果
	}
	
	/*
	 * Time complexity: O(n)
	 * Space complexity: O(1)
	 */
	public int fibThour(int n){
		if (n<=1) {
			return n;
		}
		int a =0, b=1;
		while(n-- >1) {
			int sum = a + b;
			a = b;
			b = sum;
		}
		return b;
	}
	
	int[] fibArr = new int[31];
	public int fincache(int n) {
		if (n<=1) {
			return n;
		} else if (fibArr[n]!=0) {
			return fibArr[n];
		}else {
			return fibArr[n] = fincache(n-1) + fincache(n -2);
		}
	}
}
