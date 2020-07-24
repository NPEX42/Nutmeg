package uk.co.np.nutmeg.opengl;
import static org.lwjgl.opengl.GL46.*;

import java.util.Arrays;
public class VertexBuffer {
	private int ID;
	public void Bind() { glBindBuffer(GL_ARRAY_BUFFER, ID); }
	public void Delete() { glDeleteBuffers(ID); }
	public static VertexBuffer Create(int _Index, float[] _Data, int _Size, int _Stride, int _Offset) {
		VertexBuffer buffer = new VertexBuffer(glGenBuffers());
		buffer.Bind();
		glBufferData(GL_ARRAY_BUFFER, _Data, GL_STATIC_DRAW);
		glVertexAttribPointer(_Index, _Size, GL_FLOAT, false, _Stride, _Offset);
		glEnableVertexAttribArray(_Index);
		System.err.println("[Nutmeg] Creating VBO, Data: "+Arrays.toString(_Data));
		return buffer;
	}
	
	public static VertexBuffer Create(int _Index, float[] _Data, int _Size) {
		return Create(_Index, _Data, _Size, 0, 0);
	}
	
	public VertexBuffer(int _ID) {
		ID = _ID;
		System.err.println("[Nutmeg] Creating VBO #"+ID);
	}
	
	
}
