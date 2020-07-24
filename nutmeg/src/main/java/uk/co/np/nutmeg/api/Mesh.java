package uk.co.np.nutmeg.api;

import uk.co.np.nutmeg.opengl.IndexBuffer;
import uk.co.np.nutmeg.opengl.VertexArray;
import uk.co.np.nutmeg.opengl.VertexBuffer;

public class Mesh {
	private VertexArray vao;
	private VertexBuffer positionBuffer;
	private IndexBuffer triangleBuffer;
	public static Mesh CreateQuad(float _x, float _y, float _w, float _h) {
		
		float x = _x, y = _x, w = _w, h = _h;
		
		float[] pos = {
			x - w / 2, y - h / 2,
			x + w / 2, y - h / 2,
			x + w / 2, y + h / 2,
			x - w / 2, y + h / 2
		};
		
		return new Mesh(pos, new int[] {0,1,2,2,3,0});
	}
	
	public Mesh(float[] _Pos, int[] _Tris) {
		vao = VertexArray.Create();
		positionBuffer = VertexBuffer.Create(0, _Pos, 2);
		triangleBuffer = IndexBuffer.Create(_Tris);
	}
	
	public void Bind() {
		vao.Bind();
		triangleBuffer.Bind();
	}
	
	public VertexArray GetVAO() { return vao; }
	public int GetVertexCount() { return triangleBuffer.GetVertexCount(); }
}
