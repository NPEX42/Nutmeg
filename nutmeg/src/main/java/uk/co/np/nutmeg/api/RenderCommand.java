package uk.co.np.nutmeg.api;

import java.awt.Color;

import org.lwjgl.opengl.GL11;

import uk.co.np.nutmeg.opengl.VertexArray;

import static org.lwjgl.opengl.GL46.*;

public class RenderCommand {
	public static void ClearColor(Color _c) {
		GL11.glClearColor(
				_c.getRed() / 255f,
				_c.getGreen() / 255f,
				_c.getBlue() / 255f,
				_c.getAlpha() / 255f
		);
	}
	
	public static void ClearColor(float[] color) {
		GL11.glClearColor(color[0],color[1],color[2],color[3]);
	}
	
	public static void Clear(int... _masks) {
		int mask = 0;
		for(int i : _masks) {
			mask |= i;
		}
		GL11.glClear(mask);
	} 
	
	
	public static final int
	RC_COLOR_BUFFER = GL_COLOR_BUFFER_BIT,
	RC_UINT_32 = GL_UNSIGNED_INT,
	RC_UINT_16 = GL_UNSIGNED_SHORT,
	RC_UINT_8  = GL_UNSIGNED_BYTE,
	RC_INT_32 = GL_INT,
	RC_INT_16 = GL_SHORT,
	RC_INT_8  = GL_BYTE,
	RC_FLOAT_32 = GL_FLOAT,
	RC_MODE_TRIANGLES = GL_TRIANGLES;


	public static void DrawIndexed(VertexArray _VAO, int _VertexCount, int _Offset) {
		_VAO.Bind();
		glDrawElements(RC_MODE_TRIANGLES, _VertexCount, RC_UINT_32, _Offset);
	}

	public static void ResizeViewport(int _Width, int _Height) {
		glViewport(0, 0, _Width, _Height);
	}
}
