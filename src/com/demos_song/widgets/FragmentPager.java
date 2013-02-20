/**
 * 创建人：SongZhiyong
 * 创建时间：2013-1-14
 */
package com.demos_song.widgets;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.ListFragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.demos_song.R;
import com.demos_song.data.Cheeses;
/**
 * FragmentPager
 * 
 * @author SongZhiyong
 * 
 */
public class FragmentPager extends FragmentActivity {
	private final int ITEM_COUNT = 5;
	private ViewPager mViewPager;
	private CustomAdapter mAdapter;
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.layout_fragmentpager);
		mViewPager = (ViewPager) findViewById(R.id.vp_fragments);
		mAdapter = new CustomAdapter(getSupportFragmentManager());
		mViewPager.setAdapter(mAdapter);
	}
	class CustomAdapter extends FragmentPagerAdapter {
		public CustomAdapter(FragmentManager fm) {
			super(fm);
		}
		@Override
		public Fragment getItem(int pos) {
			return ArrayListFragment.newInstance(pos);
		}
		@Override
		public int getCount() {
			return ITEM_COUNT;
		}
	}
	static class ArrayListFragment extends ListFragment {
		static ArrayListFragment newInstance(int num) {
			ArrayListFragment f = new ArrayListFragment();
			Bundle args = new Bundle();
			args.putInt("num", num);
			f.setArguments(args);
			return f;
		}
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			return super.onCreateView(inflater, container, savedInstanceState);
		}
		@Override
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setListAdapter(new ArrayAdapter<String>(getActivity(),
					android.R.layout.simple_list_item_1, Cheeses.sCheeseStrings));
		}
	}
}
