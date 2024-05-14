package com.example.makananringan.ui.theme

import android.widget.GridView
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MakananGrid(
    makananGrid: MakananGrid,
    modifier: Modifier = Modifier,
    onItemClicked: (Int) -> Unit
) {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClicked(makananGrid.id) },
        horizontalAlignment = Alignment.CenterHorizontally
    )  {
        Image(
            painter = painterResource(id = makananGrid.gambar),
            ContentDescription = null
        )
        Text(
            text = "${makananGrid.nama_makanan}"
        )

    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewHalamanGrid() {
    MakananRinganTheme {
        MakananGrid(makananGrid = MakananGrid)
        {1

        },
        onItemClicked = { lazygridId ->
            println("LazyRow Id : $lazygridId")

        }
    }
}