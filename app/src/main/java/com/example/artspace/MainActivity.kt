package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    artApp()
                }
            }
        }
    }
}


@Composable
fun artApp(){
    var currentStep by remember { mutableStateOf(1) }
    when (currentStep) {
        1 -> {
            ArtAppWithArgs("Android",
              imageIdRes = R.drawable.alien_poster,
                tittleIdRes = R.string.alien_tittle,
                artistIdRes = R.string.alien_artist,
                yearIdRes = R.string.alien_year)
        }

    }
}
@Composable
fun ArtAppWithArgs(name: String, modifier: Modifier = Modifier
,imageIdRes  : Int = 0, tittleIdRes : Int = 0, artistIdRes : Int = 0,yearIdRes : Int = 0) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )

    Box(

    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        )
        {
            Image(painter = painterResource(id = imageIdRes ) , contentDescription ="" )
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = stringResource(id = tittleIdRes))
            Spacer(modifier = Modifier.height(20.dp))
            Row {
                Text(text = stringResource(id = artistIdRes))
                Spacer(modifier = Modifier.width(11.dp))
                Text(text = stringResource(id = yearIdRes))
            }

            Spacer(modifier = Modifier.height(40.dp))
            Row(){
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Previous")
                }
                Spacer(modifier = Modifier.width(25.dp))
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Next")
                }
            }
        
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        artApp()
    }
}