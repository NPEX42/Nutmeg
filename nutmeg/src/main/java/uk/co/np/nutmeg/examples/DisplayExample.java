package uk.co.np.nutmeg.examples;

import java.awt.Color;

import uk.co.np.nutmeg.api.DisplayManager;
import uk.co.np.nutmeg.api.RendererCommand;

public class DisplayExample {
	public static void main(String[] args) {
		DisplayManager.Open(1080, 720, "Display Example - Nutmeg");
		while(DisplayManager.Update()) {
			RendererCommand.ClearColor(Color.blue);
			RendererCommand.Clear(RendererCommand.RC_COLOR_BUFFER);
		}
		DisplayManager.Destroy();
	}
}
