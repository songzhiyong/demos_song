package com.demos_song.graphics;

import android.app.Activity;
import android.app.SearchManager.OnCancelListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

import com.demos_song.R;
import com.jerome.widget.DigitalView;

public class DigitalViewActivity extends Activity implements OnClickListener {
	private EditText edittext1;
	private EditText edittext2;

	private DigitalView mDigitalView;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.layout_digital);

		edittext1 = (EditText) findViewById(R.id.edittext1);
		edittext2 = (EditText) findViewById(R.id.edittext2);
		findViewById(R.id.button1).setOnClickListener(this);
		findViewById(R.id.button2).setOnClickListener(this);

		mDigitalView = (DigitalView) findViewById(R.id.digitial_view);
	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button1: {
			long target = Long.valueOf(edittext1.getText().toString());
			mDigitalView.setDigital(target);
			break;
		}
		case R.id.button2: {
			double target = Double.valueOf(edittext2.getText().toString());
			mDigitalView.setDigital(target);
			break;
		}
		}
	}
}
