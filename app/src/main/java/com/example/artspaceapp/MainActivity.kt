package com.example.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspaceapp.data.ArtRepository
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    ArtSpaceApp(
                    )
                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp(modifier: Modifier = Modifier) {
    val artworks = ArtRepository.artworks

    var currentIndex by remember { mutableIntStateOf(0) }
    val currentArtwork = artworks[currentIndex]

    val goNext = {
        currentIndex = (currentIndex + 1).mod(artworks.size)
    }

    val goPrevious = {
        currentIndex = (currentIndex - 1).mod(artworks.size)
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(R.drawable.bg), contentScale = ContentScale.Crop
            )
            .padding(horizontal = 24.dp, vertical = 36.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 48.dp)
                .shadow(
                    elevation = 12.dp, shape = RoundedCornerShape(16.dp), clip = false
                )
                .background(Color.White, RoundedCornerShape(16.dp))
                .padding(28.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = currentArtwork.image),
                contentDescription = null,
                modifier = Modifier
                    .aspectRatio(3f / 4f)
                    .clip(RoundedCornerShape(6.dp))
                    .border(
                        width = 6.dp, color = Color.Black, shape = RoundedCornerShape(6.dp)
                    ),
                contentScale = ContentScale.Crop
            )
        }

        Spacer(modifier = Modifier.height(36.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFF2F2F6), RoundedCornerShape(12.dp))
                .padding(18.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = currentArtwork.title,
                fontSize = 22.sp,
                fontWeight = FontWeight.W600,
                color = Color.Black
            )

            Row {
                Text(
                    text = currentArtwork.author,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Text(
                    text = "  (${currentArtwork.year})", fontSize = 16.sp, color = Color.DarkGray
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 6.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(
                onClick = goPrevious,
                shape = RoundedCornerShape(50),
                modifier = Modifier.width(150.dp)
            ) {
                Text(stringResource(R.string.previous))
            }

            Button(
                onClick = goNext, shape = RoundedCornerShape(50), modifier = Modifier.width(150.dp)
            ) {
                Text(stringResource(R.string.next))
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceAppTheme {
        ArtSpaceApp()
    }
}