import ex1.IQueue;
import ex1.Queue;
import ex2.IStack;
import ex2.Stack;

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

    public static void main(String[] args) {

//        demo1();
        demo2();

    }
}
