package uk.co.np.nutmeg.api;
import static org.lwjgl.glfw.GLFW.*;

import org.lwjgl.opengl.GL;
public class DisplayManager {
	private static long windowID;
	public static void Open(int _width, int _height, String _title) {
		if(!glfwInit()) return;
		windowID = glfwCreateWindow(_width, _height, _title, 0, 0);
		glfwMakeContextCurrent(windowID);
		GL.createCapabilities();
	}
	
	public static boolean Update() {
		glfwSwapBuffers(windowID);
		glfwPollEvents();
		return !glfwWindowShouldClose(windowID);
	}
	
	public static void Destroy() {
		glfwDestroyWindow(windowID);
		glfwTerminate();
	}
}
