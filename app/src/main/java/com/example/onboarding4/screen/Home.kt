package com.example.onboarding.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp


@Composable
fun  HomeScreen(

){
        Column(
            modifier= Modifier.fillMaxSize(),
            verticalArrangement =  Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(text = "Home"
            , fontSize = 40.sp,
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Bold
            )

        }
}