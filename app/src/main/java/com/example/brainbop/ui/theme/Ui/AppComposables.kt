package com.example.brainbop.ui.theme.Ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GenreChip(genre: String) {
    var isSelected by remember {
        mutableStateOf(false)
    }
    Box(modifier = Modifier
        .clip(RoundedCornerShape(30))
        .background(
            if (isSelected) Color.Black else Color.LightGray
        )
        .clickable { isSelected = !isSelected },
        contentAlignment = Alignment.Center
    ) {
        Text(fontSize = 18.sp, color =if (isSelected) Color.White else Color.Black,
            text = genre,
            modifier = Modifier.padding(8.dp))
    }

}

@Preview(showBackground = true)
@Composable
fun GenreChipPreview() {
    GenreChip("Music")
}