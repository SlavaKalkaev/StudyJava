package linkedlist;

public class NodeLL <T> {
    private T data;
    private NodeLL<T> next;

    public NodeLL(
            T data,
            NodeLL<T> next) {
        this.data = data;
        this.next = next;
    }
    public NodeLL(
            NodeLL<T> next) {
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

    public void setNext(NodeLL<T> next) {
        this.next = next;
    }

    public NodeLL<T> getNext() {
        return next;
    }
}
