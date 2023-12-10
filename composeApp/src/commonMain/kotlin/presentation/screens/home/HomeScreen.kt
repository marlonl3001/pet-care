package presentation.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import br.com.mdr.petcare.shared.MR
import dev.icerock.moko.resources.compose.stringResource
import model.Appointment
import model.PetCare
import moe.tlaster.precompose.navigation.Navigator
import ui.theme.LARGE_PADDING
import ui.theme.MEDIUM_PADDING
import ui.theme.SMALL_PADDING
import ui.theme.healthColor
import ui.theme.hygieneColor
import ui.theme.titleColor

@Composable
fun HomeScreen(navigator: Navigator) {
    Scaffold(
        topBar = {
            HomeTopBar(
                onMenuClick = {

                },
                onImageClick = {
                    navigator.navigate("profile")
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(MEDIUM_PADDING)
        ) {
            WelcomeHeader()
            PetCareCategories()
            Box(
                modifier = Modifier
                    .padding(vertical = SMALL_PADDING)
            ) {
                AppointmentList(navigator = navigator, appointments = getAppointments())
            }
            AddPetItem(navigator = navigator)
            PetsListContent(navigator = navigator)
        }
    }
}

@Composable
private fun AddPetItem(navigator: Navigator) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = LARGE_PADDING, vertical = SMALL_PADDING),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(MR.strings.my_pets),
            color = MaterialTheme.colorScheme.titleColor,
            fontSize = MaterialTheme.typography.headlineSmall.fontSize,
            fontWeight = FontWeight.Bold
        )
        FloatingActionButton(
            modifier = Modifier
                .size(50.dp),
            contentColor = Color.White,
            shape = CircleShape,
            onClick = {
                navigator.navigate("register_pet")
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
    }
}

@Composable
private fun getAppointments() = listOf(
    Appointment(
        name = "Vacina Yoda",
        petCare = PetCare(stringResource(MR.strings.health), MR.images.ic_healthy, MaterialTheme.colorScheme.healthColor),
        date = "09:00h - 16 de Setembro, 2020"
    ),
    Appointment(
        name = "Dar Bravecto",
        petCare = PetCare(stringResource(MR.strings.health), MR.images.ic_healthy, MaterialTheme.colorScheme.healthColor),
        date = "10:00h - 17 de Setembro, 2020"
    ),
    Appointment(
        name = "Consulta Dr. Igor",
        petCare = PetCare(stringResource(MR.strings.appointment), MR.images.ic_veterinary, MaterialTheme.colorScheme.hygieneColor),
        date = "11:00h - 18 de Setembro, 2020"
    )
)
