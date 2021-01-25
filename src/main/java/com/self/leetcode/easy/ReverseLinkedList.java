package com.self.leetcode.easy;


/**
 * 206. 反转链表
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 *  你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * @author dell
 */
public class ReverseLinkedList {
	public static void main(String[] args) {
		ReverseLinkedList rli = new ReverseLinkedList();
		ListNode ln = rli.new ListNode(1);
		
		ListNode ln2 = rli.new ListNode(2);
		ln.next = ln2;
		ListNode ln3 = rli.new ListNode(3);
		ln2.next = ln3;
		ListNode ln4 = rli.new ListNode(4);
		ln3.next = ln4;
		ListNode ln5 = rli.new ListNode(5);
		ln4.next = ln5;
		
		ListNode resultList  = rli.reverseList(ln);
		while(resultList != null) {
			System.out.println(resultList.val);
			resultList = resultList.next;
		}
	}
	
	/*
	 * https://leetcode-cn.com/problems/reverse-linked-list/solution/dong-hua-yan-shi-206-fan-zhuan-lian-biao-by-user74/
	 * 看题解把递归解法写出来
	 */
	public ListNode reverseList(ListNode head) {
		ListNode pre = null;
		ListNode curr = head;
		while(curr != null){
			ListNode next = curr.next;
			/*
			 * 本来是1->2->3->4->5->NULL
			 * 第一次循环的时候pre=null
			 */
			curr.next = pre;//这行代码的意思是null<-1 2->3->4->5->NULL,下次循环就变成null<-1<-2 3->4->5->NULL,
			pre = curr;//把1赋值给pre,下次循环pre就会变成2
			curr = next;//把2赋值给curr,下次循环curr就会变成3
		}
		return pre;
	}
	
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
}
