package com.micromatic.basicmatics.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.res.*
import androidx.compose.ui.unit.*
import androidx.navigation.NavController
import com.micromatic.basicmatics.R
import com.micromatic.basicmatics.ui.navigation.AppScreens
import com.micromatic.basicmatics.ui.theme.BasicMaticsTheme

@Composable
fun MainScreen(navController: NavController) {
    BasicMaticsTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Title()
            OpsButtons(navController)
        }
    }
}

@Composable
fun BaseButton(text: Int, modifier: Modifier, onClick: () -> Unit) {
    Button(
        modifier = modifier,
        onClick = onClick,
        contentPadding = PaddingValues(
            start = 18.dp,
            top = 1.dp,
            end = 16.dp,
            bottom = 1.dp
        )
    ) {
        Text(stringResource(text))
    }
}

@Composable
fun Title() {
    Image(
        painterResource(R.drawable.bsm_android),
        "App logo",
        modifier = Modifier.size(192.dp)
    )
    Text(
        text = "Basic Matics",
        color = MaterialTheme.colorScheme.primary,
        fontSize = 30.sp
    )
}

@Composable
fun OpsButtons(navController: NavController) {
    Row(
        modifier = Modifier.padding(
            vertical = 40.dp
        ),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BaseButton(
                text = R.string.divide_button,
                modifier = Modifier
                    .padding(horizontal = 7.dp, vertical = 2.5.dp)
                    .offset(x = (-2.5).dp),
                onClick = {
                    navController.navigate(AppScreens.DivideScreen.route)
                }
            )
            BaseButton(
                text = R.string.add_button,
                Modifier
                    .padding(horizontal = 5.dp, vertical = 2.5.dp)
                    .offset(x = (-2.5).dp),
                onClick = {
                    navController.navigate(AppScreens.AddScreen.route)
                }
            )
        }
        Column (
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BaseButton(
                text = R.string.multiply_button,
                modifier = Modifier
                    .padding(horizontal = 7.dp, vertical = 2.5.dp)
                    .offset(x = 2.5.dp),
                onClick = {
                    navController.navigate(AppScreens.MultiplyScreen.route)
                }
            )
            BaseButton(
                text = R.string.subtract_button,
                Modifier
                    .padding(horizontal = 5.dp, vertical = 2.5.dp)
                    .offset(x = 2.5.dp),
                onClick = {
                    navController.navigate(AppScreens.SubtractScreen.route)
                }
            )
        }
    }
}
