package ia.quantum.quantumpay.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Client(
    @DrawableRes val imageResourceId: Int,
    val clientName: String,
    val clientAge: Int,
    val dogHobbies: String
)
