import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DialogAlert(
    dialogTitle: @Composable () -> Unit,
    dialogText: @Composable () -> Unit,
    confirmButton: @Composable ( () -> Unit)? = null,
    dismissButton: @Composable ( () -> Unit)? = null
) {
    AlertDialog(

        onDismissRequest = {},
        title = {
            dialogTitle()
        },
        text = {
            dialogText()
        },
        containerColor = MaterialTheme.colorScheme.onSecondaryContainer,
        textContentColor = Color.Black,
        titleContentColor = Color.Black,

        confirmButton = confirmButton ?: {},
        dismissButton = dismissButton ?: {},
    )
}




