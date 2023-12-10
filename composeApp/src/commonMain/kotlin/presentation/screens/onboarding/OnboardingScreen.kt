package presentation.screens.onboarding

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import br.com.mdr.petcare.shared.MR
import dev.icerock.moko.resources.compose.painterResource
import dev.icerock.moko.resources.compose.stringResource
import domain.model.OnboardingPage
import moe.tlaster.precompose.navigation.Navigator
import navigation.Screen
import presentation.components.RoundedButton
import ui.theme.BUTTON_HEIGHT
import ui.theme.SUPER_LARGE_PADDING
import ui.theme.MEDIUM_PADDING
import ui.theme.PAGER_ITEM_HEIGHT
import ui.theme.PAGING_INDICATOR_HEIGHT
import ui.theme.PAGING_INDICATOR_SPACING
import ui.theme.PAGING_INDICATOR_WIDTH
import ui.theme.SELECTED_PAGING_INDICATOR_WIDTH
import ui.theme.activeIndicatorColor
import ui.theme.buttonBackgroundColor
import ui.theme.descriptionColor
import ui.theme.inactiveIndicatorColor
import ui.theme.titleColor
import util.Constants.LAST_ONBOARDING_PAGE

@Composable
fun OnboardingScreen(navigator: Navigator) {
    Onboarding(navigator)
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Onboarding(navigator: Navigator) {
    val pages = listOf(
        OnboardingPage.First,
        OnboardingPage.Second,
        OnboardingPage.Third,
        OnboardingPage.Fourth
    )

    val pagerState = rememberPagerState(pageCount = { pages.size })

    Column(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(MR.images.img_background_shade),
                contentScale = ContentScale.Crop)
            .verticalScroll(rememberScrollState())
    ) {
        Image(
            modifier = Modifier
                .padding(start = MEDIUM_PADDING, top = MEDIUM_PADDING),
            painter = painterResource(MR.images.img_logo_mini),
            contentDescription = "Logo"
        )
        HorizontalPager(
            modifier = Modifier
                .weight(0.7f),
            state = pagerState,
            verticalAlignment = Alignment.CenterVertically
        ) { position ->
            PagerScreen(pages[position])
        }
        PagerIndicator(
            pageCount = pages.size,
            pagerState = pagerState
        )
        RegisterButton(pagerState = pagerState, modifier = Modifier.weight(0.09f)) {
            navigator.navigate(Screen.Home.route)
        }
        TextButton(pagerState = pagerState, modifier = Modifier.weight(0.09f)) {
            navigator.navigate(Screen.Login.route)
        }
    }
}

@Composable
fun PagerScreen(onBoardingPage: OnboardingPage) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(PAGER_ITEM_HEIGHT),
            painter = painterResource(onBoardingPage.image),
            contentDescription = onBoardingPage.title.toString())

        Text(
            modifier = Modifier.fillMaxWidth(),
            color = MaterialTheme.colorScheme.titleColor,
            fontSize = MaterialTheme.typography.headlineSmall.fontSize,
            fontWeight = FontWeight.Bold,
            text = stringResource(onBoardingPage.title),
            textAlign = TextAlign.Center
        )

        Text(
            modifier = Modifier.padding(MEDIUM_PADDING),
            color = MaterialTheme.colorScheme.descriptionColor,
            fontSize = MaterialTheme.typography.bodyLarge.fontSize,
            text = stringResource(onBoardingPage.description),
            textAlign = TextAlign.Center)
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PagerIndicator(pageCount: Int, pagerState: PagerState, modifier: Modifier = Modifier) {
    Row(
        modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        repeat(pageCount) { iteration ->
            val color =
                if (pagerState.currentPage == iteration)
                    MaterialTheme.colorScheme.activeIndicatorColor
                else
                    MaterialTheme.colorScheme.inactiveIndicatorColor

            val shape =
                if (pagerState.currentPage == iteration)
                    RoundedCornerShape(6.dp)
                else
                    CircleShape

            val width = if (pagerState.currentPage == iteration)
                SELECTED_PAGING_INDICATOR_WIDTH
            else
                PAGING_INDICATOR_WIDTH

            Box(
                modifier = Modifier
                    .padding(PAGING_INDICATOR_SPACING)
                    .clip(shape)
                    .background(color)
                    .width(width)
                    .height(PAGING_INDICATOR_HEIGHT)
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RegisterButton(
    modifier: Modifier,
    pagerState: PagerState,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier
            .padding(horizontal = SUPER_LARGE_PADDING),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        AnimatedVisibility(
            modifier = Modifier.fillMaxWidth(),
            visible = pagerState.currentPage == LAST_ONBOARDING_PAGE) {
            RoundedButton(
                text = stringResource(MR.strings.sign_up),
                onClick = onClick
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TextButton(
    modifier: Modifier,
    pagerState: PagerState,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier
            .padding(horizontal = SUPER_LARGE_PADDING),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        AnimatedVisibility(
            modifier = Modifier.fillMaxWidth(),
            visible = pagerState.currentPage == LAST_ONBOARDING_PAGE
        ) {
            Button(
                modifier = Modifier
                    .height(BUTTON_HEIGHT),
                onClick = onClick,
                colors = ButtonDefaults.buttonColors(
                    contentColor = MaterialTheme.colorScheme.buttonBackgroundColor,
                    containerColor = Color.Transparent
                )) {
                Text(
                    color = MaterialTheme.colorScheme.buttonBackgroundColor,
                    text = stringResource(MR.strings.sign_in))
            }
        }
    }
}