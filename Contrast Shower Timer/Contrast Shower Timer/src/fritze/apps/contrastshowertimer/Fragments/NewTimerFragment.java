package fritze.apps.contrastshowertimer.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import android.widget.TextView;
import android.widget.ToggleButton;
import fritze.apps.contrastshowertimer.R;
import fritze.apps.contrastshowertimer.Timer;
import fritze.apps.contrastshowertimer.Managers.GlobalFragmentManager;
import fritze.apps.contrastshowertimer.Managers.TypefaceManager;

public class NewTimerFragment extends Fragment{
	private View view;
	private Button startButton;
	private NumberPicker cyclesPicker, minutesPicker, 
			secondsPicker, secondsOrderPicker;
	private TextView cyclesText, durationText;
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
		cyclesPicker = (NumberPicker) view.findViewById(R.id.numberPickerCycles);
		cyclesPicker.setMinValue(0);
		cyclesPicker.setMaxValue(20);
		cyclesPicker.setWrapSelectorWheel(true);
		cyclesPicker.clearFocus();
		
		
		minutesPicker = (NumberPicker) view.findViewById(R.id.numberPickerMinutes);
		minutesPicker.setMinValue(0);
		minutesPicker.setMaxValue(59);
		minutesPicker.setWrapSelectorWheel(true);
		minutesPicker.clearFocus();
		
		secondsPicker = (NumberPicker) view.findViewById(R.id.numberPickerSeconds);
		secondsPicker.setMinValue(0);
		secondsPicker.setMaxValue(9);
		secondsPicker.setWrapSelectorWheel(true);
		secondsPicker.clearFocus();
		
		secondsOrderPicker = (NumberPicker) view.findViewById(R.id.numberPickerSecondsOrder);
		secondsOrderPicker.setMinValue(0);
		secondsOrderPicker.setMaxValue(5);
		secondsOrderPicker.setWrapSelectorWheel(true);
		secondsOrderPicker.clearFocus();
		
		
		startButton = (Button) view.findViewById(R.id.buttonStartTimer);
		startButton.setOnClickListener(startListener);
		startButton.setTypeface(TypefaceManager.getTfLight(getActivity()));
		
		cyclesText = (TextView) view.findViewById(R.id.textViewCyclesCount);
		cyclesText.setTypeface(TypefaceManager.getTfBold(getActivity()));
		
		durationText = (TextView) view.findViewById(R.id.textViewCycleDuration);
		durationText.setTypeface(TypefaceManager.getTfBold(getActivity()));
		
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
	
	private OnValueChangeListener cyclesListener;
	
	private OnValueChangeListener minutesListener;
	
	private OnValueChangeListener secondsListener;



}
