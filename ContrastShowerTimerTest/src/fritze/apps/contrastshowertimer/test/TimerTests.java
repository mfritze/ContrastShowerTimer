package fritze.apps.contrastshowertimer.test;

import android.test.ActivityInstrumentationTestCase2;
import fritze.apps.contrastshowertimer.ShowerTimer;
import fritze.apps.contrastshowertimer.TimerActivity;

public class TimerTests extends ActivityInstrumentationTestCase2<TimerActivity> {

	public TimerTests() {
		super(TimerActivity.class);
	}
	
	public void testNewTimer(){
		ShowerTimer timer = null;
		int cycles = 3;
		int duration = 60;
		boolean isColdStart = true;
		boolean isColdEnd = true;
		timer = new ShowerTimer(cycles,duration, isColdStart, isColdEnd);
		assertTrue("Timer is null", timer != null);
		assertEquals("Cycles is wrong", cycles, timer.getCycles());
		assertEquals("Start is wrong", isColdStart, timer.isHotStart());
		assertEquals("End is wrong", isColdEnd, timer.isHotEnd());
	}
	
	public void testCountdownCount(){
		ShowerTimer timer = null;
		int cycles = 5;
		int duration = 60;
		boolean isColdStart = false;
		boolean isColdEnd = false;
		timer = new ShowerTimer(cycles, duration, isColdStart, isColdEnd);
		assertEquals("Should be twice plus one", cycles*2 + 1, timer.getCountdownCount());
		
		isColdStart = false;
		isColdEnd = true;
		timer = new ShowerTimer(cycles, duration, isColdStart, isColdEnd);
		assertEquals("Should be twice", cycles*2, timer.getCountdownCount());
		
		isColdStart = true;
		isColdEnd = false;
		timer = new ShowerTimer(cycles, duration, isColdStart, isColdEnd);
		assertEquals("Should be twice", cycles*2, timer.getCountdownCount());
		
		isColdStart = true;
		isColdEnd = true;
		timer = new ShowerTimer(cycles, duration, isColdStart, isColdEnd);
		assertEquals("Should be twice plus one", cycles*2 + 1, timer.getCountdownCount());
		
	}
	
	public void testNoCycles(){
		ShowerTimer timer;
		int cycles = 0;
		int duration = 20;
		boolean isHotStart = true;
		boolean isHotEnd = true;
		timer = new ShowerTimer(cycles, duration ,isHotStart, isHotEnd);
		assertEquals("Should be 1", 1, timer.getCountdownCount());
	}

}
