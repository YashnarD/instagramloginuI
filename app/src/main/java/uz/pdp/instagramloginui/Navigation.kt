package uz.pdp.instagramloginui

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
        composable(route = Screen.MainScreen.route) {
            MainScreen(navController = navController)
        }
        composable(route = Screen.DetailScreen.route) {
            DetailScreen(navController = navController)
        }
    }
}

@Composable
fun MainScreen(navController: NavController) {

    val orColor = Color(0xFF8C8C8C)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
    ) {


        InstagramLogo()

        RoundImage()

        UserName()

        LogInButtonDark()
        
        SwitchAccount(text = "Switch accounts")

        Line()

        GoSignUp(navController = navController)
    }

}

@Composable
fun DetailScreen(navController: NavController) {

    Column(modifier = Modifier.fillMaxSize()) {
        Image(imageVector = ImageVector.vectorResource(id = R.drawable.ic_shape__4_), "",
            modifier = Modifier
                .height(40.dp)
                .width(40.dp)
                .padding(start = 20.dp, top = 20.dp)
                .clickable {
                    navController.popBackStack()
                }
        )

        Image(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_instagram_logo), "",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 80.dp),
        )
        Spacer(modifier = Modifier.height(20.dp))
        EditText(
            hint = "Username",
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )
        Spacer(modifier = Modifier.height(8.dp))
        EditText(
            hint = "Password",
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

        TextForgotPassword(text = "Forgot password?")

        LogInButton()

        ImageAndText()

        OrText()

        SignUp()

        Line()

        InstagramFromFacebook()
    }

}


