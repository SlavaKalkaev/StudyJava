package linkedlist

class KLinkedListImpl<T> : LinkedListInterface<T> {
    private var head: NodeLL<T>? = null
    private val tail: NodeLL<T>? = null
    var size: Int = 0

    override fun add(data: T) {
        var currentNode: NodeLL<T>? = head
        val node: NodeLL<T> = NodeLL<T>(data)
        if (head == null) {
            head = node
        } else {
            while (currentNode?.next != null) {
                currentNode = currentNode.next
            }
            currentNode?.next = node
        }
        size++
    }

    override fun add(index: Int, data: T) {
        val left: NodeLL<T>? = head
        var node: NodeLL<T> = NodeLL<T>(data)
        if (size() < index) {
            println("index out of bounds")
        } else {
            if (index == 0) {
                node.next = head
                head = node
            } else {
                for (i in 0..index - 1) {
                    node = node.next
                }
                node.next = left?.next
                left?.next = node
            }
            size++
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
                currentHead = currentHead?.next
            }
        }
        return currentHead?.data
    }

    override fun remove(index: Int) {
        if (size() < index || index < 0) {
            println("index out of bounds")
        } else {
            if (index == 0) {
                head = head?.next
            } else {
                var currentNode: NodeLL<T>? = head
                for (i in 0..index - 1) {
                    currentNode = currentNode?.next
                }
                currentNode?.next= currentNode?.next?.next
            }
            size--
        }
    }

    private fun stringCollector(currentNode: NodeLL<T>?): String {
        return if (currentNode == null) {
            "null"
        } else {
            currentNode.data.toString() + "->" + stringCollector(currentNode.next)
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