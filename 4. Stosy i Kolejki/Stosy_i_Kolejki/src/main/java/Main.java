import ex1.IQueue;
import ex1.Queue;

public class Main {
    public static void main(String[] args) {

        IQueue<Integer> queue = new Queue<>();
        queue.push(1);
        queue.push(2);
        queue.push(3);

        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());

    }
}
