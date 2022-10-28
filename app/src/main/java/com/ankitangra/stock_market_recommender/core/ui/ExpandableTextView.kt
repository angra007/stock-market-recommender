package com.ankitangra.stock_market_recommender.core.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import com.ankitangra.stock_market_recommender.R

@Composable
fun ExpandableTextView(
    textValue: String,
    label: String,
    modifier: Modifier,
    items: List<String>,
    expanded: Boolean,
    onItemSelected: (String) -> Unit,
    toggleState: () -> Unit
) {
    Box(
        modifier = modifier
            .background(Color.White)
    ) {
        OutlinedTextField(
            value = textValue,
            readOnly = true,
            enabled = false,
            onValueChange = {

            },
            modifier = Modifier
                .fillMaxSize()
                .clickable {
                toggleState ()
            },
            label = {
                Text(text = label)
            },
            trailingIcon = {
                Icon(
                    painter = if (expanded) { painterResource(id = R.drawable.ic_arrow_up) } else { painterResource(id = R.drawable.ic_arrow_down) },
                    contentDescription = "",
                    Modifier.clickable { toggleState () }
                )
            }
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = {
                toggleState()
            },
        )  {
            items.forEachIndexed { index, stock ->
                DropdownMenuItem(onClick = {
                    onItemSelected(items[index])
                }) {
                    Text(stock)
                }
            }
        }
    }
}
