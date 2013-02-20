/**
 * 创建人：SongZhiyong
 * 创建时间：2013-2-20
 */
package com.demos_song.graphics;
import android.app.Activity;
import android.os.Bundle;
import com.aphidmobile.flip.FlipViewController;
/**
 * 折叠翻页图片
 * 
 * @author SongZhiyong
 * 
 */
public class FlipImageViewActivity extends Activity {
	public static final String TAG = "FlipImageViewActivity";
	protected FlipViewController flipView;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle(TAG);
		flipView = new FlipViewController(this);
		flipView.setAdapter(new TravelAdapter(this));
		setContentView(flipView);
	}
	protected void onResume() {
		super.onResume();
		flipView.onResume();
	}
	protected void onPause() {
		super.onPause();
		flipView.onPause();
	}
}
