package presentation.components

import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import ui.theme.BUTTON_HEIGHT

@Composable
fun RoundedButton(modifier: Modifier = Modifier, text: String, onClick: (() -> Unit)) {
    Button(
        modifier = modifier
            .height(BUTTON_HEIGHT),
        onClick = { onClick() }
    ) {
        Text(
            color = Color.White,
            text = text
        )
    }
}