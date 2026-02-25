package com.example.pedra_papel_tesoura

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pedra_papel_tesoura.ui.theme.PedrapapeltesouraTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PedrapapeltesouraTheme {
                NavigationApp()
            }
        }
    }
}

@Composable
fun NavigationApp() {
    val navController = rememberNavController()

    NavHost (
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            home(navController)
        }

        composable("game") {
            jogo(navController)
        }
    }
}

@Composable
fun home(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF7171B8)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "JOKENPÔ",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(50.dp))

        Button(onClick = { navController.navigate("game") }) {
            Text(text = "JOGAR")
        }
    }

}
@Composable
fun jogo(navController: NavHostController) {

    var jogador1 by remember {
        mutableStateOf(1)
    }

    var jogador2 by remember {
        mutableStateOf(1)
    }

    var resultado1 = when (jogador1) {

        1 -> R.drawable.pedra
        2 -> R.drawable.papel
        else -> {
            R.drawable.tesoura
        }
    }

    var resultado2 = when (jogador2) {

        1 -> R.drawable.pedra
        2 -> R.drawable.papel
        else -> {
            R.drawable.tesoura
        }
    }

    var pontuacao1 by remember {
        mutableStateOf(0)
    }

    var pontuacao2 by remember {
        mutableStateOf(0)
    }
    var ganhador by remember {
        mutableStateOf(0)
    }


    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xB2B7BCFA)
    ) {

        Column(
            modifier = Modifier.fillMaxSize(),
        ) {

            Surface(
                color = Color(0xFF7171B8),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(top = 45.dp, start = 20.dp, end = 20.dp)
                ) {
                    Text(
                        text = "JOKENPÔ",
                        fontSize = 35.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )

                    Image(
                        painter = painterResource(id = R.drawable.icons8_trof_u_48),
                        contentDescription = "Troféu da vitória",
                        modifier = Modifier.size(30.dp)
                    )
                }
            }


            Column(
                modifier = Modifier,
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Top,
                    modifier = Modifier
                        .width(322.dp)
                        .height(140.dp)
                        .padding(top = 40.dp)
                ) {

                    Column(
                        modifier = Modifier.height(100.dp),
                        verticalArrangement = Arrangement.SpaceBetween,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {


                        Text(
                            text = "Player 1",
                            fontWeight = FontWeight.Bold,
                            fontSize = 30.sp,

                        )

                        Box(
                            modifier = Modifier
                                .size(60.dp)
                                .padding(top = 20.dp)
                                .background(
                                    color = Color(0xFF7171B8)
                                ),
                            contentAlignment = Alignment.Center

                        ) {
                            Text(
                                text = "$pontuacao1",
                                fontSize = 25.sp,
                                fontWeight = FontWeight.Normal,
                            )
                        }

                    }
                    Text(
                        text = "vs",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 21.sp
                    )

                    Column(
                        modifier = Modifier.height(100.dp),
                        verticalArrangement = Arrangement.SpaceBetween,
                        horizontalAlignment = Alignment.CenterHorizontally

                    ) {

                        Text(
                            text = "Player 2",
                            fontWeight = FontWeight.Bold,
                            fontSize = 30.sp
                        )

                        Box(
                            modifier = Modifier
                                .size(60.dp)
                                .padding(top = 20.dp)
                                .background(
                                    color = Color(0xFF7171B8)
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "$pontuacao2",
                                fontSize = 25.sp,
                                fontWeight = FontWeight.Normal
                            )
                        }

                    }

                }

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .width(340.dp)
                        .height(350.dp)
                ) {

                    Image(
                        painterResource(id = resultado1),
                        contentDescription = "Movimento jogador 1",
                        modifier = Modifier.size(130.dp)
                    )

                    Image(
                        painterResource(id = resultado2),
                        contentDescription = "Movimento jogador 2",
                        modifier = Modifier.size(130.dp)
                    )

                }

                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .background(Color.White),
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {


                        if (ganhador == 0) {

                            Text(
                                text = "EMPATE!",
                                fontSize = 28.sp,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center,

                                )

                        } else if (ganhador == 1) {

                            Text(
                                text = "PLAYER 1 VENCEU!",
                                fontSize = 28.sp,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center,
                            )

                        } else {
                            Text(
                                text = "PLAYER 2 VENCEU!",
                                fontSize = 28.sp,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center,
                            )

                        }
                    }
                }
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                )

                Button(
                    border = BorderStroke(1.5.dp, Color.White),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF7171B8)
                    ),

                    shape = RectangleShape,
                    modifier = Modifier.shadow(12.dp),

                    onClick = {
                        jogador1 = (1..3).random()
                        jogador2 = (1..3).random()

                        if (jogador1 == 1 && jogador2 == 1) {
                            ganhador = 0
                        } else if (jogador1 == 2 && jogador2 == 2) {
                            ganhador = 0
                        } else if (jogador1 == 3 && jogador2 == 3) {
                            ganhador = 0 //fim dos empates

                        } else if (jogador1 == 1 && jogador2 == 2) {
                            ganhador = 2
                            pontuacao2++
                        } else if (jogador1 == 2 && jogador2 == 3) {
                            ganhador = 2
                            pontuacao2++
                        } else if (jogador1 == 3 && jogador2 == 1) {
                            ganhador = 2 // fim dos ganhos do jogador 2
                            pontuacao2++

                        } else if (jogador1 == 2 && jogador2 == 1) {
                            ganhador = 1
                            pontuacao1++
                        } else if (jogador1 == 3 && jogador2 == 2) {
                            ganhador = 1
                            pontuacao1++
                        } else if (jogador1 == 1 && jogador2 == 3) {
                            ganhador = 1 // fim dos ganhos do jogador 1
                            pontuacao1++
                        }


                    }) {

                    Text(
                        text = "SORTEAR",
                        fontSize = 30.sp
                    )


                }


            }
        }
    }
}