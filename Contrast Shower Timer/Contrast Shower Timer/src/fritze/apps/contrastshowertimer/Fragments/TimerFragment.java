package fritze.apps.contrastshowertimer.Fragments;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import fritze.apps.contrastshowertimer.R;
import fritze.apps.contrastshowertimer.ShowerTimer;
import fritze.apps.contrastshowertimer.Managers.GlobalFragmentManager;
import fritze.apps.contrastshowertimer.Managers.TypefaceManager;


@SuppressLint("InflateParams")
public class TimerFragment extends Fragment{
	private View view;
	private ShowerTimer sTimer;
	private TextView timerText, timerTitle;
	private int white, blue, red, green;
	private boolean isPaused, isHot;
	private CountDownTimer timer;
	private final int SECOND = 1000;
	private RelativeLayout timerLayout;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		white = Color.WHITE;
		red = getResources().getColor(R.color.red);
		blue = getResources().getColor(R.color.blue);
		green = getResources().getColor(R.color.green);
	}
	
	@Override
	@Nullable
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.timer_layout, null);
		return view;
	}

	
	@Override
	public void onStart() {
		super.onStart();
		timerLayout = (RelativeLayout) view.findViewById(R.id.timer_layout);
		
		timerText = (TextView) view.findViewById(R.id.chronometerTimer);
		timerText.setTypeface(TypefaceManager.getTfReg(getActivity()));
		
		timerTitle = (TextView) view.findViewById(R.id.textViewTimerTitle);
		timerTitle.setTypeface(TypefaceManager.getTfBold(getActivity()));
	}

	@Override
	public void onResume() {
		super.onResume();
		isHot = sTimer.isHotStart();
		setTimerTitleText("GET READY", green);
		readyCountdown();
	}

	
	private void setBackground(){
		if(isHot){
			timerLayout.setBackgroundColor(red);
		}else{
			timerLayout.setBackgroundColor(blue);
		}
	}
	
	private void degrementCount() {
		if(isHot){
			
		}else{
			 
		}
	}

	private void countdown(final int cyclesRemaining, final int duration){
		timer = new CountDownTimer(duration, SECOND){

			@Override
			public void onTick(long millisUntilFinished) {
				int secondsLeft = (int) millisUntilFinished / 1000;
				setTimerText(secondsLeft, white);
			}

			@Override
			public void onFinish() {
				// TODO play a sound/notification etc
				timerText.setText("");
				Toast.makeText(getActivity(), "FINISED", Toast.LENGTH_SHORT).show();
				setBackground();
				degrementCount();
				isHot = !isHot;
				if(cyclesRemaining > 0){
					countdown(cyclesRemaining - 1, duration);
				}else{
					GlobalFragmentManager.displayDone();
				}
			}
			
		}.start();
	}
	
	private void readyCountdown(){
		final int DURATION = 2000;
		setTimerText(DURATION, green);
		timer = new CountDownTimer(DURATION, SECOND){

			@Override
			public void onTick(long millisUntilFinished) {
				int secondsLeft = (int) millisUntilFinished / 1000;
				setTimerText(secondsLeft, green);
			}

			@Override
			public void onFinish() {
				// TODO play a sound/notification etc
				timerTitle.setVisibility(View.GONE);
				countdown(sTimer.getCountdownCount(), sTimer.getDuration() * SECOND);
			}
			
		}.start();
	}
	
	private void setTimerTitleText(String text, int textColor){
		timerTitle.setText(text);
		timerTitle.setTextColor(textColor);
	}
	
	private void setTimerText(int seconds, int textColor){
		timerText.setTextColor(textColor);
		String text = "";
		text += Integer.toString((int) seconds / 60) + ":";
		text += Integer.toString(seconds % 60);
		timerText.setText(text);
	}

	public void setTimer(ShowerTimer timer) {
		this.sTimer = timer;
	}
	
}
