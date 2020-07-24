package uk.co.np.nutmeg.api;

public class Renderer {

	public static void Draw(Mesh mesh) {
		RenderCommand.DrawIndexed(mesh.GetVAO(), mesh.GetVertexCount(), 0);
	}
	
}
