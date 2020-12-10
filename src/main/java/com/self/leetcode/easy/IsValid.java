package com.self.leetcode.easy;

import java.util.Stack;

/*
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 1.左括号必须用相同类型的右括号闭合。
 * 2.左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * 示例 1:
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * 输入: "()[]{}"
 * 输出: true
 * 输入: "{[]}"
 * 输出: true
 */
public class IsValid {
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (char ch : s.toCharArray()) {
			if (ch == '(') {//s这个字符串,第一个字符只能是左边的小括号
				stack.push(')');
			} else if(ch =='[') {//s这个字符串,第一个字符只能是左边的中括号
				stack.push(']');
			} else if (ch == '{'){//s这个字符串,第一个字符只能是左边的大括号
				stack.push('}');
			} else {//如果走到这里由俩种情况,第一种是s这个字符开头第一个字符就是非法的,第二种情况,是s的这个字符里面的右括号走到这里了
				if (stack.isEmpty()) {//如果走到这里,stack还是空的,说明s这个字符串开头的第一个字符就是非法的,直接返回false
					return false;
				}
				if (stack.pop() != ch) {//第二种情况才能走到这里,那说明ch这个字符肯定是右括号,第一个右括号对应的肯定是左括号,stack里面放的都是右括号,如果不相等直接return false
					return false;
				}
			}
		}
		return stack.isEmpty();
	}
}
