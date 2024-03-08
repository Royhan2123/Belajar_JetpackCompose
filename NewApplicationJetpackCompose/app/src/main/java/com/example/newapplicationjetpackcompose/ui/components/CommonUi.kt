package com.example.newapplicationjetpackcompose.ui.components

import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.newapplicationjetpackcompose.R


@Composable
fun FormattedPriceLabel(subtotal: String, modifier: Modifier = Modifier) {
    Text(
        text =
        stringResource(
            id = R.string.subtotal_price, subtotal
        ),
        modifier = modifier,
        style = typography.headlineSmall
    )
}