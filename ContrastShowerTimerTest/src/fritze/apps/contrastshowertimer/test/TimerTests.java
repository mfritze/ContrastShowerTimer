package fritze.apps.contrastshowertimer.test;

import android.test.ActivityInstrumentationTestCase2;
import fritze.apps.contrastshowertimer.Timer;
import fritze.apps.contrastshowertimer.TimerActivity;

public class TimerTests extends ActivityInstrumentationTestCase2<TimerActivity> {

	public TimerTests() {
		super(TimerActivity.class);
	}
	
	public void testNewTimer(){
		Timer timer = null;
		int cycles = 3;
		boolean isColdStart = true;
		boolean isColdEnd = true;
		timer = new Timer(cycles, isColdStart, isColdEnd);
		assertTrue("Timer is null", timer != null);
		assertEquals("Cycles is wrong", cycles, timer.getCycles());
		assertEquals("Start is wrong", isColdStart, timer.isColdStart());
		assertEquals("End is wrong", isColdEnd, timer.isColdEnd());
	}
	
	public void testCountdownCount(){
		Timer timer = null;
		int cycles = 5;
		boolean isColdStart = false;
		boolean isColdEnd = false;
		timer = new Timer(cycles, isColdStart, isColdEnd);
		assertEquals("Should be twice plus one", cycles*2 + 1, timer.getCountdownCount());
		
		isColdStart = false;
		isColdEnd = true;
		timer = new Timer(cycles, isColdStart, isColdEnd);
		assertEquals("Should be twice", cycles*2, timer.getCountdownCount());
		
		isColdStart = true;
		isColdEnd = false;
		timer = new Timer(cycles, isColdStart, isColdEnd);
		assertEquals("Should be twice", cycles*2, timer.getCountdownCount());
		
		isColdStart = true;
		isColdEnd = true;
		timer = new Timer(cycles, isColdStart, isColdEnd);
		assertEquals("Should be twice plus one", cycles*2 + 1, timer.getCountdownCount());
		
	}

}
