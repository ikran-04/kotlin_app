package com.example.project

sealed class Screens(val route :String){
    object Login :Screens("Login")

    object Home :Screens("Home")
    object Cards :Screens("Cards")

}