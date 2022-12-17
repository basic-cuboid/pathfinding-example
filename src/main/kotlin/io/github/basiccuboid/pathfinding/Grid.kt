package io.github.basiccuboid.pathfinding

object Grid {

    fun createFrom(lines: List<String>): Triple<List<List<Int>>, Position, Position> {
        var start = Position()
        var target = Position()
        val grid = lines.mapIndexed { y, line ->
            line.mapIndexed { x, char ->
                when (char) {
                    'S' -> {
                        start = Position(x, y)
                        0
                    }
                    'E' -> {
                        target = Position(x, y)
                        25
                    }
                    else -> char.code - 97
                }
            }
        }
        return Triple(grid, start, target)
    }
}
