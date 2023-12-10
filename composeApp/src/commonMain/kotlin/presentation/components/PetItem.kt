package presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
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
import model.Pet
import moe.tlaster.precompose.navigation.Navigator
import navigation.Screen
import ui.theme.CARD_ELEVATION
import ui.theme.MEDIUM_PADDING
import ui.theme.PET_ITEM_HEIGHT
import ui.theme.PET_ITEM_WIDTH
import ui.theme.SUPER_SMALL_PADDING
import ui.theme.descriptionColor
import ui.theme.grayBlueColor
import ui.theme.titleColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PetItem(navigator: Navigator, pet: Pet) {
    ElevatedCard(
        modifier = Modifier
            .height(PET_ITEM_HEIGHT)
            .width(PET_ITEM_WIDTH),
        shape = MaterialTheme.shapes.large,
        elevation = CardDefaults.cardElevation(
            defaultElevation = CARD_ELEVATION
        ),
        onClick = {
            navigator.navigate(Screen.PetDetail.route)
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(SUPER_SMALL_PADDING)
                    .clip(MaterialTheme.shapes.large),
                painter = painterResource(pet.image),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = MEDIUM_PADDING)
                    .weight(0.25f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier
                        .weight(1f),
                    text = pet.name,
                    color = MaterialTheme.colorScheme.titleColor,
                    fontSize = MaterialTheme.typography.headlineSmall.fontSize,
                    fontWeight = FontWeight.Bold
                )
                Image(
                    modifier = Modifier
                        .size(30.dp)
                        .clip(MaterialTheme.shapes.small)
                        .background(MaterialTheme.colorScheme.grayBlueColor),
                    painter = painterResource(pet.gender),
                    contentDescription = null,
                    contentScale = ContentScale.Inside
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = MEDIUM_PADDING)
                    .weight(0.25f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier
                        .weight(1f),
                    text = pet.getStringAge(),
                    color = MaterialTheme.colorScheme.descriptionColor
                )
                Image(
                    modifier = Modifier
                        .size(30.dp)
                        .clip(MaterialTheme.shapes.small)
                        .background(MaterialTheme.colorScheme.grayBlueColor),
                    painter = painterResource(MR.images.ic_qr_code),
                    contentDescription = null,
                    contentScale = ContentScale.Inside
                )
            }
        }
    }
}