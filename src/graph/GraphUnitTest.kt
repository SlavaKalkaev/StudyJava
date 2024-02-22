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

        //тут будет доп функция-обертка
        val minDistance = graph.deikstra(1, 4)
        println("test1 ${minDistance == 60}")
    }

    fun run() {
        test1()
    }
}

    fun main() {
        GraphUnitTest().run()
    }