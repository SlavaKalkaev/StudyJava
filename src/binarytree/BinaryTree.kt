package binarytree

import linkedlist.NodeLL

interface BinaryTree {

    fun insert(data: Int)

    // private fun insertRec(node: Node?, key: Int): Node

    fun search(data: Int): TreeNode?

    // private fun searchRec(node: Node?, key: Int): Node?

    fun delete(data: Int)

    // private fun deleteRec(node: Node?, key: Int): Node?

    // private fun findMin(node: Node?): Node?

    fun dfs(): String // тут тип данных можно поменять, dfs будет юзаться в toString

    // private fun dfsRec(node: Node?, result: MutableList<Int>)

    // toString в формате graphviz
}