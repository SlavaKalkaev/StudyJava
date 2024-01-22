package linkedlist;

public class LinkedListImpl<T> implements LinkedListInterface<T> {
    private NodeLL head;
    private NodeLL tail;
    private int size;

    public LinkedListImpl() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public void add(T data) {
        NodeLL currentNode = head;
        NodeLL node = new NodeLL(data);
        if (head == null) {
            head = node;
        } else {
            while (currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(node);
        }
        this.size++;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public T get(int index) {
        NodeLL currentHead = head;
        if (size() < index || index < 0) {
            return null;
        } else {
            for (int i = 0; i < index; i++) {
                currentHead = currentHead.getNext();
            }
            return (T) currentHead.getData();
        }
    }

    @Override
    public void remove(int index) {
        if (size() < index || index < 0) {
            System.out.println("index out of bounds");
        } else {
            if (index == 0) {
                head = head.getNext();
            } else {
                NodeLL currentNode = head;
                for (int i = 0; i < index - 1; i++) {
                    currentNode = currentNode.getNext();
                }
                currentNode.setNext(currentNode.getNext().getNext());
            }
            this.size--;
        }
    }

    @Override
    public void add(int index, T data) {
        NodeLL left = head;
        NodeLL node = new NodeLL(data);
        if (size() < index) {
            System.out.println("index out of bounds");
        } else {
            if (index == 0){
                node.setNext(head);
                head = node;
            }
            else {
                for (int i = 0; i < index - 1; i++) {
                    node = node.getNext();
                }
                node.setNext(left.getNext());
                left.setNext(node);
            }
            this.size++;
        }
    }

    private String stringCollector(NodeLL currentNode) {
        if (currentNode == null) {
            return "null";
        } else {
            return currentNode.getData().toString() + "->" + stringCollector(currentNode.getNext());
        }
    }

    @Override
    public String toString() {
        return stringCollector(head);
    }
}

class Lonch {
    public static void main(String[] args) {
        LinkedListImpl<Integer> list = new LinkedListImpl();
        list.add(1);
        list.add(2);
        list.add(0, 4);
        System.out.println(list);
    }
}