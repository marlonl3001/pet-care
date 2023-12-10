package presentation.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import br.com.mdr.petcare.shared.MR
import dev.icerock.moko.resources.compose.painterResource
import model.PetCare
import ui.theme.MEDIUM_PADDING
import ui.theme.appointmentColor
import ui.theme.healthColor
import ui.theme.hygieneColor
import ui.theme.nutritionColor
import ui.theme.titleColor

@Composable
fun PetCareCategories() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = MEDIUM_PADDING),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        careTypes().forEach { careType ->
            PetCareItem(careType)
        }
    }
}

@Composable
fun PetCareItem(petCare: PetCare) {
    Column(
        modifier = Modifier
            .width(70.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .size(60.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(color = petCare.color),
            painter = painterResource(petCare.icon),
            contentDescription = null,
            contentScale = ContentScale.Inside
        )
        Text(
            modifier = Modifier
                .padding(top = MEDIUM_PADDING),
            text = petCare.name,
            fontSize = MaterialTheme.typography.bodyLarge.fontSize,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.titleColor
        )
    }
}

@Composable
fun careTypes() = listOf(
    PetCare("Saúde", MR.images.ic_healthy, MaterialTheme.colorScheme.healthColor),
    PetCare("Higiene", MR.images.ic_hygiene, MaterialTheme.colorScheme.hygieneColor),
    PetCare("Consulta", MR.images.ic_veterinary, MaterialTheme.colorScheme.appointmentColor),
    PetCare("Nutrição", MR.images.ic_nutrition, MaterialTheme.colorScheme.nutritionColor)
).toMutableList()