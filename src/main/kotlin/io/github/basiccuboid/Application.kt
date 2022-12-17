package io.github.basiccuboid

import io.github.basiccuboid.openglbasic.CleanUp
import io.github.basiccuboid.openglbasic.GameWindow
import io.github.basiccuboid.pathfinding.Grid
import mu.KotlinLogging
import java.io.File

private val logger = KotlinLogging.logger {}

fun main() {
    val config = Configuration.openGl()
    logger.info { config.prettyFormat() }
    val id = GameWindow.create(config)

    val filename = File("./data/height-values.txt").readLines()
    val (grid, _, _) = Grid.createFrom(filename)
    MainLoop(grid).loop(id)

    CleanUp.purge()
}