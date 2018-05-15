package com.demo.base.algorithm.stack;

import java.util.Stack;

/**
 * 有限个临时变量将栈数据反转
 * 使用递归
 * Created by yangyuan on 5/15/18.
 */
public class ReverseStack {

    public static <E> void reverseStack2(Stack<E> s){
        if(s.isEmpty() || s.size() == 1){
            return;
        }//退出条件
        if(s.size() == 2){
            E temp1 = s.pop();
            E temp2 = s.pop();
            s.push(temp1);
            s.push(temp2);
            return;
        }
        E temp1 = s.pop();
        reverseStack2(s);
        E temp2 = s.pop();
        reverseStack2(s);
        s.push(temp1);
        reverseStack2(s);
        s.push(temp2);
    }

    public static void main(String[] args) {
        Stack<Integer>  stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack);
        reverseStack2(stack);
        System.out.println(stack);
    }
}
