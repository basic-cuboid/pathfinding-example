package io.github.basiccuboid.graphics

object CreateGridColorData {

    fun from(grid: List<List<Int>>): FloatArray {
        val width = grid[0].size
        val height = grid.size
        val size = width * height * FLOATS_PER_PLANE
        val data = FloatArray(size)

        for (y in 0 until height) {
            for (x in 0 until width) {
                val terrainHeight = grid[y][x]
                val red = calculateColor(terrainHeight)
                val green = 1.0f
                val blue = calculateColor2(terrainHeight)
                val colorData = CreatePlane.colorData(red, green, blue)
                val startIndex = (y * width + x) * FLOATS_PER_PLANE

                for ((planeIndex, index) in (startIndex until startIndex + FLOATS_PER_PLANE).withIndex()) {
                    data[index] = colorData[planeIndex]
                }
            }
        }

        return data
    }

    private fun calculateColor(height: Int) = height / 25.0f

    private fun calculateColor2(height: Int) = 1.0f - (height / 25.0f)
}