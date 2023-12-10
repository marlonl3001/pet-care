package presentation.screens.home

import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.times
import model.Appointment
import moe.tlaster.precompose.navigation.Navigator
import presentation.components.AppointmentItem
import ui.theme.HOME_APPOINTMENTS_HEIGHT
import ui.theme.LARGE_PADDING
import ui.theme.MEDIUM_PADDING

@Composable
fun AppointmentList(navigator: Navigator, appointments: List<Appointment>) {

    appointments.withIndex().reversed().forEachIndexed { index, appointment ->

        val offsetY = (-index * 8.dp) + MEDIUM_PADDING

        val alpha =
            if (index != appointments.size - 1) {
                0.3f
            } else {
                1f
            }

        val horizontalPadding = (LARGE_PADDING + (appointment.index * 5.dp))

        val modifier = Modifier
            .absoluteOffset(
                x = 0.dp,
                y = offsetY,
            )
            .alpha(alpha)
            .padding(horizontal = horizontalPadding)
            .fillMaxWidth()
            .height(HOME_APPOINTMENTS_HEIGHT)

        AppointmentItem(modifier, appointment.value) {
            navigator.navigate("appointment")
        }
    }
}