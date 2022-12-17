package io.github.basiccuboid.graphics

import io.github.basiccuboid.pathfinding.Grid
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

internal class CreateGridGeometryDataTest {

    @Test
    fun `create geometry data from one cell only`() {
        val (grid, _, _) = Grid.createFrom(listOf("c"))
        val actual = CreateGridGeometryData.from(grid)
        expectThat(actual).isEqualTo(
            floatArrayOf(
                0.0f, 0.0f, 0.0f,
                1.0f, 0.0f, 0.0f,
                0.0f, 1.0f, 0.0f,
                1.0f, 0.0f, 0.0f,
                1.0f, 1.0f, 0.0f,
                0.0f, 1.0f, 0.0f,
            )
        )
    }
}