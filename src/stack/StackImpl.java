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
        Node node = new Node(x,top);
            top = node;
            this.size ++;
        return x;
    }

    @Override //удaление из стека
    public int pop() {
        int currentHead = Integer.MIN_VALUE;
        if (isEmpty()) {
            System.out.println("nothing added in stack"
            );
        }
        else {

            currentHead = top.data;
            this.size = this.size - 1;
            this.top = this.top.next;
        }
        return currentHead;
    }

    @Override
    public int peek() {
        int peekStack = Integer.MAX_VALUE;
        if (isEmpty()) {
            System.out.println("stack is empty");
        }
        else {peekStack = top.data;
        }
        return peekStack;
    }
}

class Popo {
    public static void main(String[] args) {
        StackImpl stack = new StackImpl();
        while (true) {
            System.out.println("Варианты операций ");
            System.out.println("1 - delete from stack");
            System.out.println("2 - add in stack");
            System.out.println("3 - stack is empty ?");
            System.out.println("4 - wanna know stack size");
            System.out.println("5 - wanna know head of stack");
            System.out.println("Введите номер операции ");
            Scanner s = new Scanner(System.in);
            int num = s.nextInt();
            if (num == 1){
                System.out.println("delete from stack " + stack.pop());
            }
            if (num == 2){
                System.out.println("Write number you want to add");
                Scanner in = new Scanner(System.in);
                int x = in.nextInt();
                System.out.println("add in stack " + stack.push(x));
            }
            if (num == 3){
                    System.out.println("empty of stack is " + stack.isEmpty());
            }
            if (num == 4){
                System.out.println("size of stack is  " + stack.size());
            }
            if (num == 5){
                System.out.println("head of stack  " + stack.peek());
            }
        }
    }
}
