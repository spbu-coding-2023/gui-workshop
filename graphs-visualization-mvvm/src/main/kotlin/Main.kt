import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import model.graph.Graph
import model.graph.UndirectedGraph
import view.MainScreen
import viewmodel.MainScreenViewModel
import viewmodel.graph.CircularPlacementStrategy

val sampleGraph: Graph<String, Long> = UndirectedGraph<String, Long>().apply {
    addVertex("A")
    addVertex("B")
    addVertex("C")
    addVertex("D")
    addVertex("E")
    addVertex("F")
    addVertex("G")

    addEdge("A", "B", 1)
    addEdge("A", "C", 2)
    addEdge("A", "D", 3)
    addEdge("A", "E", 4)
    addEdge("A", "F", 5)
    addEdge("A", "G", 6)

    addVertex("H")
    addVertex("I")
    addVertex("J")
    addVertex("K")
    addVertex("L")
    addVertex("M")
    addVertex("N")

    addEdge("H", "I", 7)
    addEdge("H", "J", 8)
    addEdge("H", "K", 9)
    addEdge("H", "L", 10)
    addEdge("H", "M", 11)
    addEdge("H", "N", 12)

    addEdge("A", "H", 0)
}

@Composable
@Preview
fun App() {
    MaterialTheme {
        MainScreen(MainScreenViewModel(sampleGraph, CircularPlacementStrategy()))
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
