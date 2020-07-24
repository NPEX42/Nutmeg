package uk.co.np.nutmeg.api;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Objects;

import imgui.*;
import imgui.flag.ImGuiConfigFlags;
import imgui.gl3.ImGuiImplGl3;
import imgui.glfw.ImGuiImplGlfw;
public class UI {
	private static ImGuiIO io;
	private static ImGuiImplGl3 imguiGL3;
	private static ImGuiImplGlfw imguiGLFW;
	
	static {
		ImGui.createContext();
		io = ImGui.getIO();
		int width = DisplayManager.GetWidth();
		int height = DisplayManager.GetHeight();
		io.setDisplaySize(width, height);
		imguiGL3 = new ImGuiImplGl3();
		imguiGLFW = new ImGuiImplGlfw();
		imguiGLFW.init(DisplayManager.GetWindowID(), true);
		imguiGL3.init();
		
		io.setIniFilename(null); // We don't want to save .ini file
        io.addConfigFlags(ImGuiConfigFlags.NavEnableKeyboard | ImGuiConfigFlags.DockingEnable); // Navigation with keyboard and enabled docking
        ImGui.newFrame();
	}
	
	public static void Render() {
		ImGui.render();
		imguiGL3.render(ImGui.getDrawData());
		ImGui.newFrame();
	}
	
	public static void Begin(String _Name) {
		ImGui.begin(_Name);
	}
	
	public static void End() {
		ImGui.end();
	}
	
}
