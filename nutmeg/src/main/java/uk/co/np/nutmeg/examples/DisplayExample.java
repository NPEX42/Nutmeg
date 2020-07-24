package uk.co.np.nutmeg.examples;

import uk.co.np.nutmeg.api.DisplayManager;

public class DisplayExample {
	public static void main(String[] args) {
		DisplayManager.Open(1080, 720, "Display Example - Nutmeg");
		while(DisplayManager.Update()) {
			
		}
		DisplayManager.Destroy();
	}
}
