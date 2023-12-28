package doublylinkedlist;

import queue.QueueInterface;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class QueueImpl <T> implements QueueInterface<T> {
    public int size = 5;
    private int front;
    private int rear;
     int queueList [] = new int [size];;
      public QueueImpl(){
        front = -1 ;
        rear = -1 ;
    }
    @Override
    public boolean isEmpty() {
        if (front == -1 &&  rear ==-1)
        return true;
        else
        return false;
    }

    @Override
    public boolean isFull() {
        if (front == 0 && rear == size - 1) {
            return true;
        }
        else
        return false;
    }

    @Override
    public int size()  {
        return  size;
    }

    @Override
    public int enqueue(int item) {
        if (isFull()){
            System.out.println("AAAAAAAAAAA Q IS FULL AAAAAAAAAAAAAA");
            return 0;
        }
        else {
            if (front == -1){
                front = 0;
            }
            rear = (rear + 1) % size();
            queueList[rear] = item;
            return item;
        }
    }

    @Override
    public int dequeue() {
        int element;
        if (isEmpty()) {
            System.out.println("empty");
            return (-1);
        } else {
            element = queueList[front];
            if (front == rear) {
                front = -1;
                rear = -1;
            }
            else {
                front = (front + 1) % size;
            }
            return (element);
        }

    }

    @Override
    public int peek() {
        if (front == -1){
            System.out.println("nothing");
        }
        return queueList[front];
    }
    @Override
    public String toString() {
        return stringCollector();
    }
//    public int dsds(int fir){
//          fir =
//          fir = (front + 1) % size;
//        return fir;
//    }
    public String stringCollector() {
        StringBuilder builder = new StringBuilder();
        String res;
        if (front == -1) {
            return "empty";
        } else {
            for (int currentFront = 0; currentFront < queueList.length; currentFront++) {
                if (currentFront == rear) {
                    return queueList[rear] + "->";
                }
                builder.append(queueList[currentFront]);
                builder.append("->");
            }
            res = builder.toString();
        }
        return res;
    }
}
class Popa {
    public static <T> void main(String[] args) throws IOException {
        QueueImpl<Integer> queue = new QueueImpl();
        while (true) {
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
                    if (b != 0) {
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