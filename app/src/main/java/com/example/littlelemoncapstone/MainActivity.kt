package com.example.littlelemoncapstone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.littlelemoncapstone.navigation.NavGraph
import com.example.littlelemoncapstone.ui.theme.LittleLemonCapstoneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LittleLemonCapstoneTheme {
                NavGraph()
            }
        }
    }
}