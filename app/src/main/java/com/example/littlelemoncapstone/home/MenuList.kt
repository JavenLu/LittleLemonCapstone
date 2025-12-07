package com.example.littlelemoncapstone.home

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.littlelemoncapstone.R
import com.example.littlelemoncapstone.data.MenuItemEntity

@Composable
fun MenuListItem(item: MenuItemEntity) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = item.title,
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = item.description,
                style = MaterialTheme.typography.bodySmall,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "$${item.price}",
                style = MaterialTheme.typography.bodyMedium
            )
        }

        Spacer(modifier = Modifier.width(12.dp))

        val imageModifier = Modifier
            .size(80.dp)

        if (item.image.isBlank() || item.title == "Lemon Desert" || item.title == "Grilled Fish") {
            Image(
                painter = when(item.title) {
                    "Lemon Desert" -> painterResource(id = R.drawable.lemon_dessert)
                    "Grilled Fish"-> painterResource(id = R.drawable.grilled_fish)
                    else -> painterResource(id = R.drawable.bruschetta)
                },
                contentDescription = item.title,
                modifier = imageModifier,
                contentScale = ContentScale.Crop
            )
        } else {
            Log.i("imagePath=", item.image)
            Log.i("imagePath=", item.title)
            AsyncImage(
                model = item.image,
                contentDescription = item.title,
                modifier = imageModifier,
                contentScale = ContentScale.Crop
            )
        }
    }
}