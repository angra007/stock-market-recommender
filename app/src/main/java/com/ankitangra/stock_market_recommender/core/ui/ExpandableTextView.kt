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
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
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

    val localSpacing = LocalSpacing.current

    Box(
        modifier = modifier
            .fillMaxHeight()
            .padding(start = localSpacing.spaceSmall)
            .background(Color.White)
    ) {
        OutlinedTextField(
            value = textValue,
            readOnly = true,
            onValueChange = {

            },
            modifier = Modifier.fillMaxSize(),
            label = {
                Text(text = label)
            },
            trailingIcon = {
                Icon(
                    painter = if (expanded) { painterResource(id = R.drawable.ic_launcher_background) } else { painterResource(id = R.drawable.ic_launcher_foreground) },
                    contentDescription = "",
                    Modifier.clickable { toggleState () }
                )
            }
        )

        ExpandableMenu(
            expanded = expanded,
            items = items,
            onSelect = {
                onItemSelected(it)
            },
            onDismissRequest = {
                toggleState ()
            }
        )
    }
}

@Composable
fun ExpandableMenu(
    expanded: Boolean,
    items : List<String>,
    onSelect:(String) -> Unit,
    onDismissRequest: () -> Unit,
) {
    DropdownMenu(
        expanded = expanded,
        onDismissRequest = {
            onDismissRequest()
        },
    )  {
        items.forEachIndexed { index, stock ->
            DropdownMenuItem(onClick = {
                onSelect(items[index])
            }) {
                Text(stock)
            }
        }
    }
}