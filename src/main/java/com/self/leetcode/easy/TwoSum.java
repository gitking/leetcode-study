package com.self.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;

/*
 * 1. 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * 示例:给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class TwoSum {
	public static void main(String[] args) {
		TwoSum ts = new TwoSum();
		System.out.println(Arrays.toString(ts.twosun(new int []{2,7,11,15}, 9)));
		System.out.println(Arrays.toString(ts.twosun1(new int []{2,7,11,15}, 9)));
	}
	
	public int[] twosun(int[] arr, int target) {
		int[] res = new int[2];
		if (arr.length<=1) {
			return res;
		}
		for(int i=0; i<arr.length; i++) {//暴力破解,效率很低
			for(int j=i+1; j<arr.length; j++) {//数组中的数字只能用一次,所以这里从i+1开始
				if(target == arr[i] + arr[j]) {
					res[0] = i;
					res[1] = j;
					return res;
				}
			}
		}
		return res;
	}
	
	public int[] twosun1(int[] arr, int target) {
		int[] res = new int[2];
		if (arr.length<=1) {
			return res;
		}
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0; i<arr.length; i++) {//循环一次就行了
			int tem = arr[i];//把数组下标对应的数字保留下来
			int num = target - tem;
			if (map.containsKey(num)) {
				res[0] = i;
				res[1] = map.get(num);
				return res;
			} else {
				map.put(tem, i);//把数组里面的数字和数字对应的下标放进去
			}
		}
		return res;
	}
}
