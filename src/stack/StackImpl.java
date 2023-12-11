package stack;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StackImpl <T> implements StackInterface <T> {
    //    //верхушка стека
    private Node  top;
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
    public  int size() {
        return  this.size;
    }

    @Override
    public  T  push(T x) {
        Node node = new  Node (x, top);
        top = node;
        this.size++;
        return  x;
    }

    @Override //удaление из стека
    public T pop(){
       T currentHead = null;
        if (isEmpty()) {
            System.out.println("nothing added in stack");
        } else {
            currentHead = (T) top.getData();
            this.size = this.size - 1;
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
}

class Popo {
    public static <T> void main(String[] args) throws IOException{
        StackImpl <T> stack = new StackImpl();
        while (true) {
            System.out.println("Variants of operations ");
            System.out.println("1 - delete from stack");
            System.out.println("2 - add in stack");
            System.out.println("3 - stack is empty ?");
            System.out.println("4 - wanna know stack size");
            System.out.println("5 - wanna know head of stack");
            System.out.println("Enter number of operations ");
            Scanner s = new Scanner(System.in);
            try {
                int num = (s.nextInt());
                if (num == 1) {
                    T b = stack.pop();
                    if (b != null){
                        System.out.println("delete from stack " + b);
                    }
                }
                if (num == 2) {
                    System.out.println("write number you want to add");
                    Scanner in = new Scanner(System.in);
                    T x = (T) in.next();
                    System.out.println("add in stack " + stack.push(x));
                }
                if (num == 3) {
                    System.out.println("empty of stack is " + stack.isEmpty());
                }
                if (num == 4) {
                    System.out.println("size of stack is  " + stack.size());
                }
                if (num == 5) {
                    T a = stack.peek();
                    if (a != null){
                        System.out.println("head of stack  " + a);
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Error, enter int type");
            }
        }
    }
}
