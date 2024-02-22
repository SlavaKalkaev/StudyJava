package stack;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StackImpl<T> implements StackInterface<T> {
    //    //верхушка стека
    private Node top;
    private int size;


    public StackImpl() {
        this.top = null;
        this.size = 0;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public T push(T x) {
        Node node = new Node(x, top);
        top = node;
        this.size++;
        return x;
    }

    @Override //удaление из стека
    public T pop() {
        T currentHead = null;
        if (isEmpty()) {
            System.out.println("nothing added in stack");
        } else {
            currentHead = (T) top.getData();
            this.size--;
            this.top = this.top.getNext();
        }
        return currentHead;
    }

    @Override
    public T peek() {
        T peekStack = null;
        if (isEmpty()) {
            System.out.println("stack is empty");
        } else {
            peekStack = (T) top.getData();
        }
        return peekStack;
    }

    @Override
    public String toString() {
        return stringCollector(top);
    }

    private String stringCollector(Node currentTop) {
        if (currentTop == null) {
            return "null";
        } else {
            return stringCollector(currentTop.getNext()) + "<-" + currentTop.getData().toString();
        }
    }
}

class Popo {
    public static <T> void main(String[] args) throws IOException {
        StackImpl<Integer> stack = new StackImpl();
        while (true) {
            System.out.println("Variants of operations ");
            System.out.println("1 - delete from stack");
            System.out.println("2 - add in stack");
            System.out.println("3 - stack is empty ?");
            System.out.println("4 - wanna know stack size");
            System.out.println("5 - wanna know head of stack");
            System.out.println("6 - view of stack");
            System.out.println("Enter number of operations ");
            Scanner s = new Scanner(System.in);
            try {
                int num = (s.nextInt());
                if (num == NumOfOperations.DELETE.getCode()) {
                    Integer b = stack.pop();
                    if (b != null) {
                        System.out.println("delete from stack " + b);
                    }
                } else if (num == NumOfOperations.ADD.getCode()) {
                    System.out.println("write number you want to add");
                    Scanner in = new Scanner(System.in);
                    int x = in.nextInt();
                    System.out.println("add in stack " + stack.push(x));
                } else if (num == NumOfOperations.EMPTY.getCode()) {
                    System.out.println("empty of stack is " + stack.isEmpty());
                } else if (num == NumOfOperations.SIZE.getCode()) {
                    System.out.println("size of stack is  " + stack.size());
                } else if (num == NumOfOperations.HEAD.getCode()) {
                    Integer a = stack.peek();
                    if (a != null) {
                        System.out.println("head of stack  " + a);
                    }
                } else if (num == NumOfOperations.VIEW.getCode()) {
                    System.out.println(stack);
                } else {
                    System.out.println("enter the number from 1 to 5");

                }
            } catch (InputMismatchException e) {
                System.out.println("Error, enter int type");
            }
        }
    }
}