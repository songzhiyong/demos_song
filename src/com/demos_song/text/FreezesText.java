/**
 * 创建人：SongZhiyong
 * 创建时间：2013-1-11
 */
package com.demos_song.text;
import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import com.demos_song.R;
/**
 * 文本锁定
 * 
 * @author SongZhiyong
 * 
 */
public class FreezesText extends Activity implements TextWatcher {
	public static final String TAG = "FreezesText";
	private EditText etFreezesText;
	private TextView tvNum;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_freezestext);
		initView();
	}
	private void initView() {
		etFreezesText = (EditText) findViewById(R.id.et_freezestext);
		tvNum = (TextView) findViewById(R.id.tv_num_indicate);
		etFreezesText.setSelection(etFreezesText.getText().length());
		etFreezesText.addTextChangedListener(this);
	}
	public void beforeTextChanged(CharSequence s, int start, int count, int after) {
	}
	public void onTextChanged(CharSequence s, int start, int before, int count) {
	}
	public void afterTextChanged(Editable s) {
		tvNum.setText(String.valueOf(100 - s.length()));
	}
}
