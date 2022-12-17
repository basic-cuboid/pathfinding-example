package io.github.basiccuboid

import io.github.basiccuboid.openglbasic.OpenGlConfiguration
import org.joml.Matrix4f

object Configuration {

    fun openGl() = OpenGlConfiguration(
        majorVersion = 4,
        minorVersion = 1,
        title = "A* Path Finding",
        screenWidth = 1920,
        screenHeight = 1080,
        fullscreen = true,
        vSync = true,
        wireFrane = false,
        clearColorRed = 0.25f,
        clearColorGreen = 0.25f,
        clearColorBlue = 0.25f,
        nearPlane = 0.01f,
        farPlane = 100.0f
    )

    fun viewMatrix(): Matrix4f =
        Matrix4f().setLookAt(0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f)

    fun projectionMatrix(): Matrix4f =
        Matrix4f().setOrtho(0.0f, 200.0f, 0.0f, 50.0f, 0.01f, 100.0f)
        // Matrix4f().setOrtho(0.0f, 20.0f, 0.0f, 10.0f, 0.01f, 100.0f)
}