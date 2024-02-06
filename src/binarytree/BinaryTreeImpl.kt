package binarytree

class BinaryTreeImpl : BinaryTree {

    private var root: TreeNode? = null

    override fun insert(data: Int) {
        root = insertRec(root, data)
    }

    private fun insertRec(node: TreeNode?, key: Int): TreeNode {
        if (node == null) {
            return TreeNodeImpl(key, null, null)
        }
        if (key < node.data) {
            node.left = insertRec(node.left, key)
        } else if (key > node.data) {
            node.right = insertRec(node.right, key)
        }
        return node
    }

    override fun search(data: Int): TreeNode? {
        searchRec(root, data)
        return root
    }

    private fun searchRec(node: TreeNode?, key: Int): TreeNode? {
        if (node == null) {
            return node
        }
        if (node.data == key) {
            return node
        }
        if (key < node.data) {
            node.left = searchRec(node.left, key)
        } else if (key < node.data) {
            node.left = searchRec(node.left, key)
        }
        return node
    }

    override fun delete(data: Int) {
        deleteRec(root, data)
    }

    override fun dfs(): String {
        val result = mutableListOf<Int>()
        dfsRec(root, result)
        return result.toString()
    }

    private fun deleteRec(node: TreeNode?, key: Int): TreeNode? {

        if (node == null) return node

        if (key < node.data) {
            node.left = deleteRec(node.left, key)
        } else if (key > node.data) {
            node.right = deleteRec(node.right, key)
        }
        if (node.data == key) {
            if (node.left == null) {
                return node.right
            } else if (node.right == null) {
                return node.left
            }
            if (node.left != null && node.right != null) {
                node.data= findMin(node.right)?.data ?: 0
                node.right = deleteRec(node.right, node.data)
                return node
            }
        }
        return node
    }


    private fun findMin(node: TreeNode?): TreeNode? {
        if (node?.left == null) {
            return node
        } else {
            findMin(node.left)
        }
        return node
    }


    private fun dfsRec(node: TreeNode?, result: MutableList<Int>) {
        if (node == null) {
            return
        }
        dfsRec(node.left, result)
        dfsRec(node.right, result)
        result.add(node.data)

    }

    fun stringCollector(node: TreeNode?, currentString: StringBuilder): StringBuilder? {
        if (node?.left != null) {
            currentString.append(node.data.toString() + "->" + node.left?.data.toString() + ";" + "\n")
            stringCollector(node.left, currentString)
        }
        if (node?.right != null) {
            currentString.append(node.data.toString() + "->" + node.right?.data.toString() + ";" + "\n")
            stringCollector(node.right, currentString)
        }
        return currentString
    }

    override fun toString(): String {

        return "digraph{" + "\n" + stringCollector(root, StringBuilder()).toString() + "}"
    }

}

fun main() {
    var tree = BinaryTreeImpl()
    tree.insert(30)
    tree.insert(28)
    tree.insert(27)
    tree.insert(26)
    tree.insert(25)
    tree.insert(35)
    tree.insert(32)
    tree.insert(40)
    tree.delete(35)
    println(tree.toString())
}


