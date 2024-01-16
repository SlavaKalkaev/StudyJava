package linkedlist;

public class NodeLL <T> {
    private T data;
    private NodeLL next;

    public NodeLL(
            T data,
            NodeLL next) {
        this.data = data;
        this.next = next;
    }
    public NodeLL(
            NodeLL next) {
        this.next = next;
    }
    public NodeLL(
            T data) {
        this.data = data;
    }
    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setNext(NodeLL next) {
        this.next = next;
    }

    public NodeLL getNext() {
        return next;
    }
}
