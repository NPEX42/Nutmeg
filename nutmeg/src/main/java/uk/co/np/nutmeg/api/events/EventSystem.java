package uk.co.np.nutmeg.api.events;

import static org.lwjgl.glfw.GLFW.*;

import java.util.ArrayList;
import java.util.List;

import uk.co.np.nutmeg.api.DisplayManager;
import uk.co.np.nutmeg.api.events.callbacks.CharEventCB;
import uk.co.np.nutmeg.api.events.callbacks.KeyEventCB;
import uk.co.np.nutmeg.api.events.callbacks.MouseClickedCB;
import uk.co.np.nutmeg.api.events.callbacks.MouseMovedCB;
import uk.co.np.nutmeg.api.events.callbacks.MouseScrolledCB;
import uk.co.np.nutmeg.api.events.callbacks.ResizeCB;

public class EventSystem {
	//OnWindowResize()
	//OnMouseMoved()
	//OnMouseClicked();
	//OnCharEvent()
	//OnKeyEvent()
	
	private static List<ResizeCB> resizeCallbacks = new ArrayList<ResizeCB>();
	private static List<MouseMovedCB> mouseMovedCallbacks = new ArrayList<MouseMovedCB>();
	private static List<MouseClickedCB> mouseClickedCallbacks = new ArrayList<MouseClickedCB>();
	private static List<CharEventCB> charEventCallbacks = new ArrayList<CharEventCB>();
	private static List<KeyEventCB> keyEventCallbacks = new ArrayList<KeyEventCB>();
	private static List<MouseScrolledCB> mouseScrolledCallbacks = new ArrayList<MouseScrolledCB>();
	
	static {
		glfwSetWindowSizeCallback(DisplayManager.GetWindowID(), EventSystem::DispatchResizeEvent);
		glfwSetCursorPosCallback(DisplayManager.GetWindowID(), EventSystem::DispatchMouseMovedEvent);
		glfwSetMouseButtonCallback(DisplayManager.GetWindowID(), EventSystem::DispatchMouseClickedEvent);
		glfwSetScrollCallback(DisplayManager.GetWindowID(), EventSystem::DispatchMouseScrolledEvent);
		glfwSetCharCallback(DisplayManager.GetWindowID(), EventSystem::DispatchCharEvent);
		glfwSetKeyCallback(DisplayManager.GetWindowID(), EventSystem::DispatchKeyEvent);
	}
	
	public static void RegisterResizeCallback(ResizeCB cb) {
		resizeCallbacks.add(cb);
	}
	
	public static void RegisterMouseMovedCallback(MouseMovedCB cb) {
		mouseMovedCallbacks.add(cb);
	}
	
	public static void RegisterMouseClickedCallback(MouseClickedCB cb) {
		mouseClickedCallbacks.add(cb);
	}
	
	public static void RegisterMouseScrolledCallback(MouseScrolledCB cb) {
		mouseScrolledCallbacks.add(cb);
	}
	
	public static void RegisterCharEventCallback(CharEventCB cb) {
		charEventCallbacks.add(cb);
	}
	
	public static void RegisterKeyEventCallback(KeyEventCB cb) {
		keyEventCallbacks.add(cb);
	}
	
	public static void DispatchResizeEvent(long _WindowID, int _Width, int _Height) {
		//System.err.println("[Nutmeg] Dispatching Resize Event ("+_Width+"x"+_Height+")");
		for(ResizeCB cb : resizeCallbacks) {
			cb.invoke(_Width, _Height);
		}
	}
	
	public static void DispatchMouseMovedEvent(long _WindowID, double _X, double _Y) {
		//System.err.println("[Nutmeg] Dispatching Mouse Moved Event ("+_X+","+_Y+")");
		for(MouseMovedCB cb : mouseMovedCallbacks) {
			cb.invoke(_X, _Y);
		}
	}
	
	public static void DispatchMouseClickedEvent(long _WindowID, int _Button, int _Action, int _Mods) {
		//System.err.println("[Nutmeg] Dispatching Mouse Button Event ("+_Button+", "+_Action+", "+_Mods+")");
		for(MouseClickedCB cb : mouseClickedCallbacks) {
			cb.invoke(_Button, _Action, _Mods);
		}
	}
	
	public static void DispatchMouseScrolledEvent(long _WindowID, double _X, double _Y) {
		//System.err.println("[Nutmeg] Dispatching Mouse Button Event ("+_Y+")");
		for(MouseScrolledCB cb : mouseScrolledCallbacks) {
			cb.invoke((float)_Y);
		}
	}
	
	public static void DispatchCharEvent(long _WindowID, int _Code) {
		//System.err.println("[Nutmeg] Dispatching Mouse Button Event ("+((char)code)+")");
		for(CharEventCB cb : charEventCallbacks) {
			cb.invoke((char)_Code);
		}
	}
	
	public static void DispatchKeyEvent(long _WindowID, int _Key, int _ScanCode, int _Action, int _Mods) {
		for(KeyEventCB cb : keyEventCallbacks) {
			cb.invoke( (char) _Key, _Action, _Mods);
		}
	}
	
	
	
}
