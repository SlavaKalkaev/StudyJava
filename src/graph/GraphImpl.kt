package graph


import java.lang.StringBuilder

class GraphImpl : Graph {
    private var size = 0
    private val graph = MutableList<MutableList<Int>>(size) { mutableListOf() }


    override fun addVertex() {
        val list = mutableListOf<Int>()
        for (el in graph) {
            el.add(0)
        }
        for (i in 0..size) {
            list.add(0)
        }
        graph.add(list)
        size++
    }

    override fun addEdge(vertex1: Int, vertex2: Int, weight: Int) {
        graph[vertex1][vertex2] = weight
    }

    override fun removeVertex(vertex: Int) {
        graph.remove(graph[vertex])
        for (el in graph) {
            for (i in 0..<el.size) {
                if (i == vertex) {
                    el.removeAt(i)
                }
            }
        }
        size--
    }

    override fun removeEdge(vertex1: Int, vertex2: Int) {
        graph[vertex1][vertex2] = 0
    }

    override fun getNeighbors(vertex: Int): List<Int> {
        val listOfValues = mutableListOf<Int>()
        for (el in 0..<graph[vertex].size) {
            if (graph[vertex][el] != 0) {
                listOfValues.add(el)
            }
        }
        return listOfValues
    }

    override fun getWeight(vertex1: Int, vertex2: Int) = graph[vertex1][vertex2]

    override fun clear() {
        for (el in graph) {
            el.clear()
        }
        graph.clear()
    }

    override fun printGraphAsMatrix() {
        val matr = StringBuilder()
        for (el in graph) {
            matr.append(el.toString() + "\n")
        }
        println(matr)
    }

    private fun dfs(vertex: Int, visited: MutableList<Boolean>) {
        visited[vertex] = true
        for (i in getNeighbors(vertex)) {
            println("$vertex -> $i"+ "[label=\"${graph[vertex][i]}\"];")
            if (!visited[i]) {
                dfs(i, visited)
            }
        }
    }

    override fun printGraphAsGraphViz() {
        println("digraph G {")
        val visited = MutableList(graph.size) { false }
        for (i in 0..<graph.size) {
            if (!visited[i]) {
                dfs(i, visited)
            }
        }
        println("}")
    }
}


fun main() {
    val graph = GraphImpl()
    graph.addVertex()
    graph.addVertex()
    graph.addVertex()
    graph.addEdge(0, 1, 4)
    graph.addEdge(1, 1, 3)
    graph.addEdge(0, 2, 8)
    graph.addVertex()
//    println(graph.getNeighbors(1))
    graph.addEdge(3, 1, 2)
//    println(graph.getNeighbors(0))
    graph.printGraphAsMatrix()
    graph.printGraphAsGraphViz()
}

