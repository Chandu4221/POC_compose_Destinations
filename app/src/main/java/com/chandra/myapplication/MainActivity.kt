package com.chandra.myapplication

import android.annotation.SuppressLint
import android.app.Activity
import android.app.KeyguardManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.chandra.myapplication.screens.NavGraphs
import com.chandra.myapplication.ui.theme.RaamcostaComposeDestinationsDemoTheme
import com.ramcosta.composedestinations.DestinationsNavHost
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        // HELPS TO OPEN THE APP
        // EVEN WHEN THE SCREEN IS IN SCREEN LOCK MODE
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1) {
            val keyguardManager = getSystemService(Context.KEYGUARD_SERVICE) as KeyguardManager
            keyguardManager.requestDismissKeyguard(this, null)
            setTurnScreenOn(true)
            setShowWhenLocked(true)
        }
        else{
            window?.apply {
                addFlags(WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON)
                addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED or
                        WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD)
            }
        }

        setContent {
            RaamcostaComposeDestinationsDemoTheme {
                DestinationsNavHost(
                    navGraph = NavGraphs.root
                )
            }
        }
    }
}