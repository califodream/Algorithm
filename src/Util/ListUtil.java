package Util;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Stack;

public class ListUtil {

    public static void main(String[] args) {
        LinkedList<Integer> list1 = new LinkedList<>();
        list1.add(2);
        list1.add(4);
        LinkedList<Integer> list2 = new LinkedList<>();
        list2.add(1);
        list2.add(3);
        list2.add(5);
        System.out.println(Arrays.toString(ListUtil.mergeLinkedList(list1, list2).toArray()));
    }

    /**
     * Timing: 12ms Memory: 9MB
     */
    public static <T> void reverseLinkedList(LinkedList<T> linkedList) {
        Stack<T> stack = new Stack<>();
        ListIterator<T> listIterator = linkedList.listIterator();
        stack.isEmpty();
        stack.empty();
        for (T node : linkedList) {
            stack.push(node);
        }
        listIterator = linkedList.listIterator();
        while (listIterator.hasNext()) {
            listIterator.next();
            listIterator.set(stack.pop());
        }
    }

    /**
     * Timing: 50ms Memory: 11MB
     */
    public static <T extends Comparable<T>> LinkedList<T> mergeLinkedList(LinkedList<T> l1, LinkedList<T> l2) {
        LinkedList<T> merge = new LinkedList<>();
        ListIterator<T> li1 = l1.listIterator();
        ListIterator<T> li2 = l2.listIterator();
        while (li1.hasNext() && li2.hasNext()) {
            T temp1 = li1.next();
            T temp2 = li2.next();
            if (temp1.compareTo(temp2) >= 0) {
                merge.add(temp2);
                li1.previous();
            } else {
                merge.add(temp1);
                li2.previous();
            }
        }
        while (li1.hasNext()) {
            merge.add(li1.next());
        }
        while (li2.hasNext()) {
            merge.add(li2.next());
        }
        return merge;
    }
}
