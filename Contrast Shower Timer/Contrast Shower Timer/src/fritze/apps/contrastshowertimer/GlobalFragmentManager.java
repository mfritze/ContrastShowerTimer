package fritze.apps.contrastshowertimer;

import android.app.FragmentManager;
import fritze.apps.contrastshowertimer.Fragments.NewTimerFragment;
import fritze.apps.contrastshowertimer.Fragments.TimerFragment;

public class GlobalFragmentManager {
	private static NewTimerFragment newTimerFragment;
	private static TimerFragment timerFragment;
	private static FragmentManager manager;
	private TimerActivity context;
	private static int containerId;
	private static boolean isShowingTimer;
	
	public GlobalFragmentManager(TimerActivity timerActivity){
		newTimerFragment = new NewTimerFragment();
		timerFragment = new TimerFragment();
		context = timerActivity;
		manager = context.getFragmentManager();
		containerId = R.id.mainFragmentHolder;
		isShowingTimer = false;
	}

	
	public static void animateNewTimer(){
		if(isShowingTimer){
			manager.popBackStack();
			return;
		}
		manager.beginTransaction()
		.setCustomAnimations(R.animator.flip_right_in, R.animator.flip_right_out,
                			 R.animator.flip_left_in, R.animator.flip_left_out)
		.replace(containerId, timerFragment)
		.commit();
	}
	
	public void displayNewTimer(){
		manager.beginTransaction()
		.replace(containerId, newTimerFragment)
		.addToBackStack(null)
		.commit();
	}
	

}
