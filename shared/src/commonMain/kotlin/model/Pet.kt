package model

import dev.icerock.moko.resources.ImageResource

data class Pet(
    val name: String,
    val monthAge: Int,
    val gender: ImageResource,
    val image: ImageResource,
    val specie: String,
    val breed: String,
    val qrCode: String? = null
) {
    private val yearMonths = 12
    private var strAge = ""
    private val year = "ano"
    private val years = "anos"
    private val month = "mês"
    private val months = "meses"

    fun getStringAge(): String {
        if (monthAge > yearMonths) {
            val diffYears = monthAge / yearMonths
            val diffMonths = monthAge % yearMonths

            val strDiffYears =
                "$diffYears " +
                    if (diffYears > 1) years else year

            strAge =
                if (diffMonths > 0) {
                    strDiffYears + " e " +
                            getStringMonths(diffMonths)
                } else {
                    strDiffYears
                }
        } else {
            strAge = getStringMonths(monthAge)
        }
        return strAge
    }

    private fun getStringMonths(monthAge: Int) =
        if(monthAge > 1) {
            "$monthAge $months"
        } else {
            "$monthAge $month"
        }
}
