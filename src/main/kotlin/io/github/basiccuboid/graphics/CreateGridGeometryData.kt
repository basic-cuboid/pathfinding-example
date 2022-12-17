package io.github.basiccuboid.graphics

object CreateGridGeometryData {

    fun from(grid: List<List<Int>>): FloatArray {
        val width = grid[0].size
        val height = grid.size
        val size = width * height * FLOATS_PER_PLANE
        val data = FloatArray(size)

        for (y in 0 until height) {
            for (x in 0 until width) {
                val plane = CreatePlane.positionData(x.toFloat(), y.toFloat())
                val startIndex = (y * width + x) * FLOATS_PER_PLANE

                for ((planeIndex, index) in (startIndex until startIndex + FLOATS_PER_PLANE).withIndex()) {
                    data[index] = plane[planeIndex]
                }
            }
        }

        return data
    }
}