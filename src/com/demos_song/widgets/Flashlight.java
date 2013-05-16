/**
 * 创建人：SongZhiyong
 * 创建时间：2013-2-20
 */
package com.demos_song.widgets;
import android.app.Activity;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ToggleButton;

import com.demos_song.R;

/**
 * 闪光灯控制
 * 
 * @author SongZhiyong
 * 
 */
public class Flashlight extends Activity implements OnClickListener {
	Camera camera;
	Parameters parameters;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_flashlight);
		initListener();
	}
	/**
	 * 初始化监听器
	 */
	private void initListener() {
		((ToggleButton) findViewById(R.id.tb_flashlight)).setOnClickListener(this);
	}
	private void flashLightOn() {
		camera = Camera.open();
		parameters = camera.getParameters();
		parameters.setFlashMode(Parameters.FLASH_MODE_TORCH);
		camera.setParameters(parameters);
	}
	private void flashLightOff() {
		parameters.setFlashMode(Parameters.FLASH_MODE_OFF);
		camera.setParameters(parameters);
		camera.release();
	}
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.tb_flashlight:
			if (((ToggleButton) v).isChecked()) {
				flashLightOn();
			} else {
				flashLightOff();
			}
			break;
		default:
			break;
		}
	}
}
