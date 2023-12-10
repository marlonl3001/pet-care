package presentation.screens.pet_detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import dev.icerock.moko.resources.compose.painterResource
import model.PetCare
import moe.tlaster.precompose.navigation.Navigator

@Composable
fun PetGridItem(petCare: PetCare, navigator: Navigator) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .clip(RoundedCornerShape(percent = 25))
            .background(color = petCare.color),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .size(32.dp),
            painter = painterResource(petCare.icon),
            contentDescription = null,
            contentScale = ContentScale.Inside
        )
        Text(
            text = petCare.name,
            fontSize = MaterialTheme.typography.bodyLarge.fontSize,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
    }
}