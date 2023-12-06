package stack;

import java.util.Scanner;

public class StackImpl implements StackInterface {
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
    public int push(int x) {
        Node node = new Node(x, top);
        top = node;
        this.size++;
        return x;
    }

    @Override //удaление из стека
    public int pop() {
        int currentHead = Integer.MIN_VALUE;
        if (isEmpty()) {
            System.out.println("nothing added in stack");
        } else {
            currentHead = top.getData();
            this.size = this.size - 1;
            this.top = this.top.getNext();
        }
        return currentHead;
    }

    @Override
    public int peek() {
        int peekStack = Integer.MIN_VALUE;
        if (isEmpty()) {
            System.out.println("stack is empty");
        } else {
            peekStack = top.getData();
        }
        return peekStack;
    }
}

class Popo {
    public static void main(String[] args) {
        StackImpl stack = new StackImpl();
        while (true) {
            System.out.println("Variants of operations ");
            System.out.println("1 - delete from stack");
            System.out.println("2 - add in stack");
            System.out.println("3 - stack is empty ?");
            System.out.println("4 - wanna know stack size");
            System.out.println("5 - wanna know head of stack");
            System.out.println("Enter number of operations ");
            Scanner s = new Scanner(System.in);
            int num = s.nextInt();
            if (num == 1) {
                int b = stack.pop();
                if (b != Integer.MIN_VALUE){
                    System.out.println("delete from stack " + b);
                }
            }
            if (num == 2) {
                System.out.println("write number you want to add");
                Scanner in = new Scanner(System.in);
                int x = in.nextInt();
                System.out.println("add in stack " + stack.push(x));
            }
            if (num == 3) {
                System.out.println("empty of stack is " + stack.isEmpty());
            }
            if (num == 4) {
                System.out.println("size of stack is  " + stack.size());
            }
            if (num == 5) {
                int a = stack.peek();
                if (a != Integer.MIN_VALUE){
                    System.out.println("head of stack  " + a);
                }
            }
        }
    }
}
