package com.example.espressome

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Preview
@Composable
fun DefaultPreview() {
    Intro(navController = rememberNavController())
}

@Composable
fun Intro(navController: NavController) {

    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (logo, button) = createRefs()

        Image(
            painter = painterResource(id = R.drawable.coffee),
            contentDescription = "null",
            modifier = Modifier
                .fillMaxSize()
                .constrainAs(logo) {
                    centerTo(parent)
                }
        )
        Button(
            onClick = {
                Log.d("Intro", "Image 'intro' clicked")
                navController.navigate("mainActivityHome")
            },
            modifier = Modifier
                .constrainAs(button) {
                    bottom.linkTo(parent.bottom, margin = 62.dp)
                    start.linkTo(parent.start, margin = 82.dp)
                    end.linkTo(parent.end, margin = 82.dp)
                }
                .height(60.dp),

            shape = RoundedCornerShape(14.dp),
            colors = ButtonDefaults.buttonColors(Color.White)
        ) {
            Text(
                text = "ACCESS NOW!",
                color = Color.Black,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                )
            )
        }
    }
}
