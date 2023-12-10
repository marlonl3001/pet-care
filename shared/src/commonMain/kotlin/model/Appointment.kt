package model

data class Appointment(
    val name: String,
    val petCare: PetCare,
    val date: String,
    val completed: Boolean = false
)
