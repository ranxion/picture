package com.example.hw02

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun mainview(onNextButtonClicked: (viewdetail) -> Unit = {}) {

            LazyColumn(
                modifier = Modifier
                    .height(50.dp),
            ) {
                items(views) {  viewdetail ->
                    Card (modifier = Modifier.padding(40.dp)){
                        Button(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(100.dp),
                            shape = RectangleShape,
                            onClick = {
                                onNextButtonClicked(viewdetail)
                            }
                        ) {
                            Text(text = viewdetail.title,
                                fontSize = 24.sp
                            )

                        }
                    }
                    Spacer(modifier = Modifier.height(100.dp))
                }
            }



}