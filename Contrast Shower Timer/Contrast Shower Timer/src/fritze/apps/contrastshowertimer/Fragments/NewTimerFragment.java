package fritze.apps.contrastshowertimer.Fragments;

import android.app.Fragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ToggleButton;
import fritze.apps.contrastshowertimer.R;
import fritze.apps.contrastshowertimer.Timer;
import fritze.apps.contrastshowertimer.TimerActivity;
import fritze.apps.contrastshowertimer.Managers.GlobalFragmentManager;
import fritze.apps.contrastshowertimer.Managers.TypefaceManager;

public class NewTimerFragment extends Fragment{
	private View view;
	private Button startButton, cyclesButton, durationButton;
	private ToggleButton startToggle, endToggle;
	private Timer timer;

	
	@Override
	@Nullable
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.new_timer_layout, null);
		return view;
	}

	@Override
	public void onStart() {
		super.onStart();
		startButton = (Button) view.findViewById(R.id.buttonStartTimer);
		startButton.setOnClickListener(startListener);
		startButton.setTypeface(TypefaceManager.getTfLight(getActivity()));
		
		cyclesButton = (Button) view.findViewById(R.id.buttonSetCyclesCount);
		cyclesButton.setOnClickListener(cyclesListener);
		cyclesButton.setTypeface(TypefaceManager.getTfReg(getActivity()));
		
		durationButton = (Button) view.findViewById(R.id.buttonSetCycleDuration);
		durationButton.setOnClickListener(durationListener);
		durationButton.setTypeface(TypefaceManager.getTfReg(getActivity()));

		
		startToggle = (ToggleButton) view.findViewById(R.id.toggleButtonStartCycle);
		startToggle.setTypeface(TypefaceManager.getTfReg(getActivity()));

		
		endToggle = (ToggleButton) view.findViewById(R.id.toggleButtonEndCycle);
		endToggle.setTypeface(TypefaceManager.getTfReg(getActivity()));

	}
	
	@Override
	public void onResume() {
		super.onResume();
	}
	
	private OnClickListener startListener = new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			boolean startCold = startToggle.isChecked();
			boolean endCold = endToggle.isChecked();
			
			Timer timer = new Timer(0, true, true);
			GlobalFragmentManager.animateNewTimer();
			
		}
	};
	
	private OnClickListener cyclesListener;
	
	private OnClickListener durationListener;



}
