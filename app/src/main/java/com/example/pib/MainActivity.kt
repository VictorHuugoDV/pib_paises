package com.example.pib

import android.os.Bundle
import android.service.notification.NotificationListenerService.Ranking
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pib.ui.theme.PIBTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PIBTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DadosPib()
                }
            }
        }
    }
}

@Composable
fun DadosPib() {
    var paisAtual by remember {
        mutableStateOf(1)
    }
    when (paisAtual) {
        1 ->
            Paises(
                bandeira = R.drawable.estados_unidos,
                nomePais = R.string.primeiro_pais,
                pib = R.string.pib_usa,
                paisAnterior = { paisAtual = 1 },
                proximoPais = { paisAtual = 2 },
                ranking = R.string.ranking1
            )

        2 -> Paises(
            bandeira = R.drawable.china,
            nomePais = R.string.segundo_pais,
            pib = R.string.pib_china,
            paisAnterior = { paisAtual = 1 },
            proximoPais = { paisAtual = 3 },
            ranking = R.string.ranking2
        )

        3 -> Paises(
            bandeira = R.drawable.bandeira_do_japao,
            nomePais = R.string.terceiro_pais,
            pib = R.string.pib_japao,
            paisAnterior = { paisAtual = 2 },
            proximoPais = { paisAtual = 4 },
            ranking = R.string.ranking3
        )

        4 -> Paises(
            bandeira = R.drawable.bandeira_da_alemanha,
            nomePais = R.string.quanto_pais,
            pib = R.string.pib_alemanha,
            paisAnterior = { paisAtual = 3 },
            proximoPais = { paisAtual = 5 },
            ranking = R.string.ranking4
        )

        5 -> Paises(
            bandeira = R.drawable.india,
            nomePais = R.string.quinto_pais,
            pib = R.string.pib_india,
            paisAnterior = { paisAtual = 4 },
            proximoPais = { paisAtual = 6 },
            ranking = R.string.ranking5
        )

        6 -> Paises(
            bandeira = R.drawable.bandeira_do_reino_unido,
            nomePais = R.string.sexto_pais,
            pib = R.string.pib_reinounido,
            paisAnterior = { paisAtual = 5 },
            proximoPais = { paisAtual = 7 },
            ranking = R.string.ranking6
        )

        7 -> Paises(
            bandeira = R.drawable.franca,
            nomePais = R.string.setimo_pais,
            pib = R.string.pib_franca,
            paisAnterior = { paisAtual = 6 },
            proximoPais = { paisAtual = 8 },
            ranking = R.string.ranking7
        )

        8 -> Paises(
            bandeira = R.drawable.canada,
            nomePais = R.string.oitavo_pais,
            pib = R.string.pib_canda,
            paisAnterior = { paisAtual = 7 },
            proximoPais = { paisAtual = 9 },
            ranking = R.string.ranking8
        )

        9 -> Paises(
            bandeira = R.drawable.bandeira_russia,
            nomePais = R.string.nono_pais,
            pib = R.string.pib_russia,
            paisAnterior = { paisAtual = 9 },
            proximoPais = { paisAtual = 10 },
            ranking = R.string.ranking9
        )

        10 -> Paises(
            bandeira = R.drawable.bandeira_italia_0_cke,
            nomePais = R.string.decimo_pais,
            pib = R.string.pib_italia,
            paisAnterior = { paisAtual = 9 },
            proximoPais = { paisAtual = 1 },
            ranking = R.string.ranking10
        )
    }
}
@Composable
fun Paises(
    bandeira: Int,
    nomePais: Int,
    pib: Int,
    ranking: Int,
    proximoPais: () -> Unit,
    paisAnterior: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
    ) {

        Text(
            text = stringResource(id = R.string.pib_paises), fontSize = 30.sp,
            modifier = Modifier
                .padding(bottom = 100.dp)

        )
        Text(text = stringResource(id = ranking), fontSize = 20.sp)
        Image(
            painter = painterResource(id = bandeira), contentDescription = null, modifier = Modifier
                .padding(25.dp)
        )
        Text(text = stringResource(id = nomePais), fontSize = 20.sp)
        Text(text = stringResource(id = pib))

        Spacer(modifier = Modifier.height(80.dp))

        Text(text = stringResource(id = R.string.ano_pesquisa), fontSize = 25.sp,
            //modifier = Modifier.padding(50.dp)
        )

        Spacer(modifier = Modifier.height(100.dp))

        Row() {
            Button(onClick = paisAnterior, Modifier.padding(25.dp)) {
                Text(text = stringResource(id = R.string.pais_anterior))
            }
            Button(onClick = proximoPais, Modifier.padding(25.dp)) {
                Text(text = stringResource(id = R.string.proximo_pais))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PIBTheme {
        DadosPib()
    }
}