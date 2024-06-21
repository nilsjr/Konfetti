package nl.dionsegijn.konfetti.compose

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.graphics.withSave
import nl.dionsegijn.konfetti.compose.image.ImageStore
import nl.dionsegijn.konfetti.core.Particle
import nl.dionsegijn.konfetti.core.models.ReferenceImage
import nl.dionsegijn.konfetti.core.models.Shape
import nl.dionsegijn.konfetti.core.models.Shape.Circle
import nl.dionsegijn.konfetti.core.models.Shape.Rectangle
import nl.dionsegijn.konfetti.core.models.Shape.Square

/**
 * Draw a shape to `compose canvas`. Implementations are expected to draw within a square of size
 * `size` and must vertically/horizontally center their asset if it does not have an equal width
 * and height.
 */
fun Shape.draw(
    drawScope: DrawScope,
    particle: Particle,
    imageStore: ImageStore,
) {
    when (this) {
        Circle -> {
            val offsetMiddle = particle.width / 2
            drawScope.drawCircle(
                color = Color(particle.color),
                center = Offset(particle.x + offsetMiddle, particle.y + offsetMiddle),
                radius = particle.width / 2,
            )
        }

        Square -> {
            drawScope.drawRect(
                color = Color(particle.color),
                topLeft = Offset(particle.x, particle.y),
                size = Size(particle.width, particle.height),
            )
        }

        is Rectangle -> {
            val size = particle.width
            val height = size * heightRatio
            drawScope.drawRect(
                color = Color(particle.color),
                topLeft = Offset(particle.x, particle.y),
                size = Size(size, height),
            )
        }

        is Shape.DrawableShape -> {
            val referenceImage = image
            if (referenceImage is ReferenceImage) {
                val image = imageStore.getImage(referenceImage.reference) ?: return

                drawScope.drawIntoCanvas {
                    it.withSave {
                        val size = particle.width
                        val height = (size * heightRatio).toInt()
                        val top = ((size - height) / 2f).toInt()

                        val x = particle.y
                        val y = particle.x

                        with(image) {
                            drawScope.translate(left = y, top = top + x) {
                                draw(
                                    size = Size(size, size),
                                    colorFilter = ColorFilter.tint(Color(particle.color)),
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
