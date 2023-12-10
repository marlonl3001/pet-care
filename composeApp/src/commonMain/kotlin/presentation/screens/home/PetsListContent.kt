package presentation.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.mdr.petcare.shared.MR
import model.Pet
import moe.tlaster.precompose.navigation.Navigator
import presentation.components.PetItem
import ui.theme.MEDIUM_PADDING

@Composable
fun PetsListContent(navigator: Navigator) {
    val pets = getPets()

    LazyRow(
        modifier = Modifier
            .fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = MEDIUM_PADDING),
        horizontalArrangement = Arrangement.spacedBy(MEDIUM_PADDING),
    ) {
        items(pets.size) {index ->
            PetItem(navigator = navigator, pet = pets[index])
        }
    }
}

fun getPets() = listOf(
    Pet(
        name = "Yoda",
        monthAge = 72,
        gender = MR.images.ic_male,
        image = MR.images.img_yoda,
        breed = "American Bully",
        specie = "Cão"
    ),
    Pet(
        name = "Lola",
        monthAge = 20,
        gender = MR.images.ic_female,
        image = MR.images.img_lola,
        breed = "Holland Lop",
        specie = "Coelho"
    ),
    Pet(
        name = "Paçoca",
        monthAge = 31,
        gender = MR.images.ic_male,
        image = MR.images.img_drake,
        breed = "Dachshund",
        specie = "Cão"
    ),
    Pet(
        name = "Cristal",
        monthAge = 9,
        gender = MR.images.ic_female,
        image = MR.images.img_cristal,
        breed = "SRD",
        specie = "Gato"
    )
)