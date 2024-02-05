package graph

interface Graph {

    fun addVertex()

    fun addEdge(vertex1: Int, vertex2: Int, weight: Int)

    fun removeVertex(vertex: Int)

    fun removeEdge(vertex1: Int, vertex2: Int)

    fun getNeighbors(vertex: Int): List<Int>

    fun getWeight(vertex1: Int, vertex2: Int): Int

    fun clear()

    fun printGraphAsMatrix()

    fun printGraphAsGraphViz()
}