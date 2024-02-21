package com.example.newapplicationjetpackcompose

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
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newapplicationjetpackcompose.ui.theme.Blue
import com.example.newapplicationjetpackcompose.ui.theme.Primary

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun PreviewCard() {
    MainCard(message = "Royhan")
}

@Composable
fun MainCard(message: String) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Blue
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Surface(
                modifier = Modifier
                    .height(150.dp)
                    .width(150.dp),
                color = Primary,
                shape = RoundedCornerShape(12.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.android_logo),
                    contentDescription = "image_logo",
                    modifier = Modifier.size(50.dp)
                )
            }
            Text(
                text = "Jennifier Doe",
                modifier = Modifier.padding(top = 20.dp),
                fontSize = 30.sp,
                color = Color.White
            )
            Text(
                text = "Android Developer Extraodinie",
                modifier = Modifier.padding(top = 20.dp),
                fontSize = 15.sp,
                color = Color.White
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 100.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(

                    imageVector = ImageVector.vectorResource(id = R.drawable.baseline_call_24),
                    contentDescription = "call",
                    modifier = Modifier.size(30.dp),
                    colorResource(id = R.color.white)
                )
                Spacer(modifier = Modifier.width(20.dp))
                Text(
                    text = "087765667855",
                    fontSize = 20.sp,
                    color = Color.White
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(

                    imageVector = ImageVector.vectorResource(id = R.drawable.baseline_share_24),
                    contentDescription = "call",
                    modifier = Modifier.size(30.dp),
                    colorResource(id = R.color.white)
                )
                Spacer(modifier = Modifier.width(20.dp))
                Text(
                    text = "@AndroidDev",
                    fontSize = 20.sp,
                    color = Color.White
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(

                    imageVector = ImageVector.vectorResource(id = R.drawable.baseline_email_24 ),
                    contentDescription = "call",
                    modifier = Modifier.size(30.dp),
                    colorResource(id = R.color.white)
                )
                Spacer(modifier = Modifier.width(20.dp))
                Text(
                    text = "jen.doe@android.com",
                    fontSize = 20.sp,
                    color = Color.White
                )
            }
        }
    }
}