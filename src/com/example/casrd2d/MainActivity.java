package com.example.casrd2d;

import java.sql.RowId;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class MainActivity extends Activity {

	private ImageView img1, img2;
	private ScaleAnimation scto0 = new ScaleAnimation(1, 0, 1, 1, Animation.RELATIVE_TO_PARENT, 0.5f,
			Animation.RELATIVE_TO_PARENT, 0.5f);
	private ScaleAnimation scto1 = new ScaleAnimation(0, 1, 1, 1, Animation.RELATIVE_TO_PARENT, 0.5f,
			Animation.RELATIVE_TO_PARENT, 0.5f);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initView();
		findViewById(R.id.root).setOnClickListener(new FrameLayout.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (img1.getVisibility() == View.VISIBLE) {
					img1.startAnimation(scto0);
				}else {
					img2.startAnimation(scto0);
				}
			}
		});

	}

	public void showImg1() {
		img1.setVisibility(View.VISIBLE);
		img2.setVisibility(View.INVISIBLE);
	}

	public void showImg2() {
		img1.setVisibility(View.INVISIBLE);
		img2.setVisibility(View.VISIBLE);
	}

	public void initView() {
		img1 = (ImageView) findViewById(R.id.img1);
		img2 = (ImageView) findViewById(R.id.img2);
		showImg1();
		scto0.setDuration(500);
		scto1.setDuration(500);
		
		scto0.setAnimationListener(new Animation.AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationEnd(Animation animation) {
				// TODO Auto-generated method stub
				if (img1.getVisibility() == View.VISIBLE) {
					img1.setAnimation(null);
					showImg2();
					img2.startAnimation(scto1);
				} else {
					img2.setAnimation(null);
					showImg1();
					img1.startAnimation(scto1);
				}
			}
		});
	}
}
