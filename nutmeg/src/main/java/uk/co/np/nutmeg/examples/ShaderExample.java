package uk.co.np.nutmeg.examples;

import java.awt.Color;

import uk.co.np.nutmeg.api.DisplayManager;
import uk.co.np.nutmeg.api.Mesh;
import uk.co.np.nutmeg.api.RenderCommand;
import uk.co.np.nutmeg.api.Renderer;
import uk.co.np.nutmeg.opengl.Shader;

public class ShaderExample {
	public static void main(String[] _args) {
		DisplayManager.Open(1080, 720, "Shader Example - Nutmeg");
		Mesh mesh = Mesh.CreateQuad(0,0,1,1);
		Shader shader = Shader.LoadShader("uk/co/np/nutmeg/examples/shaders/exampleVS.glsl", "uk/co/np/nutmeg/examples/shaders/exampleFS.glsl");
		if(shader == null) System.exit(1);
		shader.Bind();
		while(DisplayManager.Update()) {
			RenderCommand.ClearColor(Color.blue);
			RenderCommand.Clear(RenderCommand.RC_COLOR_BUFFER);
			RenderCommand.DrawIndexed(mesh.GetVAO(), 6, 0);
		}
		DisplayManager.Destroy();
	}
}
