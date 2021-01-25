package com.self.leetcode.medium;

/*
 * 2. 两数相加
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 示例 1：
 * 输入：l1(第一个链表,实际的值是342,链表的顺序是个十百千万十万百万这样的顺序) = [2,4,3], l2(第二个链表,实际的值是465) = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 示例 2：
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 示例 3：
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 * 提示：
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 */
public class AddTwoNumbers {
	class ListNode {
		int val;
		ListNode next;
		ListNode() {
		}
		ListNode(int val) {
			this.val = val;
		}
		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}
	
	/*
	 * https://leetcode-cn.com/problems/add-two-numbers/solution/hua-jie-suan-fa-2-liang-shu-xiang-jia-by-guanpengc/
	 * 这个题解比这个简单
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		ListNode pre = new ListNode(0);
		ListNode curr = pre;//curr和pre指向的引用是同一个
		int carry = 0;//进位,相加如果大于10就要进一位
		
		while (l1 != null && l2 != null) {
			//链表的第一位都是个位数,第二位都是十位数,意思就是按照(个十百千万十万百万这样的顺序)来的
			int tmp = l1.val + l2.val + carry;
			int val = tmp % 10;//取余数,如果tmp大于10,说明要进1
			carry = tmp / 10; //取商,就是要进几位的意思
			curr.next = new ListNode(val);//第一位就已经算出来了,其实这里相当于pre.next
			curr = curr.next;//注意到这里curr和pre指向的引用就已经发生变化了,curr指向了一个新的对象地址
			
			l1 = l1.next;
			l2 = l2.next;
		}
		if (l1 != null) {//假如l1这个ListNode链表的长度比l2这个ListNode链表长度长
			while (l1 != null) {
				//链表的第一位都是个位数,第二位都是十位数,意思就是按照(个十百千万十万百万这样的顺序)来的
				int tmp = l1.val + carry;
				int val = tmp % 10;//取余数,如果tmp大于10,说明要进1
				carry = tmp / 10; //取商,就是要进几位的意思
				curr.next = new ListNode(val);//第一位就已经算出来了
				curr = curr.next;
				
				l1 = l1.next;
			}
		}
		
		if (l2 != null) {//假如l2这个ListNode链表的长度比l1这个ListNode链表长度长
			while (l2 != null) {
				//链表的第一位都是个位数,第二位都是十位数,意思就是按照(个十百千万十万百万这样的顺序)来的
				int tmp = l2.val + carry;
				int val = tmp % 10;//取余数,如果tmp大于10,说明要进1
				carry = tmp / 10; //取商,就是要进几位的意思
				curr.next = new ListNode(val);//第一位就已经算出来了
				curr = curr.next;
				
				l2 = l2.next;
			}
		}
		if (carry != 0) {//算到最后还是要进1
			curr.next = new ListNode(carry);
			curr = curr.next;
		}
		return pre.next;//不能返回pre,因为pre的val是0,所以只能返回pre.next,pre.next是第一个个位数
	}
	
	public static void main(String[] args) {
		AddTwoNumbers atn = new AddTwoNumbers();
		ListNode ln = atn.new ListNode();
		ListNode result = atn.addTwoNumbers(ln, ln);
	}
}
