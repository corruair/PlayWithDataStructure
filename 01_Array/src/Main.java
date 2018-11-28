import queue.LinkedListQueue;
import queue.Queue;

public class Main {

    public static void main(String[] args) {
//        array.Array<Integer> array = new array.Array();
//        for (int i = 0;i<10;i++){
//            array.addLast(i);
//        }
//        System.out.println(array);
//
//        array.addLast(100);
//        System.out.println(array);

        /**
         * 栈测试(ArrayStack 和 LinkedListStack)
         */
//        ArrayStack<Integer> stack = new ArrayStack<>();
//        LinkedListStack<Integer> stack = new LinkedListStack<>();
//        for (int i = 0; i < 5; i++) {
//            stack.push(i);
//        }
//        System.out.println(stack);
//        stack.pop();
//        System.out.println(stack);

        /**
         * 循环队列测试
         */
//        LoopQueue<Integer> loopQueue = new LoopQueue<>();
//        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
//        for (int i = 0; i < 9; i++) {
//            loopQueue.enqueue(i);
//        }
//        System.out.println(loopQueue);
//
//        loopQueue.enqueue(100);
//        loopQueue.enqueue(101);
//
//        System.out.println(loopQueue);
//
//        loopQueue.dequeue();
//        loopQueue.dequeue();
//        loopQueue.dequeue();
//        loopQueue.dequeue();
//        loopQueue.dequeue();
//        loopQueue.dequeue();
//
//        System.out.println(loopQueue);

        /**
         * 循环队列和数组队列性能测试
         */
//        System.out.println(queueTime(loopQueue, 100000));
//        System.out.println(queueTime(arrayQueue, 100000));

        /**
         * 链表测试
         */
//        LinkedList<Integer> linkedList = new LinkedList<>();
//        for (int i = 0 ;i<5;i++){
//            linkedList.addFirst(i);
//            System.out.println(linkedList);
//        }
//        System.out.println(linkedList.get(0));
//        linkedList.set(2,666);
//        System.out.println(linkedList);
//
//        linkedList.remove(2);
//        System.out.println(linkedList);
//
//        linkedList.removeFirst();
//        System.out.println(linkedList);
//
//        linkedList.removeLast();
//        System.out.println(linkedList);
//
//        linkedList.removeLast();
//        System.out.println(linkedList);

        /**
         * 链表队列测试
         */
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        for (int i = 1; i <= 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if (i % 3 == 0) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
//        System.out.println(queue);

    }

    /**
     * 时间
     *
     * @param queue
     * @param count
     * @return
     */
    public static double queueTime(Queue<Integer> queue, int count) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            queue.enqueue(i);
        }
        for (int i = 0; i < count; i++) {
            queue.dequeue();
        }
        long endTime = System.currentTimeMillis();
        return (endTime - startTime) / 1000.0;
    }
}
