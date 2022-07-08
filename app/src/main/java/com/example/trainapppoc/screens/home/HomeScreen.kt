package com.example.trainapppoc.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.trainapppoc.components.TrainButton
import com.example.trainapppoc.navigation.Screens
import com.example.trainapppoc.R
import java.time.Instant
import java.util.*

@Composable
fun HomeScreen(navController: NavController){
    //val context = LocalContext.current
//    val time = ZonedDateTime.now(ZoneId.of("Israel"))
//    val date = Date.from(time.toInstant())
    val nowDate: Date = Date.from(Instant.now())
    Surface(modifier = Modifier.fillMaxWidth().fillMaxHeight()) {
        Image(
            painter = painterResource(id = R.drawable.train_dino_ready),
            contentDescription = "Dino",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column(modifier = Modifier
            .padding(6.dp)
            .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally){
            Text(text = "Train App", style = MaterialTheme.typography.h2)
            Spacer(modifier = Modifier.padding(20.dp))
            TrainButton(text = "To Home", onClick = {
                navController.navigate(route = Screens.WebScreen.name+"/${nowDate.time}/TO_HOME")
            })
            Spacer(modifier = Modifier.padding(10.dp))
            TrainButton(text = "To Work", onClick = {
//            val time2 = LocalDateTime.now()
                navController.navigate(route = Screens.WebScreen.name+"/${nowDate.time}/TO_WORK")
            })
        }
    }
}