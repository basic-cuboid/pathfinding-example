package io.github.basiccuboid

import io.github.basiccuboid.graphics.Terrain
import org.joml.Matrix4f
import org.lwjgl.glfw.GLFW
import org.lwjgl.opengl.GL41

class MainLoop(grid: List<List<Int>>) {

    private val terrain = Terrain.create(grid)
    private val model = Matrix4f()
    private val view = Configuration.viewMatrix()
    private val projection = Configuration.projectionMatrix()

    fun loop(gameWindowId: Long) {
        while (!GLFW.glfwWindowShouldClose(gameWindowId)) {
            GL41.glClear(GL41.GL_COLOR_BUFFER_BIT or GL41.GL_DEPTH_BUFFER_BIT)

            terrain.draw(model, view, projection)

            GLFW.glfwSwapBuffers(gameWindowId)
            GLFW.glfwPollEvents()
        }
    }
}