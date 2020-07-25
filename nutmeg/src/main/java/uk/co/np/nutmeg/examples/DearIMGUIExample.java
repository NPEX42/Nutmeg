package uk.co.np.nutmeg.examples;

import java.awt.Color;

import uk.co.np.nutmeg.api.DisplayManager;
import uk.co.np.nutmeg.api.Mesh;
import uk.co.np.nutmeg.api.RenderCommand;
import uk.co.np.nutmeg.api.Renderer;
import uk.co.np.nutmeg.api.Timer;
import uk.co.np.nutmeg.api.UI;
import uk.co.np.nutmeg.opengl.Shader;

public class DearIMGUIExample {
	public static float[] backgroundColor = new float[4];
	public static void main(String[] _args) {
		DisplayManager.Open(1080, 720, "Shader Example - Nutmeg");
		Mesh mesh = Mesh.CreateQuad(0,0,1,1);
		Shader shader = Shader.LoadShader("uk/co/np/nutmeg/examples/shaders/exampleVS.glsl", "uk/co/np/nutmeg/examples/shaders/exampleFS.glsl");
		if(shader == null) System.exit(1);
		shader.Bind();
		Timer frameTimer = new Timer("Frame Timer");
		while(DisplayManager.Update()) {
			frameTimer.Start();
			RenderCommand.ClearColor(backgroundColor);
			RenderCommand.Clear(RenderCommand.RC_COLOR_BUFFER);
			RenderCommand.DrawIndexed(mesh.GetVAO(), 6, 0);
			//UI.ShowDemoWindow();
			frameTimer.Stop();
			UI.Begin("Example Window");
				UI.Text("TPF: %02.3f ms (%03.3f fps)", frameTimer.GetTimeMillis(), 1f / frameTimer.GetTimeSeconds());
				int color = 0xFF00FF00;
				if(1f / frameTimer.GetTimeSeconds() < 60) color = 0xFF0000FF;
				UI.TextColored(color, "REAL-TIME (60hz)");
				UI.Text("Renderer Stats: \n\tDraw Calls: %03d\n\tVertices: %d",Renderer.GetDrawCallCount(),Renderer.GetVerticesRendered());
				UI.ColorEdit3("Background Color", backgroundColor);
			UI.End();
			
			UI.Render();
			//Renderer.ResetStatistics();
		}
		DisplayManager.Destroy();
	}
}
