package leetcode.editor.cn;

import java.util.Objects;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class MinStack {
    Stack<Integer> stackMin;
    Stack<Integer> stackValue;
    public MinStack() {
        stackMin = new Stack<>();
        stackValue = new Stack<>();
    }
    
    public void push(int val) {
        stackValue.push(val);
        if (stackMin.empty() || stackMin.peek() >= val) stackMin.push(val);
    }
    
    public void pop() {
        if (stackValue.peek().equals(stackMin.peek())) stackMin.pop();
        stackValue.pop();
    }
    
    public int top() {
        return stackValue.peek();
    }
    
    public int getMin() {
        return stackMin.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)
