package com.demos_song.graphics;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.aphidmobile.utils.AphidLog;
import com.aphidmobile.utils.IO;
import com.aphidmobile.utils.UI;
import com.demos_song.R;
import com.demos_song.data.Travels;
/**
 * 
 * @author SongZhiyong
 * 
 */
public class TravelAdapter extends BaseAdapter {
	private LayoutInflater inflater;
	private int repeatCount = 1;
	public TravelAdapter(Context context) {
		inflater = LayoutInflater.from(context);
	}
	public int getCount() {
		return Travels.IMG_DESCRIPTIONS.size() * repeatCount;
	}
	public int getRepeatCount() {
		return repeatCount;
	}
	public void setRepeatCount(int repeatCount) {
		this.repeatCount = repeatCount;
	}
	public Object getItem(int position) {
		return position;
	}
	public long getItemId(int position) {
		return position;
	}
	public View getView(int position, View convertView, ViewGroup parent) {
		View layout = convertView;
		if (convertView == null) {
			layout = inflater.inflate(R.layout.item_flipimage, null);
			layout.setBackgroundColor(Color.GRAY);
			AphidLog.d("created new view from adapter: %d", position);
		}
		final Travels.Data data = Travels.IMG_DESCRIPTIONS.get(position
				% Travels.IMG_DESCRIPTIONS.size());
		UI.<ImageView> findViewById(layout, R.id.iv_flipimage).setImageBitmap(
				IO.readBitmap(inflater.getContext().getAssets(), data.imageFilename));
		return layout;
	}
}
