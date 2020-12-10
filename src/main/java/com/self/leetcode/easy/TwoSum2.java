package com.self.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;

/*
 * 167. 两数之和 II - 输入有序数组
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * 说明:
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 示例:
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 * 
 * 输入: numbers = [1, 2, 8, 11, 15], target = 26
 * 输出: [1, 3]
 * 
 * 输入: numbers = [1, 2, 7, 12], target = 7
 * 输出: [3, 4]
 */
public class TwoSum2 {
	
	public static void main(String[] args) {
		TwoSum2 ts = new TwoSum2();
		long start = System.currentTimeMillis();
		System.out.println(Arrays.toString(ts.twosun(new int []{2,7,11,15,16,49,99,100,101,102,103,104,105,106,107,108,109,110}, 229)));
		long end = System.currentTimeMillis();
		System.out.println("花费时间" + (end - start));
		System.out.println(Arrays.toString(ts.twosun1(new int []{2,7,11,15,16,49,99,100,101,102,103,104,105,106,107,108,109,110}, 229)));
		long end1 = System.currentTimeMillis();
		System.out.println("花费时间" + (end1 - end));
		System.out.println(Arrays.toString(ts.erFen(new int []{2,7,11,15,16,49,99,100,101,102,103,104,105,106,107,108,109,110}, 229)));
		long end2 = System.currentTimeMillis();
		System.out.println("花费时间" + (end2 - end1));
	}
	
	public int[] twosun(int[] arr, int target) {
		int[] res = new int[2];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int i=0;
		while (i<arr.length) {
			int resNum = target - arr[i];
			if (map.containsKey(resNum)) {
				res[0] = map.get(resNum) + 1;
			    res[1] = i + 1;
			} else {
				map.put(arr[i], i);
			}
			i++;
		}
		return res;
	}
	
	/**
	 * 双指针
	 * @param arr
	 * @param target
	 * @return
	 */
	public int[] twosun1(int[] arr, int target) {
		int[] res = new int[2];
		int start =0 , end = arr.length-1;
		while (start<= end) {
			int resNum = arr[start] + arr[end];
			if (resNum == target) {
				res[0] = start + 1;
			    res[1] = end + 1;
			    return res;
			} else if (resNum < target){//如果resNum比target小,只能start加1前进,因为arr[end]已经是最大值了,加了最大值还小,只能arr[target]前进,这是一个有序数组
				start++;
			} else {
				end--;
			}
		}
		return res;
	}
	
	/**
	 * 二分查找法(每次都从剩下的数组中间开始查找)
	 * (2,3]这个是左开右闭,是指大于2,小于等于3
	 * (10,20)是指10到20之间的实数,但是不包括10和20
	 * [10,20]是指10到20之间的实数,包括10和20
	 * 实数，是有理数和无理数的总称。
	 * 有理数:假如m和n都是整数,如果p=m/n,那么p就是有理数。在任意俩个有理数之间,都有无穷多个有理数.整数和分数(有限小数1.5,1.7,无限循环小数1.333333,1.2121212121)
	 * 无理数:不能比成俩个整数的比就是无理数,任意俩个有理数之间,也有无限多个无理数。无限不循环小数,比如1.414=根号2,1.17117117是无限不循环小数
	 * https://www.v2ex.com/t/732827#reply20
	 * java 官方的二分搜索之前也有这个 bug，没考虑溢出，后面被修复了。之前做 leetcode 也遇到过这个问题
	 * https://jdhao.github.io/2017/08/27/binary-search-overflow-issue/
	 * https://zhuanlan.zhihu.com/p/66254144
	 * https://www.cnblogs.com/morethink/p/8379475.html
	 * https://www.cnblogs.com/ider/archive/2012/04/01/binary_search.html
	 * @param arr
	 * @param target
	 * @return
	 */
	public int[] erFen(int[] arr, int target) {//这个实现方法很慢
		/*
		 * 二分查找中中间值的计算：
		 * 这是一个经典的话题，如何计算二分查找中的中值？大家一般给出了两种计算方法：
		 * 算法一： mid = (low + high) / 2
		 * 算法二： mid = low + (high – low)/2
		 * 乍看起来，算法一简洁，算法二提取之后，跟算法一没有什么区别。但是实际上，区别是存在的。算法一的做法，在极端情况下，(low + high)存在着溢出的风险，进而得到错误的mid结果，导致程序错误。而算法二能够保证计算出来的mid，一定大于low，小于high，不存在溢出的问题。
		 * int 类型
         * int 是一种数据类型，用于定义整数类型变量的标识符，是带符号整数。
         * 在现在对计算机中，int 占用 4 字节，32 比特，数据范围为：-2147483648 ~ 2147483647 [-2^31 ~ 2^31-1]。
         * 那么对于两个都接近 2147483647 的数字而言，它们相加的结果将会溢出，变成负数。
         * 所以，为了避免溢出情况的发生，我们不能使用 mid = (left + right) / 2 来计算 mid 值，而是使用 mid = left + (right - left) / 2 来作为替代。
		 */
		int c = 0;
		for (int i=0; i<arr.length; i++) {
			int low = i + 1;//从第二个数,因为第一个数直接拿去用了
			int high = arr.length - 1;//到最后一个数,因为数组下标是从0开始的
			while (low <= high) {
				c++;
				System.out.println("循环第" + c + "次");
//				int mid = (high - low) / 2 + low; 不能写(high + low) /2,这样会有一个值越界的情况
				int mid = low + ((high - low) >>1);//右移一位,跟上面的写法是一样的
				if (arr[mid] == target - arr[i]) {
					return new int[]{i+1, mid+1};
				} else if(arr[mid] > target - arr[i]){//如果中间这个数字比target - arr[i]还大,说明正确数字arr[mid]在左边,因为是升序数组,越往右边的越大
					high = mid - 1;//中间这个数减一
				} else {
					low = mid + 1;//中间这个数加1,因为答案肯定在mid右边,然后继续循环求中间数进行对比
				}
			}
			System.out.println("循环第" + c + "次");
			break;
		}
		return new int[]{-1, -1};
	}
}
