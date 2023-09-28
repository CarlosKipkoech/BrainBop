package com.example.brainbop

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.brainbop.ui.theme.BrainBopTheme
import com.example.brainbop.ui.theme.Ui.GenreChip

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BrainBopTheme {
                MyMainScreen()
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyMainScreen() {
    val genres = listOf("Brainstorm", "Video", "Books", "Others")

    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(16.dp) // Adjust padding as needed
        ) {
            // Building an annotated text
            Text(
                fontSize = 40.sp,
                color = Color.Black,
                fontWeight = FontWeight.Light,
                modifier = Modifier.padding(bottom = 25.dp),
                text = buildAnnotatedString {
                    append("Choose what \n")
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    ) {
                        append("\nto learn today ?")
                    }
                }
            )

            LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                items(genres) { genre ->
                    GenreChip(genre = genre)
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun MyMainScreenPreview() {
    BrainBopTheme {
        MyMainScreen()
    }
}
