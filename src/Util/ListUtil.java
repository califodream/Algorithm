package Util;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Stack;

public class ListUtil {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 6; i++) {
            linkedList.add(i);
        }
        ListUtil.reverseLinkedList(linkedList);
    }

    /**
     * Timing: 12ms Memory: 9MB
     */
    public static <T> void reverseLinkedList(LinkedList<T> linkedList) {
        Stack<T> stack = new Stack<>();
        ListIterator<T> listIterator = linkedList.listIterator();
        for (T node : linkedList) {
            stack.push(node);
        }
        listIterator = linkedList.listIterator();
        while (listIterator.hasNext()) {
            listIterator.next();
            listIterator.set(stack.pop());
        }
    }
}
