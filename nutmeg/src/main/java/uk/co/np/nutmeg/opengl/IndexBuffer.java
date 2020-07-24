package uk.co.np.nutmeg.opengl;

import static org.lwjgl.opengl.GL15.glDeleteBuffers;
import static org.lwjgl.opengl.GL46.*;

import java.util.Arrays;

/**
 * @author George Venn
 * @version V0.3.0-ALPHA
 */
public class IndexBuffer {
	private int ID, vertexCount;
	public void Bind() { glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ID); }
	public void Delete() { glDeleteBuffers(ID); }
	public static IndexBuffer Create(int[] _Data) {
		IndexBuffer buffer = new IndexBuffer(glGenBuffers(), _Data.length);
		buffer.Bind();
		glBufferData(GL_ELEMENT_ARRAY_BUFFER, _Data, GL_STATIC_DRAW);
		System.err.println("[Nutmeg] Creating IBO, Data: "+Arrays.toString(_Data));
		return buffer;
	}
	
	private IndexBuffer(int _ID, int _VertexCount) {
		ID = _ID;
		vertexCount = _VertexCount;
		System.err.println("[Nutmeg] Creating IBO #"+ID);
	}
	
	public int GetVertexCount() { return vertexCount; }
}
