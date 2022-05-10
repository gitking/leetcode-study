package com.self.leetcode.easy;

import java.util.Arrays;

public class BubbleSort {
	public static void main(String[] args) {
		/*
		 * 对数组进行排序是程序中非常基本的需求。常用的排序算法有冒泡排序、插入排序和快速排序等。
		 * 我们来看一下如何使用冒泡排序算法对一个整型数组从小到大进行排序：
		 * 冒泡排序的特点是，每一轮循环后，最大的一个数被交换到末尾，因此，下一轮循环就可以“刨除”最后的数，每一轮循环都比上一轮循环的结束位置靠前一位。
		 */
		int[] nsSort = { 28, 12, 89, 73, 65, 18, 96, 50, 8, 36 };
        // 排序前:
        System.out.println("冒泡排序前:" + Arrays.toString(nsSort));
        for (int i = 0; i < nsSort.length - 1; i++) {//nsSort数组中的每一个数字,都需要跟除了自己之外的所有人都对比一遍,所以循环次数是nsSort.length - 1。
        	//外围循环，循环一次就已经把最大的数字放到最后了,所以外层循环每循环一次,内层循环都可以减少一次循环次数。
            for (int j = 0; j < nsSort.length - i - 1; j++) {
                if (nsSort[j] > nsSort[j+1]) {
                    // 交换ns[j]和ns[j+1]:
                    int tmp = nsSort[j];
                    nsSort[j] = nsSort[j+1];
                    nsSort[j+1] = tmp;
                }
            }
            System.out.println("外层循环第" + i + "次,发现最大的数为:" + nsSort[nsSort.length-i-1]);
        }
        // 排序后:
        System.out.println("冒泡排序前:" + Arrays.toString(nsSort));
	}
}
