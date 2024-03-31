package com.example.tipcalculator

import android.icu.text.UnicodeSet.SpanCondition
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tipcalculator.ui.theme.TipCalculatorTheme
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TipCalculatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(  color = MaterialTheme.colorScheme.background) {
                    TipCalculator()
                }
            }
        }
    }
}
@Preview
@Composable
fun TipCalculator(){
    var bill by remember { mutableStateOf("")}
    var tip by remember { mutableStateOf("")}
    var result by remember { mutableStateOf(0)}
fun calculateBill(){
    result = (bill.toDouble() * tip.toDouble() / 100.0).roundToInt()
}

   Column(modifier= Modifier
       .background(Color.White)
       .fillMaxSize(),
       verticalArrangement = Arrangement.Center
       , horizontalAlignment = Alignment.CenterHorizontally
   ) {
Text(text = "Enter the bill amount",
    fontSize = 20.sp
    )
Spacer(modifier = Modifier.height(20.dp))
       OutlinedTextField(value = bill, onValueChange ={
           bill=it
       } )//textfield1
       Spacer(modifier = Modifier.height(20.dp))
       Text(text = "Enter the tip percent",
           fontSize = 20.sp
           )
       Spacer(modifier = Modifier.height(20.dp))
       OutlinedTextField(value = tip, onValueChange ={
           tip=it
       } )//textfield2
       Spacer(modifier = Modifier.height(20.dp))
       Spacer(modifier = Modifier.height(20.dp))
       Button(onClick = {

           calculateBill()
       }) {
           Text(text = "Calculate")
       }
       //show the result
       Text(text = "Tip amount is $result",
           fontSize = 20.sp
           )
   }//container columns
}
