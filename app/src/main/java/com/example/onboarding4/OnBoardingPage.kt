package com.example.onboarding4

import androidx.annotation.DrawableRes

sealed class OnBoardingPage (
    @DrawableRes
    val Image: Int ,
    val Title : String ,
    val Description : String

){


    object  First : OnBoardingPage(
        Image = R.drawable.image,
        Title = "Comprehensive Computer Services",
        Description = "The Comprehensive Computer Services app provides all the tech solutions you need"

    )
    object  Second : OnBoardingPage(
        Image = R.drawable.frist,
        Title = "PC Care Services",
        Description = "PC Care offers quick and professional hardware repairs, system boosts."

    )
    object  Third : OnBoardingPage(
        Image = R.drawable.sceand,
        Title = "TechSupport",
        Description = "TechSupport provides fast and reliable computer repairs."

    )

}