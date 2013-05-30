package com.demos_song;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.R.anim;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.jerome.utils.Start;

public class Demos extends Activity implements OnItemClickListener {
	public static final String TAG = "Demos";
	private ListView lvDemos;
	private ArrayAdapter<CharSequence> adapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_demos);
		initView();
		initData();
		initListener();
	}

	/**
	 * 
	 */
	private void initView() {
		lvDemos = (ListView) findViewById(R.id.lv_demos);
	}

	/**
	 * 
	 */
	private ArrayList<CharSequence> demoNames;
	private List<CharSequence> demosList;

	private void initData() {
		demosList = Arrays.asList(getResources().getTextArray(
				R.array.demos_list));
		demoNames = new ArrayList<CharSequence>();
		for (CharSequence charSequence : demosList) {
			demoNames.add(charSequence.toString().substring(
					charSequence.toString().lastIndexOf(".") + 1));
		}
		adapter = new ArrayAdapter<CharSequence>(this,
				android.R.layout.simple_list_item_1, demoNames);
		lvDemos.setAdapter(adapter);
	}

	/**
	 * 
	 */
	private void initListener() {
		lvDemos.setOnItemClickListener(this);
	}

	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		String className = demosList.get(position).toString();
		Class<?> cls = null;
		try {
			cls = Class.forName(className);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		// 左侧进入
		// Start.start(this, cls, R.anim.slide_in_from_left,
		// R.anim.slide_out_to_right);
		// 右侧进入
		// Start.start(this, cls, R.anim.slide_in_from_right,
		// R.anim.slide_out_to_left);
		// 渐变进入
		// Start.start(this, cls, android.R.anim.fade_in,
		// android.R.anim.fade_out);
		// 下侧冒入
		// Start.start(this, cls, R.anim.slide_in_from_top,
		// R.anim.slide_out_to_bottom);

		// Start.start(this, cls, R.anim.hyperspace_in, R.anim.hyperspace_out);
		// 放大进入缩小退出
		Start.start(this, cls, R.anim.zoom_enter, R.anim.zoom_exit);

	}
}
