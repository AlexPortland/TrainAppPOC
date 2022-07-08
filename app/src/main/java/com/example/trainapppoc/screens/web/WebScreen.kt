package com.example.trainapppoc.screens.web

import android.content.res.loader.ResourcesLoader
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Place
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import com.example.trainapppoc.R
import com.example.trainapppoc.utils.trainUrlBuilder

@Composable
fun WebScreen(navController: NavController, time: Long?, direction: String?){
    val context = LocalContext.current
    Column(modifier = Modifier.padding(6.dp)) {
        Text(text = "hello")
    }
    Column(modifier = Modifier.padding(6.dp)) {
        TopAppBar(
            title = {
                Text(text = "TrainApp")
            },
            actions = {
                Icon(
                    imageVector = Icons.Rounded.Place,
                    contentDescription = "Icon"
                )
            },
            backgroundColor = Color(0xFFDADFE3)
        )
        //CircularProgressIndicator()
        AndroidView(factory = {
            WebView(context).apply {
                webViewClient = WebViewClient()
                settings.javaScriptEnabled = true
                loadUrl(trainUrlBuilder(time!!, direction))
            }
        })
    }
}