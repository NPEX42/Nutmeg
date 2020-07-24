package uk.co.np.nutmeg.examples;

import java.awt.Color;

import uk.co.np.nutmeg.api.DisplayManager;
import uk.co.np.nutmeg.api.Mesh;
import uk.co.np.nutmeg.api.RenderCommand;

public class DisplayExample {
	public static void main(String[] _args) {
		DisplayManager.Open(1080, 720, "Display Example - Nutmeg");
		Mesh mesh = Mesh.CreateQuad(0,0,1,1);
		while(DisplayManager.Update()) {
			RenderCommand.ClearColor(Color.blue);
			RenderCommand.Clear(RenderCommand.RC_COLOR_BUFFER);
		}
		DisplayManager.Destroy();
	}
}
