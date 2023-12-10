package presentation.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import br.com.mdr.petcare.shared.MR
import dev.icerock.moko.resources.compose.painterResource
import dev.icerock.moko.resources.compose.stringResource
import ui.theme.EXTRA_SMALL_PADDING
import ui.theme.LARGE_PADDING
import ui.theme.topAppBarContentColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopBar(onMenuClick: () -> Unit, onImageClick: () -> Unit) {
    TopAppBar(
        modifier = Modifier
            .padding(horizontal = LARGE_PADDING),
        navigationIcon = {
             Image(
                 modifier = Modifier
                     .size(24.dp),
                 painter = painterResource(MR.images.ic_menu),
                 contentDescription = "")
        },
        title = {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier
                        .size(20.dp),
                    painter = painterResource(MR.images.ic_user_location),
                    contentDescription = stringResource(MR.strings.login_description))
                Text(
                    modifier = Modifier
                        .padding(horizontal = EXTRA_SMALL_PADDING),
                    text = buildAnnotatedString {
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                            append("Curitiba, ")
                        }
                        append("PR")
                    }
                )
            }
        },
        actions = {
            Image(
                modifier = Modifier
                    .size(42.dp)
                    .clickable { onImageClick.invoke() }
                    .clip(RoundedCornerShape(percent = 30)),
                painter = painterResource(MR.images.img_profile),
                contentDescription = stringResource(MR.strings.login_description),
                contentScale = ContentScale.Crop
            )
        },
        colors = TopAppBarDefaults
            .topAppBarColors(
                containerColor = Color.Transparent,
                actionIconContentColor = MaterialTheme.colorScheme.topAppBarContentColor,
                titleContentColor = Color.Black
            )
    )
}