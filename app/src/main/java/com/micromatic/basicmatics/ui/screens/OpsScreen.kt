package com.micromatic.basicmatics.ui.screens

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.micromatic.basicmatics.R
import com.micromatic.basicmatics.ops.*
import com.micromatic.basicmatics.ui.theme.BasicMaticsTheme

@Composable
fun OpsScreen(op: String) {
        BasicMaticsTheme {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Title()
            OpsCalc(op)
        }
    }
}

@Composable
fun OpsCalc(op: String) {
    val divide = stringResource(R.string.divide)
    val remainder = stringResource(R.string.remainder)
    val multiply = stringResource(R.string.multiply)
    val add = stringResource(R.string.add)
    val subtract = stringResource(R.string.subtract)

    var text1 by remember { mutableStateOf("") }
    var text2 by remember { mutableStateOf("") }
    var calcEnabled by remember { mutableStateOf(false) }
    var result by remember { mutableStateOf("") }
    var opTitle by remember { mutableStateOf(op) }
    val opIsDivision = (op == divide || op == remainder)

    calcEnabled = when {
        text1 != "" && text2 != "" -> true
        else -> false
    }

    val change1: (String) -> Unit = {
        text1 = it
    }
    val change2: (String) -> Unit = {
        text2 = it
    }


    Text(
        text = "- $opTitle -",
        color = MaterialTheme.colorScheme.primary,
        fontSize = 20.sp,
        textAlign = TextAlign.Center
    )
    Spacer(Modifier.size(width = 10.dp, height = 10.dp))
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        if (opIsDivision) {
            Button(
                onClick = {
                    opTitle= when (opTitle) {
                        divide -> remainder
                        remainder -> divide
                        else -> opTitle
                    }
                },
            ) {
                Text(
                    text = when (opTitle) {
                        divide -> remainder
                        remainder -> divide
                        else -> ""
                    }
                )
            }
        }
        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(
                vertical = 2.5.dp,
                horizontal = 7.dp
            )

        ) {
            OutlinedTextField(
                value = text1,
                onValueChange = change1,
                label = { Text(stringResource(R.string.first_num)) },
                modifier = Modifier
                    .padding(horizontal = 7.dp,)
                    .weight(1f)
                    .wrapContentWidth(Alignment.Start),
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                )
            )
            Text(
                text = when (opTitle) {
                    divide -> "/"
                    remainder -> "%"
                    multiply -> "\u2715"
                    add -> "+"
                    subtract -> "-"
                    else -> ""
                },
                fontSize = when (opTitle) {
                    multiply -> 19.sp
                   else -> 25.sp
                }
            )
            OutlinedTextField(
                value = text2,
                onValueChange = change2,
                label = { Text(stringResource(R.string.second_num)) },
                modifier = Modifier
                    .padding(horizontal = 7.dp)
                    .weight(1f)
                    .wrapContentWidth(Alignment.Start),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(vertical = 5.dp)
        ) {
            Button(
                onClick = {
                          when (opTitle) {
                              divide ->
                                  result = divide(text1.toDouble(), text2.toDouble())
                              remainder ->
                                  result = remainder(text1.toDouble(), text2.toDouble())
                              multiply ->
                                  result = multiply(text1.toDouble(), text2.toDouble())
                              add ->
                                  result = add(text1.toDouble(), text2.toDouble())
                              subtract ->
                                  result = subtract(text1.toDouble(), text2.toDouble())
                          }
                },
                modifier = Modifier.padding(horizontal = 5.dp),
                enabled = calcEnabled
            ) {
                Text(
                    text = stringResource(R.string.calculate),
                    fontSize = 18.sp
                )
            }
            Button(
                onClick = {
                    text1 = ""
                    text2 = ""
                    result = ""
                },
                modifier = Modifier.padding(horizontal = 5.dp)
            ) {
                Text(
                    text = stringResource(R.string.clear),
                    fontSize = 18.sp
                )
            }
        }
        Text(
            modifier = Modifier.padding(vertical = 20.dp),
            text = result,
            fontSize = 30.sp,
            color = when {
                isSystemInDarkTheme() -> Color.White
                else -> Color.Black
            },
        )
    }
}

@Preview(showBackground = true)
@Composable
fun OpsPreview() {
    OpsScreen(op = "Multiply")
}