package fritze.apps.contrastshowertimer;

public class Timer {
	private boolean isColdStart, isColdEnd;
	private int countdownCount, cycles;
	

	public Timer(int cycles, boolean isColdStart, boolean isColdEnd) {
		this.cycles = cycles;
		this.isColdEnd = isColdEnd;
		this.isColdStart = isColdStart;
		this.countdownCount = cycles*2;
		
		if(isColdStart == isColdEnd){
			this.countdownCount++;
		}
	}

	public boolean isColdStart() {
		return isColdStart;
	}

	public boolean isColdEnd() {
		return isColdEnd;
	}

	public int getCountdownCount() {
		return countdownCount;
	}

	public int getCycles() {
		return cycles;
	}

}
