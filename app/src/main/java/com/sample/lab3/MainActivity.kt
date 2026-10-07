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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab3Theme {
                // Использование Scaffold для базовой разметки экрана
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // Передаем innerPadding в наш Composable-элемент экрана
                    AgeAnaliz(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

fun Age(age: Int): String {
    return when {
        age < 0 -> "Вы еще не родились"
        age <= 20 -> "Вы слишком молоды!"
        age in setOf(30, 40, 50, 60) -> "Поздравляем с повышением!"
        age == 65 -> "Преподносим вам золотые часы!"
        age > 65 -> "Вы слишком стары!"
        else -> "Продолжайте накапливать опыт!"
    }
}
