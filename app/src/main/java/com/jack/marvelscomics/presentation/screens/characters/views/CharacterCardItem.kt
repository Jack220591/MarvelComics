package com.jack.marvelscomics.presentation.screens.characters.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.jack.marvelscomics.domain.models.MarvelCharacter

@OptIn(androidx.compose.material3.ExperimentalMaterial3Api::class)
@Composable
fun CharacterCardItem(
    model: MarvelCharacter,
    onItemClick: () -> Unit
) {
    ElevatedCard(
        onClick = onItemClick,
        modifier = Modifier
            .padding(
                horizontal = 16.dp,
                vertical = 8.dp
            ),
        elevation = CardDefaults.elevatedCardElevation(),
        shape = RoundedCornerShape(10.dp),

    ) {
        Box(
            modifier = Modifier.height(200.dp),
        ) {
            Image(
                painter = rememberImagePainter(model.thumbnail?.path + "." + model.thumbnail?.extension),
                contentDescription = model.name,
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            ),
                            startY = 300f
                        )
                    )
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Text(
                    text = model.name ?: "",
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.White
                )
            }

        }
    }
}

