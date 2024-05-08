package com.example.helloworld

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun WeeklyHWSeven() {
    Column(
        modifier = Modifier
            .background(Color.Black)
            .fillMaxHeight()
    ) {
        Box(
            modifier = Modifier.aspectRatio(1.5f)
        ) {
            Image(
                painter = painterResource(id = R.drawable.image_2),
                contentDescription = "Image 2",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Row(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(start = 20.dp, bottom = 20.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.pin),
                    contentDescription = "Pin icon",
                    modifier = Modifier.size(23.dp)
                )
                Text(
                    text = "Bangkok",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(start = 10.dp)
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp)
                .padding(top = 25.dp, bottom = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.profile_image),
                    contentDescription = "profile image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                )
                Text(
                    text = "Biel Morro",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.download),
                    contentDescription = "download icon",
                    modifier = Modifier.size(30.dp)
                )
                Spacer(modifier = Modifier.width(16.dp)) // Add space between icons
                Image(
                    painter = painterResource(id = R.drawable.heart),
                    contentDescription = "heart icon",
                    modifier = Modifier.size(30.dp)
                )
                Spacer(modifier = Modifier.width(16.dp)) // Add space between icons
                Image(
                    painter = painterResource(id = R.drawable.bookmark),
                    contentDescription = "bookmark icon",
                    modifier = Modifier.size(30.dp)
                )
            }
        }
        Divider(
            color = Color.DarkGray,
            thickness = 1.dp,
            modifier = Modifier.padding(horizontal = 20.dp)
        )
        Row() {

        }
        Details()
        Divider(
            color = Color.DarkGray,
            thickness = 1.dp,
            modifier = Modifier.padding(horizontal = 20.dp).padding(top = 20.dp)
        )
        Stats()
        Divider(
            color = Color.DarkGray,
            thickness = 1.dp,
            modifier = Modifier.padding(horizontal = 20.dp)
        )
        Row(
            modifier = Modifier.fillMaxWidth().padding(start = 20.dp),
            horizontalArrangement = Arrangement.Start
        ) {
            Button(
                onClick = { /* Handle Barcelona button click */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray),
                shape = RoundedCornerShape(percent = 50),
                modifier = Modifier.padding(vertical = 8.dp).padding(end = 10.dp)
            ) {
                Text(
                    text = "barcelona",
                    color = Color.White
                )
            }

            Button(
                onClick = { /* Handle Spain button click */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray),
                shape = RoundedCornerShape(percent = 50),
                modifier = Modifier.padding(vertical = 8.dp)
            ) {
                Text(
                    text = "spain",
                    color = Color.White
                )
            }
        }
    }
}


@Composable
fun MainTitleSubtitleItem(title: String, subtitle: String) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            text = title,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
        Text(
            text = subtitle,
            color = Color.White,
            fontSize = 14.sp
        )
    }
}


@Composable
fun Details() {
    val items = listOf(
        "Camera" to "NIKON D320",
        "Focal Length" to "18.0mm",
        "ISO" to "100",
        "Aperture" to "f/5.0",
        "Shutter Speed" to "1/125s",
        "Dimensions" to "3906x4882"
    )

    val firstList = items.subList(0, 3)
    val secondList = items.subList(3, items.size)

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Box(
            modifier = Modifier.weight(1f)
        ) {
            LazyColumn {
                items(firstList.size) { index ->
                    MainTitleSubtitleItem(title = firstList[index].first, subtitle = firstList[index].second)
                }
            }
        }

        Box(
            modifier = Modifier.weight(1f)
        ) {
            LazyColumn(
                horizontalAlignment = Alignment.End
            ) {
                items(secondList.size) { index ->
                    MainTitleSubtitleItem(title = secondList[index].first, subtitle = secondList[index].second)
                }
            }
        }
    }
}

@Composable
fun Stats() {
    val items = listOf(
        "Views" to "8.8m",
        "Downloads" to "99.1K",
        "Likes" to "1.8K",
    )

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        items.forEach { (title, subtitle) ->
            MainTitleSubtitleItem(title = title, subtitle = subtitle)
        }
    }
}