/**
 * 创建人：SongZhiyong
 * 创建时间：2013-1-8
 */
package com.demos_song.graphics;

import android.R;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * 手写画板
 * 
 * @author SongZhiyong
 * 
 */
public class TouchDraw extends Activity implements OnTouchListener {
	public static final String TAG = "TouchDraw";
	ImageView ivTouch;
	Bitmap bitmap;
	Canvas canvas;
	Paint paint;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_touchdraw);
		initView();
		initData();
		initListener();
	}

	/**
	 * 
	 */
	private void initView() {
		ivTouch = (ImageView) findViewById(R.id.iv_touch);
		bitmap = Bitmap.createBitmap(getWindowManager().getDefaultDisplay()
				.getWidth(),
				getWindowManager().getDefaultDisplay().getHeight(),
				Config.ARGB_8888);
		canvas = new Canvas(bitmap);
		paint = new Paint();
		paint.setStyle(Style.FILL);
		paint.setColor(Color.RED);
		paint.setAntiAlias(true);
		paint.setDither(true);
		paint.setShadowLayer(2, 5, 5, Color.BLUE);
		paint.setStrokeWidth(10);
		ivTouch.setImageBitmap(bitmap);
	}

	/**
	 * 
	 */
	boolean isClear;

	@Override
	public void onBackPressed() {
		if (isClear) {
			super.onBackPressed();
		} else {
			Toast.makeText(this, getString(R.string.clear), Toast.LENGTH_SHORT)
					.show();
			initView();
			isClear = true;
		}
	}

	private void initData() {
	}

	/**
	 * 
	 */
	private void initListener() {
		ivTouch.setOnTouchListener(this);
	}

	float downX;
	float downY;
	float upX;
	float upY;

	public boolean onTouch(View v, MotionEvent event) {
		int action = event.getAction();
		switch (action) {
		case MotionEvent.ACTION_DOWN:
			isClear = false;
			downX = event.getX();
			downY = event.getY();
			break;
		case MotionEvent.ACTION_UP:
			upX = event.getX();
			upY = event.getY();
			canvas.drawLine(downX, downY, upX, upY, paint);
			ivTouch.invalidate();
			break;
		case MotionEvent.ACTION_MOVE:
			upX = event.getX();
			upY = event.getY();
			canvas.drawLine(downX, downY, upX, upY, paint);
			ivTouch.invalidate();
			downX = upX;
			downY = upY;
			break;
		case MotionEvent.ACTION_CANCEL:
			break;
		default:
			break;
		}
		return true;
	}
}
