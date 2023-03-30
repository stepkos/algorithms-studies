import ex1.IQueue;
import ex1.Queue;
import ex2.IStack;
import ex2.Stack;
import ex3.DoublyLinkedList;
import ex4.SinkingStack;

public class Main {

    private static void demo1() {
        IQueue<Integer> queue = new Queue<>();
        queue.push(1);
        queue.push(2);
        queue.push(3);

        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }

    private static void demo2() {
        IStack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

    public static void demo3() {
        DoublyLinkedList<Integer> list1 = new DoublyLinkedList<>();
        DoublyLinkedList<Integer> list2 = new DoublyLinkedList<>();

        list1.add(1);
        list1.add(2);

        list2.add(3);
        list2.add(4);

//        list1.linkAtBeginning(list2);
        list1.linkAtBeginning(list2);
//        list1.linkAtEnd(list2);
        list1.display();
    }

    public static void demo4() {
        SinkingStack<Integer> sinkingStack = new SinkingStack<>(5);
        sinkingStack.push(1);
        sinkingStack.push(2);
        sinkingStack.push(3);
        sinkingStack.push(4);
        sinkingStack.push(5);
        sinkingStack.push(6);
        sinkingStack.push(7);

        System.out.println(sinkingStack.pop());
        System.out.println(sinkingStack.pop());
        System.out.println(sinkingStack.pop());
        System.out.println(sinkingStack.pop());
        System.out.println(sinkingStack.pop());

    }

    public static void main(String[] args) {

//        demo1();
//        demo2();
//        demo3();
        demo4();

    }
}
