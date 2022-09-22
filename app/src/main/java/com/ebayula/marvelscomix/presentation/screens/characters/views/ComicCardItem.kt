package com.ebayula.marvelscomix.presentation.screens.characters.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.size.Scale
import com.ebayula.marvelscomix.domain.models.Comic

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComicCardItem(
    model: Comic,
    onItemClick: () -> Unit
) {
    ElevatedCard(
        onClick = onItemClick,
        modifier = Modifier
            .padding(
                horizontal = 8.dp,
                vertical = 8.dp
            )
            .width(200.dp),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 6.dp, pressedElevation = 2.dp),
        shape = RoundedCornerShape(10.dp),
    ) {
        Box {
            Image(
                painter = rememberImagePainter(
                    data = model.thumbnail?.path + "." + model.thumbnail?.extension,
                    builder = {
                        crossfade(true)
                        scale(Scale.FIT)
                    }
                ),
                modifier = Modifier
                    .fillMaxWidth(),
                contentDescription = model.title,
                contentScale = ContentScale.FillWidth
            )
        }
    }
}