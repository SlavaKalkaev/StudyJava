package graph

class GraphUnitTest {

    private fun test1() {
        val graph = GraphImpl()
        graph.addVertex()
        graph.addVertex()
        graph.addVertex()
        graph.addVertex()
        graph.addVertex()

        graph.addEdge(0, 1, 10)
        graph.addEdge(0, 4, 100)
        graph.addEdge(0, 3, 30)
        graph.addEdge(1, 2, 50)
        graph.addEdge(2, 4, 10)
        graph.addEdge(3, 2, 20)
        graph.addEdge(3, 4, 60)

        val minDistance = graph.dijkstra(3, 4)
        println(graph.printGraphAsGraphViz())
        println("test1 ${minDistance == 30}")
    }
    private fun test2() {
        val graph = GraphImpl()
        graph.addVertex()
        graph.addVertex()
        graph.addVertex()


        graph.addEdge(0, 1, 10)
        graph.addEdge(1, 2, 14)
        graph.addEdge(0, 2, 3)
        graph.addEdge(1, 1, 20)


        val minDistance = graph.dijkstra(0, 2)
        println("test2 ${minDistance == 3}")
    }
    private fun test3() {
        val graph = GraphImpl()
        graph.addVertex()
        graph.addVertex()
        graph.addVertex()
        graph.addVertex()
        graph.addVertex()
        graph.addVertex()
        graph.addVertex()
        graph.addVertex()

        graph.addEdge(0, 1, 10)
        graph.addEdge(0, 4, 100)
        graph.addEdge(0, 3, 30)
        graph.addEdge(1, 2, 50)
        graph.addEdge(6, 4, 10)
        graph.addEdge(1, 6, 20)
        graph.addEdge(5, 7, 10)
        graph.addEdge(4, 4, 20)
        graph.addEdge(3, 5, 30)
        graph.addEdge(2, 4, 70)

        val minDistance = graph.dijkstra(3,4 )
        println("test3 ${minDistance == Int.MAX_VALUE}")
    }
    private fun test4() {
        val graph = GraphImpl()
        graph.addVertex()
        graph.addVertex()
        graph.addVertex()
        graph.addVertex()
        graph.addVertex()

        graph.addEdge(0, 1, 10)
        graph.addEdge(0, 4, 70)
        graph.addEdge(0, 3, 30)
        graph.addEdge(1, 2, 20)
        graph.addEdge(2, 4, 10)
        graph.addEdge(3, 2, 10)
        graph.addEdge(3, 4, 60)


        val minDistance = graph.dijkstra(2, 4)
        println("test4 ${minDistance == 10}")
    }

    fun run() {
        test1()
        test2()
        test3()
        test4()
    }
}

    fun main() {
        GraphUnitTest().run()
    }