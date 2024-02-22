package queue;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class QueueImpl implements QueueInterface {
    private int currentSize;
    private int maxSize;
    private int front;
    private int rear;
    private int[] queueList;

    public QueueImpl(int maxSize) {
        front = -1;
        rear = -1;
        currentSize = 0;
        this.maxSize = maxSize;
        queueList = new int[maxSize];
    }

    @Override
    public boolean isEmpty() {
        return currentSize == 0;
    }

    @Override
    public boolean isFull() {
        return currentSize == maxSize;
    }

    @Override
    public int size() {
        return currentSize;
    }

    @Override
    public int enqueue(int item) {
        if (isFull()) {
            System.out.println("AAAAAAAAAAA Q IS FULL AAAAAAAAAAAAAA");
            dequeue();
        }
        if (front == -1) {
            front = 0;
        }
        rear = (rear + 1) % maxSize;
        queueList[rear] = item;
        currentSize++;
        return item;
    }

    @Override
    public Integer dequeue() {
        int element;
        if (isEmpty()) {
            System.out.println("empty");
            return null;
        } else {
            element = queueList[front];
            if (front == rear) {
                front = -1;
                rear = -1;
            } else {
                front = (front + 1) % maxSize;
            }
            currentSize--;
            return (element);
        }

    }

    @Override
    public Integer peek() {
        if (!isEmpty()) {
            return null;
        }
        return queueList[front];
    }

    @Override
    public String toString() {
        return stringCollector();
    }

    public String stringCollector() {
        StringBuilder builder = new StringBuilder();
        String res;
        if (!isEmpty()) {
            int i = front;
            int count = 0;
            while (count < currentSize) {
                builder.append(queueList[i] + " -> ");
                i = (i + 1) % maxSize;
                count++;
            }
        } else {
            return "empty";}
        builder.delete(builder.length() - 3, builder.length());
        res = builder.toString();
        return res;
    }
}

class Popa {
    public static <T> void main(String[] args) throws IOException {
        QueueImpl queue = new QueueImpl(5);
        while (true) {
            System.out.println("Enter size of q");
            Scanner m = new Scanner(System.in);
            System.out.println("Variants of operations ");
            System.out.println("1 - delete ");
            System.out.println("2 - add ");
            System.out.println("3 - empty ?");
            System.out.println("4 - full ?");
            System.out.println("5 - wanna know q size");
            System.out.println("6 - wanna know head of q");
            System.out.println("7 - view of q");
            System.out.println("Enter number of operations ");
            Scanner s = new Scanner(System.in);
            try {
                int num = (s.nextInt());
                if (num == 1) {
                    Integer b = queue.dequeue();
                    if (b != null) {
                        System.out.println("delete from q " + b);
                    }
                } else if (num == 2) {
                    System.out.println("write number you want to add");
                    Scanner inside = new Scanner(System.in);
                    int x = inside.nextInt();
                    Integer a = queue.enqueue(x);
                    if (a != 0)
                        System.out.println("add in q " + a);
                } else if (num == 3) {
                    System.out.println("empty of q is " + queue.isEmpty());
                } else if (num == 4) {
                    System.out.println("full of q is " + queue.isFull());
                } else if (num == 5) {
                    System.out.println("size of q is  " + queue.size());
                } else if (num == 6) {
                    Integer a = queue.peek();
                    if (a != null) {
                        System.out.println("head of q  " + a);
                    }
                } else if (num == 7) {
                    System.out.println(queue);
                } else {
                    System.out.println("enter the number from 1 to 7");

                }
            } catch (InputMismatchException e) {
                System.out.println("Error, enter int type");
            }
        }
    }
}