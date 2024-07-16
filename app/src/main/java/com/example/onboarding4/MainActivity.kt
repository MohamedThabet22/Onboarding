package com.example.onboarding4

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.navigation.compose.rememberNavController
import com.example.onboarding4.NavGraph.Screen
import com.example.onboarding4.NavGraph.SetupNavGraph
import com.example.onboarding4.mvvm.MainViewModel
import com.example.onboarding4.mvvm.Pager
import com.example.onboarding4.ui.theme.Onboarding4Theme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = MainViewModel(application)
        installSplashScreen().setKeepOnScreenCondition {
            !viewModel.isLoading.value
        }
        enableEdgeToEdge()
        setContent {
            Onboarding4Theme {
                val pager by viewModel.data.observeAsState()
                if (pager != null) {
                    val startDestination =
                        if (pager!!.isOnboardingComplete) Screen.Home.route else Screen.Welcome.route
                    val navController = rememberNavController()
                    SetupNavGraph(
                        NavControl = navController,
                        viewModel = viewModel,
                        startDestination = startDestination
                    )
                }else{
                    viewModel.updateOrCreateData(Pager(isOnboardingComplete = false))
                }
            }
        }
    }
}
