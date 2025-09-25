import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

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
        containerColor = MaterialTheme.colorScheme.background,
        textContentColor = MaterialTheme.colorScheme.onPrimary,
        titleContentColor = MaterialTheme.colorScheme.onBackground,

        confirmButton = confirmButton ?: {},
        dismissButton = dismissButton ?: {},
    )
}




