package model

import androidx.compose.ui.graphics.Color
import dev.icerock.moko.resources.ImageResource

data class PetCare(
    val name: String,
    val icon: ImageResource,
    val color: Color,
    val subItems: List<CareItem>? = null
)

data class CareItem(
    val icon: ImageResource,
    val name: String
)
