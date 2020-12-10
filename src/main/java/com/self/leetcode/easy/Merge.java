package com.self.leetcode.easy;

import java.util.Arrays;

/*
 * 88. 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * 说明：
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例：
 * 输入：
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * 输出：[1,2,2,3,5,6]
 */
public class Merge {

	public static void main(String[] args) {
		Merge m = new Merge();
		m.merge(new int[]{2,4,5,0,0,0 }, 3, new int[]{1,8,9}, 3);
		System.out.println("************************************");
		System.out.println("下面这个肯定是max2先小于0,然后直接跳出循环了");
		m.merge(new int[]{1,2,3,0,0,0 }, 3, new int[]{4,5,6}, 3);
	}
	
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int maxIndex = m + n - 1;//俩个数组合并之后的最大值的下标索引位置
		int max1= m -1, max2=n-1;//各自数组的最大值的下标索引位置
		while(max1 >= 0 || max2>=0) {
			//谁大谁往后排,max1小于0,说明max1里面的值都往后移动了,第二个数组里面的小值要往前排,一直排到max2小于0说明第二个数组已经比较完了
			//由于nums1的数组长度肯定比nums2的数组长度达,所以max2肯定是先小于0的,max2小于0的时候,max1不一定小于0
			if (max1 < 0) {//如果第一个数组的下标已经小于0了,那么说明第一个数组的数组都已经往后移了
				nums1[maxIndex] = nums2[max2];
				max2--;
			} else if (max2 < 0) {//如果第二个数组下标小于0说明已经比完了,因为第一个数组的长度肯定比第二个数组的长度大
				break;
			} else if (nums1[max1] > nums2[max2]) {//如果第一个数组的最大值,大于第二个数组的最大值
				nums1[maxIndex] = nums1[max1];//把最的值放在数组最后的索引位置上
				max1--;//第一个数组的最大值的下标索引要减一,因为最大值已经挪走了
			} else {
				nums1[maxIndex] = nums2[max2];
				max2--;//第二个数组的最大值的下标索引要减一,因为最大值已经挪走了
			}
			System.out.println("max2:" + max2);
			System.out.println("max1:" + max1);
			System.out.println("----------------");
			maxIndex--;//第一次循环结束之后,合并后的数组最大值的索引已经有人占了,所以要减一,等待倒数第二位置
		}
		System.out.println("合并后的数组," + Arrays.toString(nums1));
	}
}
