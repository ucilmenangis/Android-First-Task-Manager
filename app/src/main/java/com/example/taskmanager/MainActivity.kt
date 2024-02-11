package com.example.taskmanager

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskmanager.ui.theme.TaskManagerTheme
import java.time.format.TextStyle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskManagerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TaskManager(completeText = "All tasks complete", text1 = "Nice Work!")
                }
            }
        }
    }
}

@Composable
fun TaskManager (completeText: String ,text1 : String ,modifier: Modifier = Modifier){
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        TaskCompleteImage()
        TaskManagerText(completeText = completeText, text1 = text1)
    }
}

@Composable
fun TaskManagerText(completeText: String ,text1 : String ,modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "$completeText",
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
            modifier = modifier
                .padding(vertical = 10.dp)
        )
        Text(
            text = "$text1",
            modifier = modifier
        )
    }
}

@Composable
fun TaskCompleteImage (modifier: Modifier = Modifier){
    val image = painterResource(R.drawable.ic_task_completed)
    Image(
        painter = image ,
        contentDescription = null,
        modifier = modifier
            .size(250.dp)
            .padding(10.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TaskManagerTheme {
    }
}