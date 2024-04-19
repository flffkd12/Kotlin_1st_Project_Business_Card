package com.example.practice

import android.annotation.SuppressLint
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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.key.Key.Companion.D
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
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
                    color = Color.White
                ) {
                    ArtSpaceApp()
                }
            }
        }
    }
}

@Composable
fun Screen(
    text: String,
    contentDescription: String,
    author: String,
    image: Painter,
    onPreviousClick: () -> Unit,
    onNextClick: () -> Unit,
    modifier: Modifier
) {
    Column (
        modifier = modifier
            .fillMaxWidth()
            .padding(40.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
    ) {
        Image(
            painter = image,
            contentDescription = contentDescription,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(440.dp)
        )
        Spacer(modifier = modifier.size(16.dp))

        Box(
            modifier = modifier
                .fillMaxWidth()
                .background(color = Color.LightGray)
                .padding(16.dp)
        ) {
            Column(
                modifier = modifier.height(100.dp)
            ) {
                Text(
                    text = text,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    fontSize = 24.sp,
                )
                Spacer(modifier = modifier.height(4.dp))
                Text(
                    text = author,
                    fontWeight = FontWeight.Medium,
                    color = Color.Gray,
                    fontSize = 16.sp,
                )
            }
        }
        Row (
            horizontalArrangement = Arrangement.spacedBy(80.dp,Alignment.CenterHorizontally),
            modifier=modifier.fillMaxWidth()
        ){
            Button(
                onClick = onPreviousClick,
                modifier = Modifier
                    .width(120.dp)
                    .height(40.dp)
            ) {
                Text(text = "Previous")
            }
            Button(
                onClick = onNextClick,
                modifier = Modifier
                    .width(120.dp)
                    .height(40.dp)
            ) {
                Text(text = "Next")
            }
        }
    }
}
@Composable
fun ArtSpaceView(modifier: Modifier = Modifier) {
    var screenNum by remember { mutableIntStateOf(1) }

    when(screenNum){
        1 -> {
            Screen(
                text = stringResource(id = R.string.Maple1_text),
                contentDescription = stringResource(id = R.string.Maple1_content_description),
                author = stringResource(id = R.string.Maple1_author),
                image = painterResource(id = R.drawable.maple1),
                onPreviousClick = { screenNum = 3 },
                onNextClick = { screenNum = 2},
                modifier = modifier
            )
        }
        2-> {
            Screen(
                text = stringResource(id = R.string.Maple2_text),
                contentDescription = stringResource(id = R.string.Maple2_content_description),
                author = stringResource(id = R.string.Maple2_author),
                image = painterResource(id = R.drawable.maple2),
                onPreviousClick = { screenNum = 1 },
                onNextClick = { screenNum = 3},
                modifier = modifier
            )
        }
        3-> {
            Screen(
                text = stringResource(id = R.string.Maple3_text),
                contentDescription = stringResource(id = R.string.Maple3_content_description),
                author = stringResource(id = R.string.Maple3_author),
                image = painterResource(id = R.drawable.maple3),
                onPreviousClick = { screenNum = 2 },
                onNextClick = { screenNum = 1},
                modifier = modifier
            )
        }
        else -> {}
    }
}



@Preview(showBackground = false)
@Composable
fun ArtSpaceApp() {
    PracticeTheme {
        ArtSpaceView()
    }
}