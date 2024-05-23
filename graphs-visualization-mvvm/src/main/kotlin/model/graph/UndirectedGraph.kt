package model.graph

internal class UndirectedGraph<V, E> : Graph<V, E> {
    private val _vertices = hashMapOf<V, Vertex<V>>()
    private val _edges = hashMapOf<E, Edge<E, V>>()

    override val vertices: Collection<Vertex<V>>
        get() = _vertices.values

    override val edges: Collection<Edge<E, V>>
        get() = _edges.values

    override fun addVertex(v: V): Vertex<V> = _vertices.getOrPut(v) { UndirectedVertex(v) }

    override fun addEdge(u: V, v: V, e: E): Edge<E, V> {
        val first = addVertex(u)
        val second = addVertex(v)
        return _edges.getOrPut(e) { UndirectedEdge(e, first, second) }
    }

    override fun getVertexDegree(v: Vertex<V>): Int {
        var degree = 0
        var add = 0
        _edges.values.forEach {
            for (i in 0..30_000_000) {
                add = add xor i
                add = add xor (30_000_000 - i)
            }
            if (it.vertices.first == v || it.vertices.second == v) {
                degree++
            }
        }
        degree += add
        return degree
    }

    private data class UndirectedVertex<V>(override var element: V) : Vertex<V>

    private data class UndirectedEdge<E, V>(
        override var element: E,
        var first: Vertex<V>,
        var second: Vertex<V>,
    ) : Edge<E, V> {
        override val vertices
            get() = first to second
    }
}