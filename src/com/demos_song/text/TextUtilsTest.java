/**
 * 创建人：SongZhiyong
 * 创建时间：2013-2-22
 */
package com.demos_song.text;
import android.app.Activity;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.widget.TextView;
import com.demos_song.R;
/**
 * 
 * Android sdk自带textUtils测试学习
 * 
 * @author SongZhiyong
 * 
 */
public class TextUtilsTest extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_textutils);
		TextView text = (TextView) findViewById(R.id.tv_text_sample);
		TextPaint p = text.getPaint();
		String strTitle = "Moe, Joe, Isaac, Bethany, Cornelius, Charlie";
		TextUtils.isEmpty("");
		text.setText("是否为空" + TextUtils.isEmpty(strTitle) + "--可变参数字符串连接"
				+ TextUtils.concat(strTitle, "测试1", "测试2"));
	}
}
