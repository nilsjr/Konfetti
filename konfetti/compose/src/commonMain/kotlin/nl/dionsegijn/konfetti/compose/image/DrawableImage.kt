package nl.dionsegijn.konfetti.compose.image

import androidx.compose.ui.graphics.painter.Painter
import nl.dionsegijn.konfetti.core.models.CoreImage

data class DrawableImage(
    val drawable: Painter,
    override val width: Int,
    override val height: Int,
) : CoreImage
