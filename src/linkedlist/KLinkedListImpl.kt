package linkedlist

class KLinkedListImpl<T : Any> : LinkedListInterface<T> {
    private var head: NodeLL<T>? = null
    private val tail: NodeLL<T>? = null
    private var size: Int = 0

    constructor() {
        head = null
        size = 0
    }

    override fun add(data: T) {
        var currentNode: NodeLL<T>? = head
        val node = NodeLL(data)
        if (head == null) {
            head = node
        } else {
            currentNode = currentNode?.next as NodeLL<T>?
            currentNode?.setNext(node)
        }
        this.size++
    }

    override fun add(index: Int, data: T) {
        val left: NodeLL<T>? = head
        var node = NodeLL(data)
        if (size() < index) {
            println("index out of bounds")
        } else {
            if (index == 0) {
                node.next = head
                head = node
            } else {
                for (i in 0..(index - 1)) {
                    node = node.next as NodeLL<T>
                }
                if (left != null) {
                    node.next = left.next
                }
            }
            this.size++
        }
    }

    override fun size(): Int {
        return size
    }

    override fun get(index: Int): T? {
        var currentHead: NodeLL<T>? = head
        if (size() < index || index < 0) {
            return null
        } else {
            for (i in 0..index) {
                currentHead = currentHead?.next as NodeLL<T>?
            }
        }
        return currentHead?.data
    }

    override fun remove(index: Int) {
        if (size() < index || index < 0) {
            println("index out of bounds")
        } else {
            if (index == 0) {
                head = head?.next as NodeLL<T>?
            } else {
                var currentNode: NodeLL<T>? = head
                for (i in 0..(index - 1)) {
                    currentNode = currentNode?.next as NodeLL<T>?
                }
                currentNode?.setNext(currentNode.next.next)
            }
            this.size--
        }
    }
    private fun stringCollector(currentNode: NodeLL<T>?): String {
        return if (currentNode == null) {
            "null"
        } else {
            currentNode.data.toString() + "->" + stringCollector(currentNode.next as NodeLL<T>?)
        }
    }

    override fun toString(): String {
        return stringCollector(head)
    }
}


    fun main(args: Array<String>) {
        var list: LinkedListImpl<Int?> = LinkedListImpl<Int?>()
        list.add(1)
        list.add(2)
        list.add(0, 4)
        println(list)
    }