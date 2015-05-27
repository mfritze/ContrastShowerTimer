package fritze.apps.contrastshowertimer;

public class ShowerTimer {
	private boolean isHotStart, isHotEnd;
	private int countdownCount, cycles, duration;
	

	public ShowerTimer(int cycles, int duration, boolean isHotStart, boolean isHotEnd) {
		this.cycles = cycles;
		this.duration = duration;
		this.isHotEnd = isHotEnd;
		this.isHotStart = isHotStart;
		this.countdownCount = cycles*2;
		
		if(isHotStart == isHotEnd){
			this.countdownCount++;
		}
	}

	public int getDuration() {
		return duration;
	}

	public boolean isHotStart() {
		return isHotStart;
	}

	public boolean isHotEnd() {
		return isHotEnd;
	}

	public int getCountdownCount() {
		return countdownCount;
	}

	public int getCycles() {
		return cycles;
	}

}
