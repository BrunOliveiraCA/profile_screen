package com.example.profilescreen

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setContent {
            Profile()
        }

    }

    @Preview
    @Composable
    private fun Profile() {
        Column(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(color = Color(android.graphics.Color.parseColor("#F2F1F6"))),
            horizontalAlignment = Alignment.CenterHorizontally) {
            ConstraintLayout(
                Modifier
                    .height(250.dp)
                    .background(Color(android.graphics.Color.parseColor("#32357A")))) {
                    val (topImg, profile, title, back, pen) = createRefs()

                Image(painterResource(id = R.drawable.arc_3), null, Modifier
                    .fillMaxWidth()
                    .constrainAs(topImg) {
                        bottom.linkTo(parent.bottom)
                    }
                )

                Image(painterResource(id = R.drawable.user), null, Modifier
                    .constrainAs(profile) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(topImg.bottom)
                    }
                    .size(128.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colors.primary, CircleShape),
                    contentScale = ContentScale.Crop
                )

                Text(
                    text = "Profile",
                    style = TextStyle(color = Color.White, fontSize = 30.sp),
                    modifier = Modifier
                        .constrainAs(title) {
                            top.linkTo(parent.top, margin = 60.dp)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }
                )

                Image(painterResource(id = R.drawable.back), null, Modifier
                    .constrainAs(back) {
                        top.linkTo(parent.top, margin = 50.dp)
                        start.linkTo(parent.start, margin = 24.dp)
                    }
                )

                Image(painterResource(id = R.drawable.write), null, Modifier
                    .constrainAs(pen) {
                        top.linkTo(parent.top, margin = 48.dp)
                        start.linkTo(parent.start, margin = 340.dp)
                    }
                        .clickable {  }
                )
            }

            Text(
                text = "Bruno Oliveira",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top=16.dp),
                color = Color(android.graphics.Color.parseColor("#32357A"))
            )

            Text(
                text = "brunoliveira.ca@gmail.com",
                fontSize = 18.sp,
                color = Color(android.graphics.Color.parseColor("#747679"))
            )

            Row (modifier = Modifier
                .fillMaxWidth()
                .padding(start = 32.dp, end = 32.dp, top = 32.dp, bottom = 10.dp)
                .height(55.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Center) {
                    Image(painter = painterResource(id = R.drawable.btn_1), null, modifier = Modifier
                        .padding(end = 5.dp)
                        .clickable { } )
                }

                Column(modifier = Modifier
                    .padding(start = 16.dp)
                    .weight(1f)) {
                Text(text = "Notification",
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold)
                }

                Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Center) {
                    Image(painter = painterResource(id = R.drawable.arrow), null, Modifier
                        .padding(end = 5.dp)
                        .clickable {  } )
                }
            }

            Row (modifier = Modifier
                .fillMaxWidth()
                .padding(start = 32.dp, end = 32.dp, top = 10.dp, bottom = 10.dp)
                .height(55.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Center) {
                    Image(painter = painterResource(id = R.drawable.btn_2), null, modifier = Modifier
                        .padding(end = 5.dp)
                        .clickable { } )
                }

                Column(modifier = Modifier
                    .padding(start = 16.dp)
                    .weight(1f)) {
                    Text(text = "Calendar",
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold)
                }

                Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Center) {
                    Image(painter = painterResource(id = R.drawable.arrow), null, Modifier
                        .padding(end = 5.dp)
                        .clickable {  } )
                }
            }

            Row (modifier = Modifier
                .fillMaxWidth()
                .padding(start = 32.dp, end = 32.dp, top = 10.dp, bottom = 10.dp)
                .height(55.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Center) {
                    Image(painter = painterResource(id = R.drawable.btn_3), null, modifier = Modifier
                        .padding(end = 5.dp)
                        .clickable { } )
                }

                Column(modifier = Modifier
                    .padding(start = 16.dp)
                    .weight(1f)) {
                    Text(text = "Gallery",
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold)
                }

                Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Center) {
                    Image(painter = painterResource(id = R.drawable.arrow), null, Modifier
                        .padding(end = 5.dp)
                        .clickable {  } )
                }
            }

            Row (modifier = Modifier
                .fillMaxWidth()
                .padding(start = 32.dp, end = 32.dp, top = 10.dp, bottom = 10.dp)
                .height(55.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Center) {
                    Image(painter = painterResource(id = R.drawable.btn_4), null, modifier = Modifier
                        .padding(end = 5.dp)
                        .clickable { } )
                }

                Column(modifier = Modifier
                    .padding(start = 16.dp)
                    .weight(1f)) {
                    Text(text = "My Playlist",
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold)
                }

                Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Center) {
                    Image(painter = painterResource(id = R.drawable.arrow), null, Modifier
                        .padding(end = 5.dp)
                        .clickable {  } )
                }
            }

            Row (modifier = Modifier
                .fillMaxWidth()
                .padding(start = 32.dp, end = 32.dp, top = 10.dp, bottom = 10.dp)
                .height(55.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Center) {
                    Image(painter = painterResource(id = R.drawable.btn_5), null, modifier = Modifier
                        .padding(end = 5.dp)
                        .clickable { } )
                }

                Column(modifier = Modifier
                    .padding(start = 16.dp)
                    .weight(1f)) {
                    Text(text = "Share",
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold)
                }

                Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Center) {
                    Image(painter = painterResource(id = R.drawable.arrow), null, Modifier
                        .padding(end = 5.dp)
                        .clickable {  } )
                }
            }

            Row (modifier = Modifier
                .fillMaxWidth()
                .padding(start = 32.dp, end = 32.dp, top = 10.dp, bottom = 10.dp)
                .height(55.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Center) {
                    Image(painter = painterResource(id = R.drawable.btn_6), null, modifier = Modifier
                        .padding(end = 5.dp)
                        .clickable { } )
                }

                Column(modifier = Modifier
                    .padding(start = 16.dp)
                    .weight(1f)) {
                    Text(text = "Logout",
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold)
                }

                Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Center) {
                    Image(painter = painterResource(id = R.drawable.arrow), null, Modifier
                        .padding(end = 5.dp)
                        .clickable {  } )
                }
            }
        }
    }
}