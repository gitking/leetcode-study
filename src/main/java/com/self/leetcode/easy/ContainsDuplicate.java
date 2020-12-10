package com.self.leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;

/*
 * 217. 存在重复元素
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 */
public class ContainsDuplicate {
	
	public static void main(String[] args) {
		int[] arr = new int[]{1,2,3,1};
		System.out.println("数组中是否存在重复元素:" + containsDuplicate(arr));
		System.out.println("数组中是否存在重复元素:" + containsDuplicate1(arr));
	}
	
	public static boolean containsDuplicate(int[] nums) {
		HashSet<Integer> setArr = new HashSet<Integer>();
		for (int num: nums) {
			setArr.add(num);
		}
		return setArr.size() < nums.length;
	}
	
	public static boolean containsDuplicate3(int[] nums) {
		HashSet<Integer> setArr = new HashSet<Integer>();
		for (int num: nums) {
			if (setArr.contains(num)) {
				return true;
			}
			setArr.add(num);
		}
		return false;
	}
	
	public static boolean containsDuplicate4(int[] nums) {
		for (int i=0;i<nums.length;i++) {
			for(int j=i+1; j<nums.length; j++) {
				if (nums[i] == nums[j]) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean containsDuplicate1(int[] nums) {
		 return nums.length != Arrays.stream(nums)
	             .distinct()
	             .count();
	}
}
