package nutmeg;
import static org.lwjgl.glfw.GLFW.*;

import org.lwjgl.opengl.GL;
public class DisplayManager {
	private static long windowID;
	public static void Open(int width, int height, String title) {
		if(!glfwInit()) return;
		windowID = glfwCreateWindow(width, height, title, 0, 0);
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
