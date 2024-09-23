package ia.quantum.nabomampay.domain

import androidx.annotation.DrawableRes

data class Client(
    @DrawableRes val imageResourceId: Int,
    val clientName: String,
    val clientAge: Int,
    val dogHobbies: String
)
