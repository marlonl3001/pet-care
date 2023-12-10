package presentation.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import br.com.mdr.petcare.shared.MR
import dev.icerock.moko.resources.compose.stringResource
import ui.theme.LARGE_PADDING
import ui.theme.SMALL_PADDING
import ui.theme.descriptionColor
import ui.theme.titleColor

@Composable
fun WelcomeHeader() {
    val user = " Marlon,"

    Column(
        modifier = Modifier
            .padding(start = LARGE_PADDING)
    ) {
        Text(
            text = buildAnnotatedString {
                append(stringResource(MR.strings.hello_user))
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append(user)
                }
            },
            fontSize = MaterialTheme.typography.titleLarge.fontSize,
            color = MaterialTheme.colorScheme.titleColor
        )
        Text(
            modifier = Modifier
                .padding(top = SMALL_PADDING),
            text = stringResource(MR.strings.welcome_message),
            fontSize = MaterialTheme.typography.bodyLarge.fontSize,
            color = MaterialTheme.colorScheme.descriptionColor
        )
    }
}