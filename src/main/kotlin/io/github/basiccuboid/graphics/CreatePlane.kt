package io.github.basiccuboid.graphics

// @formatter:off
/**
 * <p>Wavefront OBJ file example</p>
 * # Blender v2.92.0 OBJ File: ''
 * # www.blender.org
 * o Plane
 * v 0.000000 0.000000 0.000000
 * v 1.000000 0.000000 0.000000
 * v 0.000000 1.000000 0.000000
 * v 1.000000 1.000000 0.000000
 * vt 1.000000 0.000000
 * vt 0.000000 1.000000
 * vt 0.000000 0.000000
 * vt 1.000000 1.000000
 * s off
 * f 2/1 3/2 1/3
 * f 2/1 4/4 3/2
 *
 * <p>OpenGL coordinates example</p>
 * The coordinates for the example plane from above would look like:
 *  v = 3 = (0.0, 1.0, 0.0)          v = 4 = (1.0, 1.0, 0.0)
 * vt = 2 = (0.0, 1.0)              vt = 4 = (1.0, 1.0)
 *               ------------------------
 *               | \                    |
 *               |    \                 |
 *               |       \              |
 *               |          \           |
 *               |              \       |
 *               |                 \    |
 *               |                    \ |
 *               ------------------------
 *  v = 1 = (0.0, 0.0, 0.0)          v = 2 = (1.0, 0.0, 0.0)
 * vt = 3 = (0.0, 0.0)              vt = 1 = (1.0, 0.0)
 */
// @formatter:on

const val FLOATS_PER_PLANE = 18

object CreatePlane {

    // not usable for indexed
    fun positionData(
        x: Float,
        y: Float,
        z: Float = 0.0f,
        width: Float = 1.0f,
        height: Float = 1.0f
    ) = floatArrayOf(
        // @formatter:off
        x        , y         , z,
        x + width, y         , z,
        x        , y + height, z,
        x + width, y         , z,
        x + width, y + height, z,
        x        , y + height, z,
        // @formatter:on
    )

    fun colorData(r: Float, g: Float, b: Float) = floatArrayOf(
        r, g, b,
        r, g, b,
        r, g, b,
        r, g, b,
        r, g, b,
        r, g, b,
    )
}