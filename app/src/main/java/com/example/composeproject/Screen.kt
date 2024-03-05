package com.example.composeproject

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BlogCategory(imgId: Int, title: String, subTitle: String) {
    Card(elevation = 8.dp, modifier = Modifier.padding(8.dp)) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = imgId),
                contentDescription = "",
                colorFilter = ColorFilter.tint(Color.Blue),
                modifier = Modifier
                    .size(48.dp)
                    .padding(8.dp)
                    .weight(.2f)
            )
            ItemDescription(title, subTitle, Modifier.weight(.8f))
        }
    }
}

@Composable
fun ItemDescription(title: String, subTitle: String, modifier: Modifier) {
    Column(modifier = modifier) {
        Text(text = title, style = MaterialTheme.typography.h6)
        Text(
            text = subTitle,
            fontWeight = FontWeight.Thin,
            style = MaterialTheme.typography.subtitle1
        )
    }
}

@Preview()
@Composable
fun previewItem() {
    /*BlogCategory(
        imgId = android.R.drawable.ic_dialog_alert,
        title = "Programming",
        subTitle = "Learn different languages"
    )*/
    LazyColumn(
    content = {
        items(getListCategory()) {
            BlogCategory(imgId = it.imgId, title = it.title, subTitle = it.subTitle)
        }
    })
}

data class Category(
    val imgId: Int, val title: String, val subTitle: String
)

fun getListCategory(): List<Category> {
    val list = mutableListOf<Category>()
    list.add(
        Category(
            imgId = android.R.drawable.ic_dialog_alert,
            title = "Programming",
            subTitle = "Learn different languages"
        )
    )
    list.add(
        Category(
            imgId = android.R.drawable.ic_dialog_alert,
            title = "Programming",
            subTitle = "Learn different languages"
        )
    )
    list.add(
        Category(
            imgId = android.R.drawable.ic_dialog_alert,
            title = "Programming",
            subTitle = "Learn different languages"
        )
    )
    list.add(
        Category(
            imgId = android.R.drawable.ic_dialog_alert,
            title = "Programming",
            subTitle = "Learn different languages"
        )
    )
    list.add(
        Category(
            imgId = android.R.drawable.ic_dialog_alert,
            title = "Programming",
            subTitle = "Learn different languages"
        )
    )
    list.add(
        Category(
            imgId = android.R.drawable.ic_dialog_alert,
            title = "Programming",
            subTitle = "Learn different languages"
        )
    )
    list.add(
        Category(
            imgId = android.R.drawable.ic_dialog_alert,
            title = "Programming",
            subTitle = "Learn different languages"
        )
    )
    return list
}