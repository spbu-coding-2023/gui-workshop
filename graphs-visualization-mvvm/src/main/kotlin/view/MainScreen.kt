package view

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Checkbox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.sp
import model.graph.Graph
import org.jetbrains.skia.impl.Stats.enabled
import view.graph.GraphView
import viewmodel.MainScreenViewModel
import viewmodel.graph.CircularPlacementStrategy
import viewmodel.graph.GraphViewModel

@Composable
fun <V, E> MainScreen(viewModel: MainScreenViewModel<V, E>) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Column(modifier = Modifier.width(370.dp)) {
            Row {
                Checkbox(checked = viewModel.showVerticesLabels.value, onCheckedChange = {
                    viewModel.showVerticesLabels.value = it
                })
                Text("Show vertices labels", fontSize = 28.sp, modifier = Modifier.padding(4.dp))
            }
            Row {
                Checkbox(checked = viewModel.showEdgesLabels.value, onCheckedChange = {
                    viewModel.showEdgesLabels.value = it
                })
                Text("Show edges labels", fontSize = 28.sp, modifier = Modifier.padding(4.dp))
            }
            Button(
                onClick = viewModel::resetGraphView,
                enabled = true,
            ) {
                Text(
                    text = "Reset default settings",
                )
            }
            Button(
                onClick = viewModel::setVerticesColor,
                enabled = true,
            ) {
                Text(
                    text = "Set colors",
                )
            }
        }

        Surface(
            modifier = Modifier.weight(1f),
        ) {
            GraphView(viewModel.graphViewModel)
        }

    }
}