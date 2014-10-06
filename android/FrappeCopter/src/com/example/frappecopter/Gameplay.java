package com.example.frappecopter;

import com.example.frappecopter.util.SystemUiHider;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;


public class Gameplay extends Activity {
	
	// Instantiate GameView to control gameplay
	GameView game;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_gameplay);
		
		game = (GameView)findViewById(R.id.view1);

		// Get speed passed from instructions activity
		game.set_speed(getIntent().getIntExtra("speed", 1));
		
	}


}

