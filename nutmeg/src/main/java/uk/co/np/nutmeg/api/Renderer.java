package uk.co.np.nutmeg.api;

import uk.co.np.nutmeg.api.events.EventSystem;

public class Renderer {
	private static int drawCallCount, verticesRendered;
	static {
		EventSystem.RegisterResizeCallback(Renderer::OnResize);
	}
	
	
	public static void Draw(Mesh mesh) {
		RenderCommand.DrawIndexed(mesh.GetVAO(), mesh.GetVertexCount(), 0);
		drawCallCount++;
		verticesRendered += mesh.GetVertexCount();
	}
	
	public static void ResetStatistics() {
		drawCallCount = 0;
		verticesRendered = 0;
	}
	
	public static void OnResize(int _Width, int _Height) {
		RenderCommand.ResizeViewport(_Width, _Height);
	}
	
	public static int GetDrawCallCount() {
		return drawCallCount;
	}
	
	public static int GetVerticesRendered() {
		return verticesRendered;
	}
	
}
