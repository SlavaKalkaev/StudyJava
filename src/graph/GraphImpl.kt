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
            var color = "black"
            if (!visited[i]) {
                dfs(i, visited)
            }
            val shortestPath = shortPath(0, graph.size - 1)
            for (j in 0 .. shortestPath.size-2){
                if ("${shortestPath[j]} -> ${shortestPath[j+1]}" == "$vertex -> $i"){
                    color = "red"
                }
            }
            println("$vertex -> $i [label=\"${graph[vertex][i]}\", color=$color];")
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

    fun dijkstra(startVertex: Int): List<Int> {
        val minDistances = MutableList(size) { Int.MAX_VALUE }
        val visited = MutableList(size) { false }
        minDistances[startVertex] = 0

        for (i in 0 until size - 1) {
            var minVertex = -1
            for (j in 0 until size) {
                if (!visited[j] && (minVertex == -1 || minDistances[j] < minDistances[minVertex])) {
                    minVertex = j
                }
            }
            visited[minVertex] = true
            for (u in 0 until size) {
                if (getWeight(minVertex, u) != 0 && minDistances[minVertex] != Int.MAX_VALUE && minDistances[minVertex] + getWeight(minVertex, u) < minDistances[u]) {
                    minDistances[u] = minDistances[minVertex] + getWeight(minVertex, u)
                }
            }
        }

        return minDistances
    }

    fun shortPath(start: Int, end: Int): List<Int> {
        val distances = dijkstra(start)
        val path = mutableListOf<Int>()
        var currentVertex = end

        while (currentVertex != start) {
            path.add(currentVertex)
            currentVertex = getPreviousVertex(currentVertex, distances)
            if (currentVertex == -1) break
        }

        path.add(start)
        path.reverse()
        return path
    }

    private fun getPreviousVertex(vertex: Int, distances: List<Int>): Int {
        var previousVertex = -1
        var minDistance = Int.MAX_VALUE

        for (i in 0 until size) {
            if (getWeight(i, vertex) != 0 && distances[i] + getWeight(i, vertex) == distances[vertex] && distances[i] < minDistance) {
                minDistance = distances[i]
                previousVertex = i
            }
        }
        return previousVertex
    }

    fun dijkstra(vertex1: Int, vertex2: Int): Int {
        return dijkstra(vertex1)[vertex2]
    }
}

fun main() {
    val graph = GraphImpl()
    graph.addVertex()
    graph.addVertex()
    graph.addVertex()
    graph.addVertex()
    graph.addVertex()
    graph.addEdge(1 - 1, 2 - 1, 10)
    graph.addEdge(1 - 1, 5 - 1, 100)
    graph.addEdge(1 - 1, 4 - 1, 30)
    graph.addEdge(2 - 1, 3 - 1, 50)
    graph.addEdge(3 - 1, 5 - 1, 10)
    graph.addEdge(4 - 1, 3 - 1, 20)
    graph.addEdge(4 - 1, 5 - 1, 60)
    graph.printGraphAsMatrix()
    graph.printGraphAsGraphViz()
    println(graph.dijkstra(0))
    println(graph.shortPath(0, 4))
}


