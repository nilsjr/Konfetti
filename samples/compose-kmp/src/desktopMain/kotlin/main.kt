import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import nl.dionsegijn.konfetti.compose.KonfettiView
import nl.dionsegijn.konfetti.compose.OnParticleSystemUpdateListener
import nl.dionsegijn.konfetti.core.PartyFactory
import nl.dionsegijn.konfetti.core.PartySystem
import nl.dionsegijn.samples.shared.Presets

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "cheetah") {
        App()
    }
}

@Composable
fun App() {
    KonfettiView(
        modifier = Modifier.fillMaxSize(),
        parties = Presets.explode(),
        updateListener =
        object : OnParticleSystemUpdateListener {
            override fun onParticleSystemEnded(
                system: PartySystem,
                activeSystems: Int,
            ) {
//                if (activeSystems == 0) viewModel.ended()
            }
        },
    )
}