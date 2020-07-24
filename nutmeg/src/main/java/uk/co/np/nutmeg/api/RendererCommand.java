package uk.co.np.nutmeg.api;

import java.awt.Color;

import org.lwjgl.opengl.GL11;
import static org.lwjgl.opengl.GL46.*;

public class RendererCommand {
	public static void ClearColor(Color c) {
		GL11.glClearColor(c.getRed() / 255f, c.getGreen() / 255f, c.getBlue() / 255f, c.getAlpha() / 255f);
	}
	
	public static void Clear(int... masks) {
		int mask = 0;
		for(int i : masks) {
			mask |= i;
		}
		GL11.glClear(mask);
	} 
	
	
	public static final int
	RC_COLOR_BUFFER = GL_COLOR_BUFFER_BIT;
}
