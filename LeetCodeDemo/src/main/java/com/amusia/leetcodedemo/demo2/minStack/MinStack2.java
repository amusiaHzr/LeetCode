package com.amusia.leetcodedemo.demo2.minStack;

import com.amusia.leetcodedemo.PrintResult;

import java.util.HashMap;

/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *  
 * <p>
 * 示例:
 * <p>
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 * <p>
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 * <p>
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *  
 * <p>
 * 提示：
 * <p>
 * pop、top 和 getMin 操作总是在 非空栈 上调用。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-stack
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 2021-3-21 第二次练习
 */
public class MinStack2 {
    public static void main(String[] args) {
        CustomMinStack minStack = new CustomMinStack();
        minStack.push(0);
        minStack.push(1);
        minStack.push(0);
        PrintResult.print(minStack.getMin());
        minStack.pop();
        PrintResult.print(minStack.top());
        PrintResult.print(minStack.getMin());
    }

    static class CustomMinStack {
        Node head;

        public void push(int x) {
            if (head == null) {
                head = new Node(x, x);
            } else {
                //新存一个node元素，将x存入value，
                //比较x和head之中的min，取小存入新元素min
                //将新元素的next指向旧的head
                //将head赋值为新元素
                head = new Node(x, Math.min(head.min, x), head);
            }
        }

        public void pop() {
            //将当前链表的下一个元素作为链表头
            head = head.next;
        }

        public int top() {
            return head.value;
        }

        public int getMin() {
            return head.min;
        }
    }

    /**
     * 链表
     */
    public static class Node {
        int value;
        int min;
        Node next;

        public Node(int value, int min) {
            this(value, min, null);
        }

        public Node(int value, int min, Node next) {
            this.value = value;
            this.min = min;
            this.next = next;
        }
    }
}
