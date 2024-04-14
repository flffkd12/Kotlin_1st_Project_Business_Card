package com.example.practice

import android.os.Bundle
import android.webkit.WebSettings.TextSize
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practice.ui.theme.PracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PracticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.LightGray
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun MyInformationBottom(
    imageVector: ImageVector,
    contentDescription : String,
    text:String
) {
    Row (verticalAlignment = Alignment.CenterVertically){
        Icon(imageVector = imageVector , contentDescription = contentDescription, tint = Color(0xFF3ddc84))
        Spacer(modifier = Modifier
            .width(24.dp)
            .padding(top = 16.dp, bottom = 16.dp))
        Text(text = text)
    }
}

@Composable
fun BusinessCard(
    modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.android_logo)
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxSize()
    ){
        Image(
            painter = image,
            contentDescription = "안드로이드 로고",
            contentScale = ContentScale.Crop,
            modifier = modifier.size(width =100.dp, height =100.dp)
        )
        Text(
            text = stringResource(id = R.string.my_name),
            fontSize = 40.sp,
            modifier = modifier.padding(bottom = 16.dp)
        )
        Text(
            text = stringResource(id = R.string.title),
            color = Color(0xFF3ddc84),
            fontWeight = FontWeight.Bold
        )
    }

    Column(
       horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom,
        modifier = modifier
            .fillMaxSize()
            .padding(bottom = 32.dp)
    ) {
        Column {
            MyInformationBottom(Icons.Filled.Phone, "전화번호", "(+82) 010-3397-8663")
            MyInformationBottom(Icons.Filled.Share, "공유", "@AndroidDev")
            MyInformationBottom(Icons.Filled.Email, "이메일", "flffkd12@gmail.com")
        }
    }
}

@Preview(showBackground = false)
@Composable
fun TaskPreview() {
    PracticeTheme {
        BusinessCard()
    }
}