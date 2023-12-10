package presentation.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import br.com.mdr.petcare.shared.MR
import dev.icerock.moko.resources.compose.painterResource
import dev.icerock.moko.resources.compose.stringResource
import moe.tlaster.precompose.navigation.Navigator
import navigation.Screen
import presentation.components.RoundedButton
import ui.theme.BUTTON_HORIZONTAL_PADDING
import ui.theme.CARD_ELEVATION
import ui.theme.EXTRA_LARGE_PADDING
import ui.theme.LARGE_PADDING
import ui.theme.MEDIUM_PADDING

@Composable
fun LoginScreen(navigator: Navigator) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .paint(
                painter = painterResource(MR.images.img_background_shade),
                contentScale = ContentScale.Crop)
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 78.dp, vertical = 64.dp),
            contentScale = ContentScale.Fit,
            painter = painterResource(MR.images.img_logo),
            contentDescription = null
        )

        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = EXTRA_LARGE_PADDING),
            elevation = CardDefaults.cardElevation(
                defaultElevation = CARD_ELEVATION
            )
        ) {
            Column(
                modifier = Modifier
                    .padding(vertical = LARGE_PADDING),
            ) {
                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(MEDIUM_PADDING),
                    singleLine = true,
                    value = email,
                    onValueChange = { email = it },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email
                    ),
                    label = { Text(stringResource(MR.strings.email)) },
                    placeholder = { Text(text = stringResource(MR.strings.email)) }
                )

                TextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(MEDIUM_PADDING),
                    singleLine = true,
                    value = password,
                    onValueChange = { password = it },
                    label = { Text(stringResource(MR.strings.password)) },
                    placeholder = { Text(stringResource(MR.strings.password)) },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password
                    ),
                    visualTransformation =
                    if (passwordVisible)
                        VisualTransformation.None
                    else
                        PasswordVisualTransformation(),
                    trailingIcon = {
                        val image =
                            painterResource(
                                if (passwordVisible)
                                    MR.images.ic_visibility
                                else
                                    MR.images.ic_visibility_off
                            )

                        // Please provide localized description for accessibility services
                        val description =
                            if (passwordVisible)
                                MR.strings.hide_password
                            else
                                MR.strings.show_password

                        IconButton(onClick = {passwordVisible = !passwordVisible}){
                            Icon(painter = image, stringResource(description))
                        }
                    }
                )
                Row {
                    Spacer(modifier = Modifier.weight(1f))
                    TextButton(
                        onClick = {
                            navigator.navigate("forgot_password")
                        }
                    ) {
                        Text("Esqueceu sua senha?")
                    }
                }
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        RoundedButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = BUTTON_HORIZONTAL_PADDING, vertical = EXTRA_LARGE_PADDING),
            text = stringResource(MR.strings.login_description),
            onClick = { navigator.navigate(Screen.Home.route) }
        )
    }
}