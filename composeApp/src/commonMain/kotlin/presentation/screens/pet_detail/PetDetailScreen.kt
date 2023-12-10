package presentation.screens.pet_detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
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
import dev.icerock.moko.resources.compose.stringResource
import moe.tlaster.precompose.navigation.Navigator
import navigation.Screen
import presentation.screens.home.careTypes
import presentation.screens.home.getPets
import ui.theme.CARD_ELEVATION
import ui.theme.EXTRA_LARGE_PADDING
import ui.theme.EXTRA_SMALL_PADDING
import ui.theme.LARGE_PADDING
import ui.theme.MEDIUM_PADDING
import ui.theme.SMALL_PADDING
import ui.theme.SUPER_SMALL_PADDING
import ui.theme.descriptionColor
import ui.theme.font18
import ui.theme.font22
import ui.theme.font28
import ui.theme.grayBlueColor
import ui.theme.titleColor

@Composable
fun PetDetailScreen(navigator: Navigator) {
    Scaffold(
        topBar = {
            PetDetailTopBar(navigator = navigator)
        },
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier
                    .size(50.dp),
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = Color.White,
                shape = CircleShape,
                onClick = {
                    navigator.navigate("pet_detail_menu")
                }
            ) {
                Icon(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(SMALL_PADDING),
                    imageVector = Icons.Default.Add,
                    contentDescription = null
                )
            }
        },
        floatingActionButtonPosition = FabPosition.End
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(MR.images.img_background_shade),
                contentScale = ContentScale.Crop)
        ) {
            PetDetailCard(navigator = navigator)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PetDetailCard(navigator: Navigator) {
    val careTypes = careTypes()

    ElevatedCard(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                horizontal = EXTRA_LARGE_PADDING,
                vertical = 90.dp
            ),
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
            PetInfo(modifier = Modifier
                .weight(1f)
            )
            Text(
                modifier = Modifier
                    .padding(horizontal = MEDIUM_PADDING, vertical = SMALL_PADDING),
                text = stringResource(MR.strings.my_history),
                color = MaterialTheme.colorScheme.titleColor,
                fontSize = MaterialTheme.typography.font22,
                fontWeight = FontWeight.SemiBold
            )
            LazyVerticalStaggeredGrid(
                columns = StaggeredGridCells.Adaptive(131.dp),
                contentPadding = PaddingValues(
                    bottom = LARGE_PADDING,
                    end = LARGE_PADDING,
                    start = LARGE_PADDING
                ),
                horizontalArrangement = Arrangement.spacedBy(MEDIUM_PADDING),
                verticalItemSpacing = MEDIUM_PADDING,
                content = {
                    items(careTypes) { careType ->
                        PetGridItem(navigator = navigator, petCare = careType)
                    }
                }
            )
        }
    }
}

@Composable
fun PetInfo(modifier: Modifier) {
    val pet = getPets().first()

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(SMALL_PADDING)
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
                .height(50.dp)
                .padding(horizontal = MEDIUM_PADDING),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier
                    .weight(1f),
                text = pet.name,
                color = MaterialTheme.colorScheme.titleColor,
                fontSize = MaterialTheme.typography.font28,
                fontWeight = FontWeight.Bold
            )
            Image(
                modifier = Modifier
                    .fillMaxHeight()
                    .clip(MaterialTheme.shapes.medium)
                    .background(MaterialTheme.colorScheme.grayBlueColor)
                    .padding(SMALL_PADDING),
                painter = painterResource(pet.gender),
                contentDescription = null,
                contentScale = ContentScale.Fit
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = MEDIUM_PADDING)
                .height(50.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier
                .weight(1f)
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = pet.breed,
                    color = MaterialTheme.colorScheme.descriptionColor,
                    fontSize = MaterialTheme.typography.font18,
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = pet.getStringAge(),
                    color = MaterialTheme.colorScheme.descriptionColor,
                    fontSize = MaterialTheme.typography.font18,
                )
            }
            Image(
                modifier = Modifier
                    .fillMaxHeight()
                    .clip(MaterialTheme.shapes.medium)
                    .background(MaterialTheme.colorScheme.grayBlueColor)
                    .padding(SMALL_PADDING),
                painter = painterResource(MR.images.ic_qr_code),
                contentDescription = null,
                contentScale = ContentScale.Fit
            )
        }
    }
}