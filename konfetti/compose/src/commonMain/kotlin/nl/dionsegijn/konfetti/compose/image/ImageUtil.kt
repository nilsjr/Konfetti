package nl.dionsegijn.konfetti.compose.image

import androidx.compose.ui.graphics.painter.Painter
import nl.dionsegijn.konfetti.core.models.Shape

object ImageUtil {
    @JvmStatic
    fun loadDrawable(
        drawable: Painter,
        tint: Boolean = true,
        applyAlpha: Boolean = true,
    ): Shape.DrawableShape {
        val width = drawable.intrinsicSize.width.toInt()
        val height = drawable.intrinsicSize.height.toInt()
        val drawableImage = DrawableImage(drawable, width, height)
        return Shape.DrawableShape(drawableImage, tint, applyAlpha)
    }
}
