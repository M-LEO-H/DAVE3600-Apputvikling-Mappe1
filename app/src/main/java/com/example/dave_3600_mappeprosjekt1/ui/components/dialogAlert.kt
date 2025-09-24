import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DialogAlert(
    dialogTitle: String,
    dialogText: @Composable () -> Unit,
    confirmButton: @Composable ( () -> Unit)? = null,
    dismissButton: @Composable ( () -> Unit)? = null
) {
    AlertDialog(
        onDismissRequest = {},
        title = {
            Text(text = dialogTitle)
        },
        text = {
            dialogText()
        },

        confirmButton = confirmButton ?: {},
        dismissButton = dismissButton ?: {},
    )
}