package com.example.makananringan.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MakananLazyRow(
        makananRow: MakananRow,
        modifier: Modifier = Modifier,
        onItemClicked: (Int) -> Unit
) {

        Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(4.dp),
                modifier = modifier
                        .height(170.dp)
                        .width(150.dp)
                        .clickable { onItemClicked(makananRow.id) }
                        .background(Color.Magenta)
                        .padding(20.dp)
        ) {
                Image(
                        painter = painterResource(id = makananRow.gambar),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                                .clip(RoundedCornerShape(50.dp))
                                .size(100.dp)
                )
                Text(text = "${makananRow.nama_makanan}", fontSize = 20.sp, color = Color.White)
        }
}


@Preview(showBackground = true)
@Composable
private fun PreviewBMakananLazyRow() {
        MakananRinganTheme {
                MakananLazyRow(
                        makananRow = MakananRow(
                                1,
                                R.drawable.__mawar_row,
                                "Chitato",
                                "Snacks yang sangat lezat.",
                        ),
                        onItemClicked = { lazyrowId ->
                                println("LazyRow Id : $lazyrowId")
                        }
                )
        }
}