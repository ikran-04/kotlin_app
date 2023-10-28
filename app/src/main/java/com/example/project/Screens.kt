package com.example.project

sealed class Screens(val route :String){
    object Home :Screens("Home")
    object Cards :Screens("Cards")

}