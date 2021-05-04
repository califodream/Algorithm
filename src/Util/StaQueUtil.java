package Util;

import java.util.Stack;

public class StaQueUtil<T> {

    Stack<T> stack1 = new Stack<>();
    Stack<T> stack2 = new Stack<>();

    public static void main(String[] args) {
        StaQueUtil<Integer> util = new StaQueUtil<>();
        util.biStackQueuePush(1);
        System.out.println(util.biStackQueuePop());
        util.biStackQueuePush(2);
        util.biStackQueuePush(3);
        System.out.println(util.biStackQueuePop());
        System.out.println(util.biStackQueuePop());
        System.out.println(util.biStackQueuePop());
    }

    public void biStackQueuePush(T node) {
        stack1.push(node);
    }

    public T biStackQueuePop() {
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

}
