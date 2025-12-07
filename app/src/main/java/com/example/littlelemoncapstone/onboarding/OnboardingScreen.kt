package com.example.littlelemoncapstone.onboarding


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.littlelemoncapstone.R
import com.example.littlelemoncapstone.data.UserPreferences
import com.example.littlelemoncapstone.navigation.Screen
import kotlinx.coroutines.launch

@Composable
fun OnboardingScreen(navController: NavController) {
    val context = LocalContext.current
    val userPrefs = remember { UserPreferences(context) }
    val scope = rememberCoroutineScope()

    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

    val emailValid = remember(email) { email.contains("@") && email.contains(".") }
    val enabled = firstName.isNotBlank() && lastName.isNotBlank() && emailValid

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // 顶部 Logo
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Little Lemon logo",
                modifier = Modifier.align(Alignment.CenterVertically)
                    .width(180.dp)
                    .height(60.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // 深绿色横幅 “Let’s get to know you”
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF495E57))
                .padding(vertical = 24.dp, horizontal = 24.dp)
        ) {
            Text(
                text = "Let's get to know you",
                color = Color.White,
                style = MaterialTheme.typography.headlineSmall,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // 表单内容
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 24.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Top
        ) {
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
                onValueChange = { firstName = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp),
                singleLine = true
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
                onValueChange = { lastName = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp),
                singleLine = true
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
                onValueChange = { email = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp),
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Done
                )
            )
        }

        // 底部黄色 Register 按钮（逻辑保持不变）
        Button(
            onClick = {
                scope.launch {
                    userPrefs.saveUser(firstName, lastName, email)
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.Onboarding.route) { inclusive = true }
                    }
                }
            },
            enabled = enabled,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFF4CE14),
                contentColor = Color(0xFF333333)
            ),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(
                text = "Register",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}