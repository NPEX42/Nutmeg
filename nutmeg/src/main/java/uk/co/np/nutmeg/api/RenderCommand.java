package uk.co.np.nutmeg.api;

import java.awt.Color;

import org.lwjgl.opengl.GL11;
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
	RC_FLOAT_32 = GL_FLOAT;
}
