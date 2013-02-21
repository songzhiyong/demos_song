/**
 * 创建人：SongZhiyong
 * 创建时间：2013-2-21
 */
package com.demos_song.afinal;
import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.annotation.view.ViewInject;
import android.os.Bundle;
import android.widget.TextView;
import com.example.lib_song.R;
/**
 * 测试Afinal开源框架
 * 
 * @author SongZhiyong
 * 
 */
public class TestAfinalActivity extends FinalActivity {
	@ViewInject(id = R.id.tv_desc)
	TextView tvDesc;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_testfinal);
		tvDesc.setText("这是一个测试afinal框架的Activity");
	}
}
