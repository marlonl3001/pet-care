package presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import br.com.mdr.petcare.shared.MR
import dev.icerock.moko.resources.compose.painterResource
import model.Appointment
import ui.theme.EXTRA_SMALL_PADDING
import ui.theme.HOME_APPOINTMENTS_HEIGHT
import ui.theme.MEDIUM_PADDING

@Composable
fun AppointmentItem(
    modifier: Modifier,
    appointment: Appointment,
    onAppointmentClick: () -> Unit
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .height(HOME_APPOINTMENTS_HEIGHT),
        shape = RoundedCornerShape(percent = 25),
        color = appointment.petCare.color
    ) {
        Row(
            modifier = Modifier
                .paint(
                    painter = painterResource(MR.images.appointment_background),
                    contentScale = ContentScale.Crop)
                .clip(RoundedCornerShape(percent = 25))
                .clickable { onAppointmentClick.invoke() }
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .padding(MEDIUM_PADDING),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(EXTRA_SMALL_PADDING)
                ) {
                    Image(
                        modifier = Modifier
                            .size(28.dp),
                        painter = painterResource(appointment.petCare.icon),
                        contentDescription = null,
                        contentScale = ContentScale.Inside
                    )
                    Text(
                        text = appointment.name,
                        fontSize = MaterialTheme.typography.titleMedium.fontSize,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(EXTRA_SMALL_PADDING)
                ) {
                    Image(
                        modifier = Modifier
                            .size(22.dp),
                        painter = painterResource(MR.images.ic_clock),
                        contentDescription = null
                    )
                    Text(
                        text = appointment.date,
                        fontSize = MaterialTheme.typography.labelLarge.fontSize,
                        color = Color.White
                    )
                }
            }
            Image(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(end = MEDIUM_PADDING),
                painter = painterResource(MR.images.img_bandage),
                contentDescription = null,
                alignment = Alignment.BottomCenter
            )
        }
    }
}