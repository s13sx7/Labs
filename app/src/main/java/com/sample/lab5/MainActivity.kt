package com.sample.lab5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sample.lab5.ui.theme.Lab5Theme
import androidx.compose.material3.Slider
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab5Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TipCalculatorScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun TipCalculatorScreen(
    modifier: Modifier = Modifier
) {
    var orderAmount by remember { mutableStateOf("") }
    var dishCount by remember { mutableStateOf("") }
    var tipPercentage by remember { mutableStateOf(0f) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Сумма заказа
        Text(text = "Сумма заказа:")
        TextField(
            value = orderAmount,
            onValueChange = { orderAmount = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Количество блюд
        Text(text = "Количество блюд:")
        TextField(
            value = dishCount,
            onValueChange = { dishCount = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Чаевые
        Text(text = "Чаевые:")
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Slider(
                value = tipPercentage,
                onValueChange = { tipPercentage = it },
                valueRange = 0f..25f,
                modifier = Modifier
                    .width(300.dp)
            )
            Text(text = "${tipPercentage.toInt()}%")
        }
    }
}

@Composable
private fun RadioButtonGroup(
    selected: Int,
    discount: Int
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        RadioButton(
            selected = selected == discount,
            onClick = {}
        )
        Text(text = "$selected%")
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTipCalculator() {
    Lab5Theme {
        TipCalculatorScreen()
    }
}
