package domain.model

import br.com.mdr.petcare.shared.MR
import dev.icerock.moko.resources.ImageResource
import dev.icerock.moko.resources.StringResource

sealed class OnboardingPage(
    val image: ImageResource,
    val title: StringResource,
    val description: StringResource
) {

    data object First: OnboardingPage(
        image = MR.images.img_welcome,
        title = MR.strings.title1,
        description = MR.strings.desc1
    )

    data object Second: OnboardingPage(
        image = MR.images.img_appointments,
        title = MR.strings.title2,
        description = MR.strings.desc2
    )

    data object Third: OnboardingPage(
        image = MR.images.img_vaccine,
        title = MR.strings.title3,
        description = MR.strings.desc3
    )

    data object Fourth: OnboardingPage(
        image = MR.images.img_pet_scanning,
        title = MR.strings.title4,
        description = MR.strings.desc4
    )
}