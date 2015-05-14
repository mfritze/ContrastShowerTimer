package fritze.apps.contrastshowertimer.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import fritze.apps.contrastshowertimer.GlobalFragmentManager;
import fritze.apps.contrastshowertimer.R;
import fritze.apps.contrastshowertimer.Timer;

public class NewTimerFragment extends Fragment{
	private View view;
	private Button startButton;
	
	@Override
	@Nullable
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.new_timer_layout, null);
		return view;
	}

	@Override
	public void onResume() {
		super.onResume();
	}

	@Override
	public void onStart() {
		super.onStart();
		startButton = (Button) view.findViewById(R.id.buttonStartTimer);
		startButton.setOnClickListener(startListener);
	}
	
	private OnClickListener startListener = new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Timer timer = new Timer(0, true, true);
			GlobalFragmentManager.animateNewTimer();
			
		}
	};

}
