package io.github.basiccuboid.graphics

import io.github.basiccuboid.pathfinding.Grid
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

internal class CreateGridColorDataTest {

    @Test
    fun `create color data for lowest point (smallest grid)`() {
        val (grid, _, _) = Grid.createFrom(listOf("a"))
        val actual = CreateGridColorData.from(grid)
        expectThat(actual).isEqualTo(
            floatArrayOf(
                0.0f, 1.0f, 0.0f,
                0.0f, 1.0f, 0.0f,
                0.0f, 1.0f, 0.0f,
                0.0f, 1.0f, 0.0f,
                0.0f, 1.0f, 0.0f,
                0.0f, 1.0f, 0.0f,
            )
        )
    }

    @Test
    fun `create color data for highest point (smallest grid)`() {
        val (grid, _, _) = Grid.createFrom(listOf("z"))
        val actual = CreateGridColorData.from(grid)
        expectThat(actual).isEqualTo(
            floatArrayOf(
                1.0f, 1.0f, 1.0f,
                1.0f, 1.0f, 1.0f,
                1.0f, 1.0f, 1.0f,
                1.0f, 1.0f, 1.0f,
                1.0f, 1.0f, 1.0f,
                1.0f, 1.0f, 1.0f,
            )
        )
    }
}