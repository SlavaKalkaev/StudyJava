package stack;

public class Node {
    private int data;
    private Node next;
    public Node(
            int data,
            Node next){
        this.data = data;
        this.next = next;
    }
    public  void setData(int data){
        this.data = data;
    }
    public int getData(){
        return data;
    }
    public  void setNext(int next){
        this.data = data;
    }
    public Node getNext(){
        return next;
    }
}