package uk.co.np.nutmeg.api;
import static org.lwjgl.glfw.GLFW.*;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GLUtil;
public class DisplayManager {
	private static long windowID;
	private static int width, height;
	public static void Open(int _width, int _height, String _title) {
		if(!glfwInit()) return;
		windowID = glfwCreateWindow(_width, _height, _title, 0, 0);
		glfwMakeContextCurrent(windowID);
		GL.createCapabilities();
		GLUtil.setupDebugMessageCallback();
		
		width = _width;
		height = _height;
		
		glfwSetWindowSizeCallback(windowID, (long window, int w, int h) -> {
			width = w;
			height = h;
		});
		
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

	public static long GetWindowID() {
		return windowID;
	}

	public static int GetWidth() {
		return width;
	}

	public static int GetHeight() {
		return height;
	}
	
	
	
	
}
