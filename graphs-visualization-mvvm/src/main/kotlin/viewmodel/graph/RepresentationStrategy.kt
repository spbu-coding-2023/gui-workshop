package viewmodel.graph

import model.graph.Graph

interface RepresentationStrategy<V, E> {
    fun place(width: Double, height: Double, vertices: Collection<VertexViewModel<V>>)
    suspend fun highlight(vertices: Collection<VertexViewModel<V>>, graph: Graph<V, E>)
}