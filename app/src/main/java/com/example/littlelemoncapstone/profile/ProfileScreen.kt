package com.example.littlelemoncapstone.profile


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.littlelemoncapstone.R
import com.example.littlelemoncapstone.data.UserPreferences
import com.example.littlelemoncapstone.navigation.Screen

import kotlinx.coroutines.launch

@Composable
fun ProfileScreen(navController: NavController) {
    val context = LocalContext.current
    val userPrefs = remember { UserPreferences(context) }
    val scope = rememberCoroutineScope()

    val firstName by userPrefs.firstName.collectAsState(initial = "")
    val lastName by userPrefs.lastName.collectAsState(initial = "")
    val email by userPrefs.email.collectAsState(initial = "")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 24.dp, vertical = 16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Little Lemon logo",
                    modifier = Modifier.height(60.dp).width(width =180.dp )

                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = "Personal information",
                style = MaterialTheme.typography.titleMedium.copy(
                    color = Color(0xFF333333)
                )
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "First name",
                style = MaterialTheme.typography.labelSmall.copy(
                    color = Color(0xFF495E57)
                )
            )
            OutlinedTextField(
                value = firstName,
                onValueChange = {},
                readOnly = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Last name",
                style = MaterialTheme.typography.labelSmall.copy(
                    color = Color(0xFF495E57)
                )
            )
            OutlinedTextField(
                value = lastName,
                onValueChange = {},
                readOnly = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Email",
                style = MaterialTheme.typography.labelSmall.copy(
                    color = Color(0xFF495E57)
                )
            )
            OutlinedTextField(
                value = email,
                onValueChange = {},
                readOnly = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp)
            )
        }

        Button(
            onClick = {
                scope.launch {
                    userPrefs.clear()
                    navController.navigate(Screen.Onboarding.route) {
                        popUpTo(0)
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFF4CE14),
                contentColor = Color(0xFF333333)
            ),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text("Log out")
        }
    }
}