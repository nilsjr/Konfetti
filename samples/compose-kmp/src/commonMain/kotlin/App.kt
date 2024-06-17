import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import konfetti.samples.compose_kmp.generated.resources.Res
import konfetti.samples.compose_kmp.generated.resources.ic_heart
import nl.dionsegijn.kmp.compose.KonfettiViewModel
import nl.dionsegijn.konfetti.compose.KonfettiView
import nl.dionsegijn.konfetti.compose.OnParticleSystemUpdateListener
import nl.dionsegijn.konfetti.compose.image.ImageUtil
import nl.dionsegijn.konfetti.core.PartySystem
import org.jetbrains.compose.resources.painterResource

@Composable
fun App() {
    val viewModel = remember { KonfettiViewModel() }
    val state by viewModel.state.collectAsState()

    val painter = painterResource(Res.drawable.ic_heart)

    Surface {
        Box {
            when (val newState = state) {
                KonfettiViewModel.State.Idle -> {
                    Column(
                        modifier =
                        Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Button(onClick = { viewModel.festive(ImageUtil.loadDrawable(painter)) }) {
                            Text(text = "Festive")
                        }
                        Button(onClick = { viewModel.explode() }) {
                            Text(text = "Explode")
                        }
                        Button(onClick = { viewModel.parade() }) {
                            Text(text = "Parade")
                        }
                        Button(onClick = { viewModel.rain() }) {
                            Text(text = "Rain")
                        }
                    }
                }

                is KonfettiViewModel.State.Started -> {
                    KonfettiView(
                        modifier = Modifier.fillMaxSize(),
                        parties = newState.party,
                        updateListener =
                        object : OnParticleSystemUpdateListener {
                            override fun onParticleSystemEnded(
                                system: PartySystem,
                                activeSystems: Int,
                            ) {
                                if (activeSystems == 0) viewModel.ended()
                            }
                        },
                    )
                }
            }
        }
    }
}