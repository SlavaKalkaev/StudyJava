package binarytree

data class TreeNodeImpl(
        override var data: Int,
        override var left: TreeNode?,
        override var right: TreeNode?
) : TreeNode