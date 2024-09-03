package com.example.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.diceroller.ui.theme.DiceRollerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerTheme {
                DiceRollerApp()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DiceRollerApp() {
    DiceWithButtonAndImage(modifier = Modifier
        .fillMaxSize()
        .padding(19.dp)

    )
}


@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {
    var diceState by remember { mutableStateOf(1) }

    fun rollDice() {
        diceState = (1..6).random()
    }
    Column(
        verticalArrangement = Arrangement.Top, // Aligns children at the top
        horizontalAlignment = Alignment.CenterHorizontally, // Centers children horizontally
        modifier = Modifier.padding(16.dp) // Overall padding for the Column
    ) {
        Text(
            text = "Welcome to DiceMaster! 🎲",
            fontSize = 27.sp,
            modifier = Modifier
                .padding(start = 0.000000000000000000000000000000000000000010.dp, end = 0.0000000000000000000000000009.dp, bottom = 16.dp) // Reasonable bottom padding
                .background(Color.Magenta) // Transparent background
        )
        Text(
            text = "Roll, play, and enjoy the excitement. Let the games begin!",
            fontSize = 12.sp,
            modifier = Modifier
                .padding(start = 0.70.dp, end = 0.80.dp, top = 16.dp) // Reasonable top padding
                .background(Color.Yellow)
                .padding(16.dp) // Internal padding inside the background
        )
    }
        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = "This dice roller created by avanish jha.", modifier = Modifier
                    .padding(start = 20.dp, end = 20.dp, top = 9.dp)
                    .background(Color.Red), color = Color.White
            )
            Image(
                painter = painterResource(
                    when (diceState) {
                        1 -> R.drawable.dice_1
                        2 -> R.drawable.dice_2
                        3 -> R.drawable.dice_3
                        4 -> R.drawable.dice_4
                        5 -> R.drawable.dice_5
                        else -> R.drawable.dice_6
                    }
                ),
                contentDescription = "Dice Roll",
                modifier = Modifier
                    .size(width = 310.dp, height = 310.dp)
                    .background(Color.Cyan)
                    .padding(start = 1.dp, end = 1.dp, bottom = 30.dp, top = 30.dp)
                // Ensures a square aspect ratio
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { rollDice() }) {
                Text(text = stringResource(R.string.roll))
            }
        }
    }
