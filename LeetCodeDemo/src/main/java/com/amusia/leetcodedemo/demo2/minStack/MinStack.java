package com.amusia.leetcodedemo.demo2.minStack;

import com.amusia.leetcodedemo.PrintResult;

import java.util.Stack;

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
 *
 * 2021-3-20 第一次练习
 */
public class MinStack {
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


    /**
     * 使用辅助栈
     */
//    static class CustomMinStack {
//        Stack<Integer> dataStack;
//        Stack<Integer> minStack;
//
//        public CustomMinStack() {
//            dataStack = new Stack<>();
//            minStack = new Stack<>();
//        }
//
//        public void push(int x) {
//            dataStack.push(x);
//            if (minStack.isEmpty() || x <= minStack.peek()) {
//                minStack.push(x);
//            }
//        }
//
//        public void pop() {
//            int data = dataStack.pop();
//            if (data == minStack.peek()) {
//                minStack.pop();
//            }
//        }
//
//        public int top() {
//            return dataStack.peek();
//        }
//
//        public int getMin() {
//            return minStack.peek();
//        }
//    }

    /**
     * 通过自定义stack元素实现
     */
//    static class CustomMinStack {
//        Stack<Node> stack;
//
//        public CustomMinStack() {
//            stack = new Stack<>();
//        }
//
//        public void push(int x) {
//            if (stack.isEmpty()) {
//                stack.push(new Node(x, x));
//            } else {
//                stack.push(new Node(x, Math.min(stack.peek().min, x)));
//            }
//        }
//
//        public void pop() {
//            stack.pop();
//        }
//
//        public int top() {
//            return stack.peek().value;
//        }
//
//        public int getMin() {
//            return stack.peek().min;
//        }
//
//
//    }
//
//    static class Node {
//        int value;
//        int min;
//
//        public Node(int value, int min) {
//            this.value = value;
//            this.min = min;
//        }
//    }

    /**
     * 通过单链表实现
     */
    static class CustomMinStack {
        Node head;

        public void push(int x) {
            if (head == null) {
                head = new Node(x, x);
            } else {
                head = new Node(x, Math.min(x, head.min), head);
            }
        }

        public void pop() {
            head = head.next;
        }

        public int top() {
            return head.value;
        }

        public int getMin() {
            return head.min;
        }
    }

    static class Node {
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
