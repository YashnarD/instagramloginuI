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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun EditText(hint: String, keyboardOptions: KeyboardOptions) {

    Column {
        var textState by remember { mutableStateOf("") }
        var passwordVisibility by remember { mutableStateOf(false) }
        val maxLength = 110
        val lightBlue = Color(0xFFFAFAFA)
        val grey = Color(0xFFC8C8C8)
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp, end = 12.dp),
            keyboardOptions = keyboardOptions,
            textStyle = TextStyle(
                fontSize = 17.sp
            ),
            value = textState,
            placeholder = { Text(text = hint, color = grey, fontSize = 17.sp) },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = lightBlue,
                cursorColor = Color.Black,
                disabledLabelColor = lightBlue,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            onValueChange = {
                if (it.length <= maxLength) textState = it
            },
            shape = RoundedCornerShape(5.dp),
            singleLine = true,
            visualTransformation = if (keyboardOptions.keyboardType == KeyboardType.Text) VisualTransformation.None
            else if (keyboardOptions.keyboardType == KeyboardType.Password && passwordVisibility) PasswordVisualTransformation()
            else VisualTransformation.None,
            trailingIcon = {
                val image = if (passwordVisibility)
                    R.drawable.ic_baseline_visibility_24
                else R.drawable.ic_baseline_visibility_off_24
                if (textState.isNotEmpty()) {

                    if (keyboardOptions.keyboardType == KeyboardType.Password) {
                        IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                            Icon(
                                imageVector = ImageVector.vectorResource(id = image),
                                contentDescription = null
                            )
                        }
                    } else if (keyboardOptions.keyboardType == KeyboardType.Text)
                        IconButton(onClick = { textState = "" }) {
                            Icon(
                                imageVector = Icons.Filled.Clear,
                                contentDescription = null
                            )
                        }
                }
            }
        )
    }
    Spacer(modifier = Modifier.height(10.dp))
}

@Composable
fun TextForgotPassword(text: String) {

    val context = LocalContext.current
    val blueColor = Color(0xFF3797EF)
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp, end = 16.dp),
        horizontalArrangement = Arrangement.End,
    ) {
        Text(
            text,
            modifier = Modifier
                .clickable(onClick = {
                    Toast
                        .makeText(context, "Really?", Toast.LENGTH_SHORT)
                        .show()
                }),
            color = blueColor,
            fontSize = 16.sp
        )
    }

    Spacer(modifier = Modifier.height(12.dp))

}

@Composable
fun LogInButton() {

    val context = LocalContext.current
    val lightBlueColor = Color(0xFF9BCBF7)
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 12.dp, top = 8.dp, end = 12.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Button(modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = lightBlueColor),
            onClick = { Toast.makeText(context, "Log in", Toast.LENGTH_SHORT).show() }) {
            Text(text = "Log in", color = Color.White)
        }
    }
    Spacer(modifier = Modifier.height(14.dp))
}

@Composable
fun ImageAndText() {

    val context = LocalContext.current
    val blueColor = Color(0xFF3797EF)
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 12.dp, start = 12.dp, end = 12.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_shape__5_), "",
            modifier = Modifier
                .height(20.dp)
                .width(20.dp)
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            "Log in with Facebook",
            modifier = Modifier
                .clickable(onClick = {
                    Toast
                        .makeText(context, "Really?", Toast.LENGTH_SHORT)
                        .show()
                }),
            color = blueColor,
            fontSize = 16.sp
        )
    }
    Spacer(modifier = Modifier.height(20.dp))
}

@Composable
fun OrText() {
    val orColor = Color(0xFF8C8C8C)
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 12.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Divider(
            color = orColor, thickness = 0.3.dp, modifier =
            Modifier
                .weight(1f)
                .padding(top = 10.dp, start = 10.dp)
        )
        Text(
            "OR",
            textAlign = TextAlign.Center,
            modifier = Modifier.weight(0.5f),
            color = orColor,
            fontSize = 16.sp
        )
        Divider(
            color = orColor, thickness = 0.3.dp, modifier =
            Modifier
                .weight(1f)
                .padding(top = 10.dp, end = 10.dp)
        )
    }
    Spacer(modifier = Modifier.height(20.dp))
}

@Composable
fun SignUp() {

    val context = LocalContext.current
    val blueColor = Color(0xFF3797EF)
    val orColor = Color(0xFF8C8C8C)
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 12.dp, start = 12.dp, end = 12.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            "Don't have an account?",
            modifier = Modifier
                .clickable(onClick = {
                    Toast
                        .makeText(context, "Really?", Toast.LENGTH_SHORT)
                        .show()
                }),
            color = orColor,
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            "Sign up.",
            modifier = Modifier
                .clickable(onClick = {
                    Toast
                        .makeText(context, "Really?", Toast.LENGTH_SHORT)
                        .show()
                }),
            color = blueColor,
            fontSize = 16.sp
        )
    }
    Spacer(modifier = Modifier.height(150.dp))
}

@Composable
fun Line() {
    val orColor = Color(0xFF8C8C8C)
    Divider(color = orColor, thickness = 0.3.dp)
    Spacer(modifier = Modifier.height(10.dp))
}

@Composable
fun InstagramFromFacebook() {
    val orColor = Color(0xFF8C8C8C)
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        Text(
            "Instagram from Facebook",
            color = orColor,
            modifier = Modifier.padding(top = 20.dp),
            fontSize = 12.sp
        )
    }
}