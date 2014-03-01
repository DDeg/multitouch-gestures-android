package com.dmns.lib.gestures.alpha;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.dmns.multitouch.gestures.lib.Gestures;
import com.dmns.multitouch.gestures.lib.GesturesListener;

public class MainActivity extends Activity implements OnTouchListener{
	
	float x;
	float y;
	TextView dspStat;
	TextView actStatX;
	TextView actStatY;
	TextView dspStatX;
	TextView dspStatY;
	TextView actStatus;
	TextView dspStatus;
	GesturesListener gListener;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		dspStat = (TextView) findViewById(R.id.preactstatus);
		actStatX = (TextView) findViewById(R.id.actx);
		actStatY = (TextView) findViewById(R.id.acty);
		dspStatX = (TextView) findViewById(R.id.dispx);
		dspStatY = (TextView) findViewById(R.id.dispy);
		actStatus = (TextView) findViewById(R.id.act_movement);
		dspStatY = (TextView) findViewById(R.id.dsp_movement);
		
		
		setContentView(R.layout.main);
		
		
		LinearLayout ll = (LinearLayout)findViewById(R.id.linearLayout1);
		ll.setOnTouchListener(this);
		gListener = new GesturesListener(getApplicationContext());
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public boolean dispatchTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		x = event.getX();
		y = event.getY();
		
		
		dspStat = (TextView) findViewById(R.id.preactstatus);
		dspStatX = (TextView) findViewById(R.id.dispx);
		dspStatY = (TextView) findViewById(R.id.dispy);
		dspStatus = (TextView) findViewById(R.id.dsp_movement);
		
		dspStat.setText("TouchEvent is not on Activity");
		dspStatX.setText("DSPX  " + x);
		dspStatY.setText("DSPY  " + y);
		
		switch(event.getAction()){
		case MotionEvent.ACTION_DOWN:
			dspStatus.setText("DSP Down");
			break;
		case MotionEvent.ACTION_MOVE:
			dspStatus.setText("DSP Move");
			break;

		case MotionEvent.ACTION_UP:
			dspStatus.setText("DSP Up");
			break;
		}
		
		dspStat.setText(String.format("%x", gListener.Update(event)));
		
		switch(gListener.Update(event)){
		case Gestures.TWO_FINGERS_UP:
			Toast.makeText(this, "Two fingers up", Toast.LENGTH_SHORT).show();
			gListener = new GesturesListener(getApplicationContext());
			break;
		case Gestures.TWO_FINGERS_DOWN:
			Toast.makeText(this, "Two fingers down", Toast.LENGTH_SHORT).show();
			gListener = new GesturesListener(getApplicationContext());
			break;
		case Gestures.TWO_FINGERS_RIGHT:
			Toast.makeText(this, "Two fingers right", Toast.LENGTH_SHORT).show();
			gListener = new GesturesListener(getApplicationContext());
			break;
		case Gestures.TWO_FINGERS_LEFT:
			Toast.makeText(this, "Two fingers left", Toast.LENGTH_SHORT).show();
			gListener = new GesturesListener(getApplicationContext());
			break;
		case Gestures.THREE_FINGERS_UP:
			Toast.makeText(this, "Three fingers up", Toast.LENGTH_SHORT).show();
			gListener = new GesturesListener(getApplicationContext());
			break;
		case Gestures.THREE_FINGERS_DOWN:
			Toast.makeText(this, "Three fingers down", Toast.LENGTH_SHORT).show();
			gListener = new GesturesListener(getApplicationContext());
			break;
		case Gestures.THREE_FINGERS_RIGHT:
			Toast.makeText(this, "Three fingers right", Toast.LENGTH_SHORT).show();
			gListener = new GesturesListener(getApplicationContext());
			break;
		case Gestures.THREE_FINGERS_LEFT:
			Toast.makeText(this, "Three fingers left", Toast.LENGTH_SHORT).show();
			gListener = new GesturesListener(getApplicationContext());
			break;
		case Gestures.FOUR_FINGERS_UP:
			Toast.makeText(this, "Four fingers up", Toast.LENGTH_SHORT).show();
			gListener = new GesturesListener(getApplicationContext());
			break;
		case Gestures.FOUR_FINGERS_DOWN:
			Toast.makeText(this, "Four fingers down", Toast.LENGTH_SHORT).show();
			gListener = new GesturesListener(getApplicationContext());
			break;
		case Gestures.FOUR_FINGERS_RIGHT:
			Toast.makeText(this, "Four fingers right", Toast.LENGTH_SHORT).show();
			gListener = new GesturesListener(getApplicationContext());
			break;
		case Gestures.FOUR_FINGERS_LEFT:
			Toast.makeText(this, "Four fingers left", Toast.LENGTH_SHORT).show();
			gListener = new GesturesListener(getApplicationContext());
			break;
		case Gestures.FIVE_FINGERS_UP:
			Toast.makeText(this, "Five fingers up", Toast.LENGTH_SHORT).show();
			gListener = new GesturesListener(getApplicationContext());
			break;
		case Gestures.FIVE_FINGERS_DOWN:
			Toast.makeText(this, "Five fingers down", Toast.LENGTH_SHORT).show();
			gListener = new GesturesListener(getApplicationContext());
			break;
		case Gestures.FIVE_FINGERS_RIGHT:
			Toast.makeText(this, "Five fingers right", Toast.LENGTH_SHORT).show();
			gListener = new GesturesListener(getApplicationContext());
			break;
		case Gestures.FIVE_FINGERS_LEFT:
			Toast.makeText(this, "Five fingers left", Toast.LENGTH_SHORT).show();
			gListener = new GesturesListener(getApplicationContext());
			break;
		case Gestures.THREE_FINGERS_CATCH:
			Toast.makeText(this, "Three fingers catch", Toast.LENGTH_SHORT).show();
			gListener = new GesturesListener(getApplicationContext());
			break;
		case Gestures.FOUR_FINGERS_CATCH:
			Toast.makeText(this, "Four fingers catch", Toast.LENGTH_SHORT).show();
			gListener = new GesturesListener(getApplicationContext());
			break;
		case Gestures.FIVE_FINGERS_CATCH:
			Toast.makeText(this, "Five fingers catch", Toast.LENGTH_SHORT).show();
			gListener = new GesturesListener(getApplicationContext());
			break;
			}
		
		return super.dispatchTouchEvent(event);
	}

	@Override
	public boolean onTouch(View view, MotionEvent event) {
		// TODO Auto-generated method stub
		/*x = event.getX();
		y = event.getY();
		

		dspStat = (TextView) findViewById(R.id.preactstatus);
		actStatus = (TextView) findViewById(R.id.act_movement);
		actStatX = (TextView) findViewById(R.id.actx);
		actStatY = (TextView) findViewById(R.id.acty);
		dspStatX = (TextView) findViewById(R.id.dispx);
		dspStatY = (TextView) findViewById(R.id.dispy);
		
		dspStat.setText("TouchEvent is on Activity");
		//dspStatX.setText("X");
		//dspStatY.setText("Y");
		actStatX.setText("ACTX  " + x);
		actStatY.setText("ACTY  " + y);
		
		switch(event.getAction()){
		case MotionEvent.ACTION_DOWN:
			actStatus.setText("ACT Down");
			break;
		case MotionEvent.ACTION_MOVE:
			actStatus.setText("ACT Move");
			break;

		case MotionEvent.ACTION_UP:
			actStatus.setText("ACT Up");
			break;
		}
		*/
		return true;
	}

}
