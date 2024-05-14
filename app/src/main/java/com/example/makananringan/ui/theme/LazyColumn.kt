package com.example.makananringan.ui.theme

import android.os.Build
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MakananLazyColumn(
    makananColumn: MakananColumn,
    modifier: Modifier = Modifier,
    onItemClicked: (Int) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(5.dp)
            .background(Color.Magenta)
            .clickable { onItemClicked(makananColumn.id) }
            .padding(15.dp)
    ) {
        Image(
            painter = painterResource(id = makananColumn.gambar),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(RoundedCornerShape(50.dp))
                .size(100.dp)
        )
        Spacer(modifier = modifier.size(3.dp))
        Column {
            Text(
                text = " ${makananColumn.nama_makanan}", fontSize = 20.sp, color = Color.White
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewMakananLazyColumn() {
    MakananRinganTheme {
        MakananLazyColumn(
            makananColumn = MakananColumn(
                1,
                R.drawable.__snack_column,
                "snack (chitato)",
                "Makanan ringan yang banyak diminati."
            ),
            onItemClicked = { lazycolumnId ->
                println("LazyRow Id : $lazycolumnId")
            }
        )
    }
}
