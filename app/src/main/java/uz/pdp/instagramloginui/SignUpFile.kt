package uz.pdp.instagramloginui

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

val orColor = Color(0xFF8C8C8C)

@Composable
fun GoSignUp(navController: NavController) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 12.dp, start = 12.dp, end = 12.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            "Don't have an account?",
            color = orColor,
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            "Sign up.",
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .clickable(onClick = {
                    navController.navigate(Screen.DetailScreen.route)
                }),
            color = Color.Black,
            fontSize = 16.sp
        )
    }
}

@Composable
fun InstagramLogo() {
    Image(
        imageVector = ImageVector.vectorResource(id = R.drawable.ic_instagram_logo), "",
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 150.dp),
    )
    Spacer(modifier = Modifier.height(30.dp))
}

@Composable
fun RoundImage() {
    Image(
        painter = painterResource(id = R.drawable.img), "",
        modifier = Modifier
            .height(90.dp)
            .width(90.dp)
            .clip(shape = RoundedCornerShape(45.dp)),
        contentScale = ContentScale.Crop
    )
    Spacer(modifier = Modifier.height(10.dp))
}

@Composable
fun UserName() {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        Text(
            "Yashnarbek_Melikov",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            fontSize = 14.sp
        )
    }
    Spacer(modifier = Modifier.height(15.dp))
}

@Composable
fun LogInButtonDark() {

    val context = LocalContext.current
    val blueColor = Color(0xFF3797EF)
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, top = 8.dp, end = 20.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Button(modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = blueColor),
            onClick = { Toast.makeText(context, "Log in", Toast.LENGTH_SHORT).show() }) {
            Text(text = "Log in", color = Color.White)
        }
    }
    Spacer(modifier = Modifier.height(30.dp))
}

@Composable
fun SwitchAccount(text: String) {
    val blueColor = Color(0xFF3797EF)
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
    ) {
        Text(
            text,
            fontWeight = FontWeight.Bold,
            color = blueColor,
            fontSize = 15.sp
        )
    }

    Spacer(modifier = Modifier.height(260.dp))
}