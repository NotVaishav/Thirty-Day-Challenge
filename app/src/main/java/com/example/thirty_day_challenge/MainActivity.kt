package com.example.thirty_day_challenge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.thirty_day_challenge.data.Wellness
import com.example.thirty_day_challenge.data.wellnessItems
import com.example.thirty_day_challenge.ui.theme.ThirtyDayChallengeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ThirtyDayChallengeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    WellnessList()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WellnessList(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Box() {
                        Text(
                            text = "30 Days Challenge",
                            style = MaterialTheme.typography.displaySmall
                        )
                    }
                },
                modifier = modifier.shadow(10.dp)
            )
        }
    ) { it ->
        LazyColumn(contentPadding = it) {
            items(wellnessItems) {
                WellnessCard(it)
            }
        }
    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WellnessCard(wellnessItem: Wellness, modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }
    Card(modifier = modifier.padding(8.dp), onClick = { expanded = !expanded }) {
        Column(
            modifier = modifier
                .padding(8.dp)
                .animateContentSize()
        ) {
            Text(
                text = "Day ${wellnessItem.day}",
                modifier = modifier,
                style = MaterialTheme.typography.bodyMedium,
            )
            Text(
                text = LocalContext.current.getString(wellnessItem.title),
                modifier = modifier,
                style = MaterialTheme.typography.bodyLarge,
            )
            Image(
                painter = painterResource(id = wellnessItem.imageResourceId),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .fillMaxWidth()
                    .height(220.dp)
                    .padding(vertical = 4.dp)
            )
            if (expanded) {
                Text(
                    text = LocalContext.current.getString(wellnessItem.content),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ThirtyDayChallengeTheme {
        WellnessList()
    }
}