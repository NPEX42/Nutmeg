package uk.co.np.nutmeg.api;

public class Timer {
	private long TP1, TP2;
	private String timerName;
	public Timer() {
		timerName = "Unamed Timer";
	}
	
	public Timer(String _Name) {
		timerName = _Name;
	}
	
	public void Start() {
		TP1 = System.nanoTime();
	}
	
	public void Stop() {
		TP2 = System.nanoTime();
	}
	
	public long GetTimeNano() {
		return (TP2 - TP1);
	}
	
	public float GetTimeMicro() {
		return GetTimeNano() / 1000f;
	}
	
	public double GetTimeMillis() {
		return GetTimeMicro() / 1000f;
	}
	
	public double GetTimeSeconds() {
		return GetTimeMillis() / 1000f;
	}
	
}
