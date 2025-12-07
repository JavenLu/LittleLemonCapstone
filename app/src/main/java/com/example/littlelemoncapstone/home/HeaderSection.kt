package com.example.littlelemoncapstone.home


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.littlelemoncapstone.R
import com.example.littlelemoncapstone.navigation.Screen

@Composable
fun HeaderSection(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Little Lemon logo",
            modifier = Modifier
                .align(Alignment.Center)
                .width(180.dp)
                .height(60.dp)
        )

        IconButton(
            onClick = { navController.navigate(Screen.Profile.route) },
            modifier = Modifier.align(Alignment.CenterEnd)
        ) {
            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = "Profile", modifier = Modifier.width(90.dp)
                    .height(90.dp).align(Alignment.Center)

            )
        }
    }
}