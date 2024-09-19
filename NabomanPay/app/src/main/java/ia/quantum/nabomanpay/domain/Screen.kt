package ia.quantum.nabomanpay.domain

sealed class Screen(val route: String){
    data object Login: Screen(route = "login_view")
    data object Home: Screen(route = "home_view")
    data object Profile: Screen(route = "home_profile")
}