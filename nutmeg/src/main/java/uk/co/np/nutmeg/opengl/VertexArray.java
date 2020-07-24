package uk.co.np.nutmeg.opengl;
import static org.lwjgl.opengl.GL46.*;
public class VertexArray {
	private int ID;
	public void Bind  () { glBindVertexArray(ID); }
	public void Unbind() { glBindVertexArray(0);  }
	private VertexArray() {
		ID = glGenVertexArrays();
		System.err.println("[Nutmeg] Creating VAO #"+ID);
	}
	public static VertexArray Create() {
		VertexArray array = new VertexArray();
		array.Bind();
		return array;
	}
	public void Delete() { glDeleteVertexArrays(ID); }
}
