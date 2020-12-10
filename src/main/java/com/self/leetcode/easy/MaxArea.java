package com.self.leetcode.easy;

/*
 * 11. 盛最多水的容器
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 说明：你不能倾斜容器。
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49 
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * 示例 2：
 * 输入：height = [1,1]
 * 输出：1
 * 示例 3：
 * 输入：height = [4,3,2,1,4]
 * 输出：16
 * 示例 4：
 * 输入：height = [1,2,1]
 * 输出：2
 */
public class MaxArea {
	public static void main(String[] args) {
		MaxArea ma = new MaxArea();
		System.out.println(ma.maxArea(new int[]{4,3,2,1,4}));//这个最大的应该是16
		System.out.println(ma.maxArea(new int[]{3,2,1,4,4}));//这个最大的应该是12(数组元素3*数组元素3的下标到最后一个数组4的下标)
		System.out.println(ma.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));//这个最大的应该是49
	}
	
	/*
	 * 关于数组的题有一个很经典的套路就是双指针法
	 * 面积等于 长(数组里面的元素的值) * 宽(数组俩个索引之间的距离)
	 */
	public int maxArea(int[] arr){
		int max = 0;//最大面积
		int startIndex = 0;
		int endIndex = arr.length - 1;
		while (startIndex < endIndex) {//俩个指针不能重合(等于),如果俩个指针重合(等于)了,那面积就是0了
			int min = Math.min(arr[startIndex], arr[endIndex]);//长(数组里面的小那个元素)
			int chang = endIndex - startIndex;
			int temMax = chang * min;//先算出来一个面积
			max = Math.max(max, temMax);//永远保存大的那一个
			if (arr[startIndex] < arr[endIndex]) {//谁小把谁扔掉往前挪,小的乘出来肯定也是最小的
				startIndex++;
			} else if(arr[startIndex] > arr[endIndex]){
				endIndex--;
			} else {
				startIndex++;
				endIndex--;
			}
		}
		return max;
	}
}
