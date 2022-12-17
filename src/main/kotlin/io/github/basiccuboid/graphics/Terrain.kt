package io.github.basiccuboid.graphics

import io.github.basiccuboid.openglbasic.ShaderProgram
import io.github.basiccuboid.openglbasic.Uniform
import io.github.basiccuboid.openglbasic.VertexArrayObject
import org.joml.Matrix4f
import org.lwjgl.opengl.GL41

data class Terrain(
    val vertexArrayObjectId: Int,
    val shaderProgramId: Int,
    val uniforms: Uniform,
    val count: Int
) {

    fun draw(model: Matrix4f, view: Matrix4f, projection: Matrix4f) {
        GL41.glBindVertexArray(vertexArrayObjectId)
        GL41.glUseProgram(shaderProgramId)
        uniforms.upload(model, view, projection)
        GL41.glDrawArrays(GL41.GL_TRIANGLES, 0, count)
    }

    companion object {

        fun create(grid: List<List<Int>>): Terrain {
            val positions = CreateGridGeometryData.from(grid)
            val colors = CreateGridColorData.from(grid)
            val vaoId = VertexArrayObject.create(positions, colors)
            val shaderProgramId = ShaderProgram.createFromResources(
                "/shader/terrain_vertex.glsl",
                "/shader/terrain_fragment.glsl"
            )
            ShaderProgram.validate(shaderProgramId)
            val uniform = Uniform(shaderProgramId, false)
            val count = positions.size / 3
            return Terrain(vaoId, shaderProgramId, uniform, count)
        }
    }
}
