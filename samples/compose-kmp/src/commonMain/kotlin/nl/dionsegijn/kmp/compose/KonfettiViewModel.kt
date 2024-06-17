package nl.dionsegijn.kmp.compose

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import nl.dionsegijn.konfetti.core.Party
import nl.dionsegijn.konfetti.core.models.Shape
import nl.dionsegijn.samples.shared.Presets

class KonfettiViewModel {

    private val _state = MutableStateFlow<State>(State.Idle)
    val state: StateFlow<State> = _state

    fun festive(drawable: Shape.DrawableShape) {
        /**
         * See [Presets] for this configuration
         */
        _state.value = State.Started(Presets.festive(drawable))
    }

    fun explode() {
        /**
         * See [Presets] for this configuration
         */
        _state.value = State.Started(Presets.explode())
    }

    fun parade() {
        /**
         * See [Presets] for this configuration
         */
        _state.value = State.Started(Presets.parade())
    }

    fun rain() {
        /**
         * See [Presets] for this configuration
         */
        _state.value = State.Started(Presets.rain())
    }

    fun ended() {
        _state.value = State.Idle
    }

    sealed interface State {

        data class Started(val party: List<Party>) : State

        data object Idle : State
    }
}