package presentation.screens.pet_detail

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import moe.tlaster.precompose.navigation.Navigator
import presentation.components.AppIcon
import ui.theme.LARGE_PADDING
import ui.theme.SMALL_PADDING
import ui.theme.topAppBarContentColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PetDetailTopBar(navigator: Navigator) {
    TopAppBar(
        modifier = Modifier
            .padding(horizontal = LARGE_PADDING),
        navigationIcon = {
            IconButton(onClick = { navigator.popBackStack() }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.tertiary
                )
            }
        },
        title = {},
        actions = {
            AppIcon(
                icon = Icons.Filled.Edit,
                contentDescription = null
            ) {
                navigator.navigate("pet_edit")
            }
            Spacer(Modifier.size(SMALL_PADDING))
            AppIcon(
                icon = Icons.Filled.Delete,
                contentDescription = null
            ) {
                navigator.navigate("pet_delete")
            }
        },
        colors = TopAppBarDefaults
            .topAppBarColors(
                containerColor = Color.Transparent,
                actionIconContentColor = MaterialTheme.colorScheme.topAppBarContentColor,
                titleContentColor = Color.Black
            )
    )
}