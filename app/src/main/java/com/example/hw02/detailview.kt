package com.example.hw02


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true, showSystemUi = true)
@Preview(showSystemUi = true)
@Composable
fun detailview( current:viewdetail=views[0]
               ,onBackButtonClicked: () -> Unit = {}
                ,onMapButtonClicked: () -> Unit = {}
){
   Column (
       modifier = Modifier.fillMaxSize(),
       verticalArrangement = Arrangement.Center,
       horizontalAlignment = Alignment.CenterHorizontally
   ){
       Image(
           painter = painterResource(id= current.imageid),
           contentDescription = "",
           modifier = Modifier
               .fillMaxWidth()
               .fillMaxHeight(0.4f),
       )
       Text(text = current.title)
       Spacer(modifier = Modifier.height(50.dp))
       Button(
           modifier = Modifier
               .size(200.dp,50.dp),

           onClick = {
               onMapButtonClicked()
           }
       ) {
           Text(text = "map")
       }
       Spacer(modifier = Modifier.height(50.dp))
        Button(modifier = Modifier
            .size(200.dp,50.dp),onClick = { onBackButtonClicked() }) {
            Text(text = "BACK")
        }
   }
}
