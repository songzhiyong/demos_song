package com.demos_song.graphics;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.aphidmobile.flip.FlipViewController;
import com.demos_song.R;
import com.demos_song.widgets.NumberTextView;
/**
 * 折纸翻牌效果
 * 
 * @author SongZhiyong
 * 
 */
public class FlipTextViewActivity extends Activity {
	public static final String TAG = "FlipTextViewActivity";
	protected FlipViewController flipView;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle(TAG);
		flipView = new FlipViewController(this, FlipViewController.HORIZONTAL);
		flipView.setAdapter(new BaseAdapter() {
			public int getCount() {
				return 10;
			}
			public Object getItem(int position) {
				return position;
			}
			public long getItemId(int position) {
				return position;
			}
			public View getView(int position, View convertView, ViewGroup parent) {
				NumberTextView view;
				if (convertView == null) {
					final Context context = parent.getContext();
					view = new NumberTextView(context, position);
					view.setTextSize(context.getResources().getDimension(R.dimen.flipTextSize));
				} else {
					view = (NumberTextView) convertView;
					view.setNumber(position);
				}
				return view;
			}
		});
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
