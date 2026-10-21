package com.sample.lab3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sample.lab3.ui.theme.Lab3Theme
import android.widget.Button
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.TextField
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import com.sample.lab3.ui.theme.Lab3Theme
import com.sample.lab4.ui.theme.Lab4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab4Theme() {
                // Использование Scaffold для базовой разметки экрана
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // Передаем innerPadding в наш Composable-элемент экрана
                    AgeAnaliz(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun IntTaker(modifier: Modifier = Modifier) {
    val IntInput = remember { mutableStateOf("") }
    val resultInt = remember { mutableStateOf("") }

    Column(modifier = modifier.padding(16.dp).fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {

        TextField(
            value = IntInput.value,
            onValueChange = { IntInput.value = it },
            label = { Text("Введите ваш возраст") }
        )

        Button(onClick = {
            val number = IntInput.value.toIntOrNull()
            if (number == null) {
                resultInt.value = "Введите число"
            } else {
                resultInt.value = Int_aproximation(number).toString();
            }
        }) {
            Text("Вычислить")
        }
        Text(text = resultInt.value)
    }

}

fun Int_aproximation(number: Int): Int {
    if (number > 7)
        return -1;
    var a = 0;
    for (i in 1..10000) {
        a += 1/i;
        if (a > number)
            break;
    }
    return a;
}
