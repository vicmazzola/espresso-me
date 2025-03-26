package com.example.espressome

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout

@Preview
@Composable
fun Dashboard() {

    //ENABLE SCROLL
    val scrollState = rememberScrollState()

    Column(
        Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(color = Color(android.graphics.Color.parseColor("#FFFFFF")))
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ConstraintLayout {
            val (topImg, profile2) = createRefs()

            Box(
                Modifier
                    .fillMaxWidth()
                    .height(245.dp)
                    .constrainAs(topImg) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                    }
                    .background(
                        color = Color(android.graphics.Color.parseColor("#000000")),
                        shape = RoundedCornerShape(bottomEnd = 40.dp, bottomStart = 40.dp)
                    )
            )

            Row(
                modifier = Modifier
                    .padding(top = 30.dp, start = 24.dp, end = 24.dp)
                    .fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .height(100.dp)
                        .padding(start = 14.dp)
                        .weight(0.7f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "Let's have a",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                    )

                    Text(
                        text = "Coffee?",
                        color = Color.White,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 14.dp)
                    )
                }

                Image(
                    painter = painterResource(id = R.drawable.cafe01),
                    contentDescription = null,
                    modifier = Modifier
                        .size(200.dp)
                        .clickable { }
                )
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp, start = 24.dp, end = 24.dp)
                    .shadow(3.dp, shape = RoundedCornerShape(20.dp))
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(20.dp)
                    )
                    .constrainAs(profile2) {
                        top.linkTo(topImg.bottom)
                        bottom.linkTo(topImg.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                    }
            ) {}
        }

        var text by rememberSaveable { mutableStateOf("") }

        TextField(
            value = text,
            onValueChange = { text = it },
            label = { Text(text = "Searching for....") },
            trailingIcon = {
                Image(
                    painter = painterResource(id = R.drawable.search_icon),
                    contentDescription = null,
                    modifier = Modifier
                        .size(43.dp)
                        .padding(end = 6.dp)
                )
            },
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                backgroundColor = Color.White,
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
                textColor = Color(android.graphics.Color.parseColor("#5e5e5e")),
                unfocusedLabelColor = Color(android.graphics.Color.parseColor("#5e5e5e"))
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp, end = 24.dp, start = 24.dp)
                .shadow(3.dp, shape = RoundedCornerShape(50.dp))
                .background(Color.White, CircleShape)
        )

        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp, end = 24.dp, start = 24.dp)
                .shadow(3.dp, shape = RoundedCornerShape(25.dp))
                .height(100.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color(android.graphics.Color.parseColor("#000000")),
                            Color(android.graphics.Color.parseColor("#B6C2FE"))
                        )
                    ), shape = RoundedCornerShape(25.dp)
                )
        ) {
            val (img, text1) = createRefs()

            Image(
                modifier = Modifier
                    .constrainAs(img) {
                        top.linkTo(parent.top)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                    }
                    .size(130.dp),
                painter = painterResource(id = R.drawable.cafe04),
                contentDescription = ""
            )

            Text(
                text = "Cappuccino",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier
                    .padding(top = 32.dp)
                    .constrainAs(text1) {
                        top.linkTo(parent.top)
                        end.linkTo(img.start)
                        start.linkTo(parent.start)
                    }
            )
        }

        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp, end = 24.dp, start = 24.dp)
                .shadow(3.dp, shape = RoundedCornerShape(25.dp))
                .height(100.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color(android.graphics.Color.parseColor("#000000")),
                            Color(android.graphics.Color.parseColor("#B6C2FE"))
                        )
                    ), shape = RoundedCornerShape(25.dp)
                )
        ) {
            val (img, text1) = createRefs()

            Image(
                modifier = Modifier
                    .constrainAs(img) {
                        top.linkTo(parent.top)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                    }
                    .size(130.dp),
                painter = painterResource(id = R.drawable.cafe05),
                contentDescription = ""
            )

            Text(
                text = "Milk Tea",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier
                    .padding(top = 32.dp)
                    .constrainAs(text1) {
                        top.linkTo(parent.top)
                        end.linkTo(img.start)
                        start.linkTo(parent.start)
                    }
            )
        }

        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp, end = 24.dp, start = 24.dp)
                .shadow(3.dp, shape = RoundedCornerShape(25.dp))
                .height(100.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color(android.graphics.Color.parseColor("#000000")),
                            Color(android.graphics.Color.parseColor("#B6C2FE"))
                        )
                    ), shape = RoundedCornerShape(25.dp)
                )
        ) {
            val (img, text1) = createRefs()

            Image(
                modifier = Modifier
                    .constrainAs(img) {
                        top.linkTo(parent.top)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                    }
                    .size(100.dp),
                painter = painterResource(id = R.drawable.cafe07),
                contentDescription = ""
            )

            Text(
                text = "Tea with Coffee",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier
                    .padding(top = 32.dp)
                    .constrainAs(text1) {
                        top.linkTo(parent.top)
                        end.linkTo(img.start)
                        start.linkTo(parent.start)
                    }
            )
            Spacer(modifier = Modifier.height(16.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 24.dp)
            ) {
                Column(
                    modifier = Modifier.weight(0.25f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.cafe07),
                        contentDescription = null,
                        modifier = Modifier
                            .size(100.dp)
                            .padding(top = 8.dp, bottom = 4.dp)
                            .background(
                                color = Color(android.graphics.Color.parseColor("#EEEEFB")),
                                shape = RoundedCornerShape(10.dp)
                            )
                            .padding(16.dp),
                    )
                    Text(
                        text = "Americano",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 8.dp),
                        color = Color(android.graphics.Color.parseColor("#140100"))
                    )
                }

                Column(
                    modifier = Modifier.weight(0.25f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.cafe08),
                        contentDescription = null,
                        modifier = Modifier
                            .size(100.dp)
                            .padding(top = 8.dp, bottom = 4.dp)
                            .background(
                                color = Color(android.graphics.Color.parseColor("#EEEEFB")),
                                shape = RoundedCornerShape(10.dp)
                            )
                            .padding(16.dp),
                    )
                    Text(
                        text = "Milk",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 8.dp),
                        color = Color(android.graphics.Color.parseColor("#140100"))
                    )
                }

                Column(
                    modifier = Modifier.weight(0.25f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.cafe09),
                        contentDescription = null,
                        modifier = Modifier
                            .size(100.dp)
                            .padding(top = 8.dp, bottom = 4.dp)
                            .background(
                                color = Color(android.graphics.Color.parseColor("#EEEEFB")),
                                shape = RoundedCornerShape(10.dp)
                            )
                            .padding(16.dp),
                    )
                    Text(
                        text = "Cortado",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 8.dp),
                        color = Color(android.graphics.Color.parseColor("#140100"))
                    )
                }

                Column(
                    modifier = Modifier.weight(0.25f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.cafe10),
                        contentDescription = null,
                        modifier = Modifier
                            .size(100.dp)
                            .padding(top = 8.dp, bottom = 4.dp)
                            .background(
                                color = Color(android.graphics.Color.parseColor("#EEEEFB")),
                                shape = RoundedCornerShape(10.dp)
                            )
                            .padding(16.dp),
                    )
                    Text(
                        text = "Macchiato",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 8.dp),
                        color = Color(android.graphics.Color.parseColor("#140100"))
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 12.dp)
        ) {
            Column(
                modifier = Modifier.weight(0.25f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.cafe11),
                    contentDescription = null,
                    modifier = Modifier
                        .size(100.dp)
                        .padding(top = 8.dp, bottom = 4.dp)
                        .background(
                            color = Color(android.graphics.Color.parseColor("#EEEEFB")),
                            shape = RoundedCornerShape(10.dp)
                        )
                        .padding(16.dp),
                )
                Text(
                    text = "Frappé",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp),
                    color = Color(android.graphics.Color.parseColor("#140100"))
                )
            }

            Column(
                modifier = Modifier.weight(0.25f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.cafe12),
                    contentDescription = null,
                    modifier = Modifier
                        .size(100.dp)
                        .padding(top = 8.dp, bottom = 4.dp)
                        .background(
                            color = Color(android.graphics.Color.parseColor("#EEEEFB")),
                            shape = RoundedCornerShape(10.dp)
                        )
                        .padding(16.dp),
                )
                Text(
                    text = "Dalgona",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp),
                    color = Color(android.graphics.Color.parseColor("#140100"))
                )
            }

            Column(
                modifier = Modifier.weight(0.25f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.cafe13),
                    contentDescription = null,
                    modifier = Modifier
                        .size(100.dp)
                        .padding(top = 8.dp, bottom = 4.dp)
                        .background(
                            color = Color(android.graphics.Color.parseColor("#EEEEFB")),
                            shape = RoundedCornerShape(10.dp)
                        )
                        .padding(16.dp),
                )
                Text(
                    text = "Panna",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp),
                    color = Color(android.graphics.Color.parseColor("#140100"))
                )
            }

            Column(
                modifier = Modifier.weight(0.25f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.cafe14),
                    contentDescription = null,
                    modifier = Modifier
                        .size(100.dp)
                        .padding(top = 8.dp, bottom = 4.dp)
                        .background(
                            color = Color(android.graphics.Color.parseColor("#EEEEFB")),
                            shape = RoundedCornerShape(10.dp)
                        )
                        .padding(16.dp),
                )
                Text(
                    text = "Pingado",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp),
                    color = Color(android.graphics.Color.parseColor("#140100"))
                )
            }
        }
    }
}


