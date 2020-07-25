package uk.co.np.nutmeg.api;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Objects;

import org.lwjgl.glfw.GLFW;

import imgui.*;
import imgui.flag.ImGuiConfigFlags;
import imgui.gl3.ImGuiImplGl3;
import imgui.glfw.ImGuiImplGlfw;
import uk.co.np.nutmeg.api.events.EventSystem;
public class UI {
	private static ImGuiIO io;
	private static ImGuiImplGl3 imguiGL3;
	private static ImGuiImplGlfw imguiGLFW;
	private static boolean[] mouseState;
	
	static {
		ImGui.createContext();
		io = ImGui.getIO();
		int width = DisplayManager.GetWidth();
		int height = DisplayManager.GetHeight();
		io.setDisplaySize(width, height);
		imguiGL3 = new ImGuiImplGl3();
		imguiGLFW = new ImGuiImplGlfw();
		imguiGLFW.init(DisplayManager.GetWindowID(),false);
		imguiGL3.init();
		
		io.setIniFilename(null); // We don't want to save .ini file
        io.addConfigFlags(ImGuiConfigFlags.NavEnableKeyboard | ImGuiConfigFlags.DockingEnable); // Navigation with keyboard and enabled docking
        ImGui.newFrame();
        
        EventSystem.RegisterResizeCallback(UI::OnResize);
        EventSystem.RegisterMouseMovedCallback(UI::OnMouseMoved);
        EventSystem.RegisterMouseClickedCallback(UI::OnMouseClicked);
        EventSystem.RegisterMouseScrolledCallback(UI::OnMouseScrolled);
        EventSystem.RegisterCharEventCallback(UI::OnCharEvent);
        EventSystem.RegisterKeyEventCallback(UI::OnKeyEvent);
        
        mouseState = new boolean[16];
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
	
	public static void ShowDemoWindow() {
		ImGui.showDemoWindow();
	}
	
	public static void Text(String _Text) {
		ImGui.text(_Text);
	}
	
	public static void TextColored(int _RGBA, String _Text) {
		ImGui.textColored(_RGBA, _Text);
	}
	
	public static void Text(String _Format, Object... _Args) {
		Text(String.format(_Format, _Args));
	}
	
	public static float[] ColorPicker4(String _Text, float[] _Color) {
		ImGui.colorPicker4(_Text, _Color);
		return _Color;
	}
	
	public static float[] ColorEdit3(String _Text, float[] _Color) {
		ImGui.colorEdit3(_Text, _Color);
		return _Color;
	}
	
	public static void Slider1f(String _Text, float[] _Ptr, float _Max, float _Min) {
		ImGui.sliderFloat(_Text, _Ptr, _Min, _Max);
	} 
	
//==== EVENT SYSTEM CALLBACKS ======================================================================================================
	
	public static void OnResize(int _Width, int _Height) {
		io.setDisplaySize(_Width, _Height);
	}
	
	public static void OnMouseMoved(double _X, double _Y) {
		io.setMousePos((float)_X, (float)_Y);
	}
	
	public static void OnMouseClicked(int _Button,int _Action, int _Mods) {
		if(_Action == GLFW.GLFW_PRESS || _Action == GLFW.GLFW_REPEAT) {
			mouseState[_Button] = true; 
		} else {
			mouseState[_Button] = false;
		}
		io.setMouseDown(mouseState);
	}
	
	public static void OnMouseScrolled(float _Y) {
		io.setMouseWheel(_Y);
	}
	
	public static void OnCharEvent(char _Key) {
		io.addInputCharacter(_Key);
	}
	
	public static void OnKeyEvent(char _Key, int _Action, int _Mods) {
		System.err.println("[Nutmeg UI] KEY: "+_Key);
		if(_Action == GLFW.GLFW_PRESS || _Action == GLFW.GLFW_REPEAT) {
			io.setKeysDown(_Key, true);
		} else {
			io.setKeysDown(_Key, false);
		}
	}

	
	
}
