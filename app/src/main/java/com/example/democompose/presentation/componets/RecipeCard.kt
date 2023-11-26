package com.example.democompose.presentation.componets

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.democompose.R
import com.example.democompose.domain.data.data.Recipe


@Composable
fun recipeCard(
    recipe: Recipe, onCLick: () -> Unit
) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .padding(bottom = 6.dp, top = 6.dp)
            .fillMaxWidth()
            .clickable {
                onCLick
            },
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        )
    ) {
        recipe.featuredImage.let { url ->
            Image(
                painter = painterResource(id = R.drawable.happy_meal),
                contentDescription = "Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(225.dp),
                contentScale = ContentScale.Crop,
            )
        }
        recipe.title.let {
            Row(
                modifier = Modifier.padding(top = 12.dp, bottom = 12.dp, start = 8.dp, end = 8.dp),

            ) {
                Text(text = recipe.title,
                modifier = Modifier
                    .fillMaxWidth(0.85f)
                    .wrapContentWidth(Alignment.Start)
                )
            }
        }
    }

}