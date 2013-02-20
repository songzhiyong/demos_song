/**
 * 创建人：SongZhiyong
 * 创建时间：2013-1-10
 */
package com.demos_song.anims;
import android.app.Activity;
import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.widget.ViewFlipper;
import com.demos_song.R;
/**
 * @author SongZhiyong
 * 
 */
public class ViewFlipperDemos extends Activity {
	public static final String TAG = "ViewFlipperDemos";
	private ViewFlipper vpAds;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_viewflipper);
		initView();
	}
	private void initView() {
		vpAds = (ViewFlipper) findViewById(R.id.vp_ads);
		vpAds.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.push_up_out));
		vpAds.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.push_up_in));
		vpAds.startFlipping();
	}
}
