package com.demos_song.web;

import java.io.IOException;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.webkit.WebView;

import com.demos_song.R;

public class WebViewActivity extends Activity {
	private WebView webview = null;
	private MediaPlayer player;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_web_view);
		player = new MediaPlayer();
		webview = (WebView) super.findViewById(R.id.webview);
		webview.getSettings().setJavaScriptEnabled(true); // 启用JavaScript
		webview.getSettings().setBuiltInZoomControls(true); // 控制页面缩放
		webview.addJavascriptInterface(new PlayerMethod(), "player");
		webview.loadUrl("file:///android_asset/html/play_js.html");
	}

	class PlayerMethod {
		Handler handler = new Handler() {
			public void handleMessage(android.os.Message msg) {
				try {
					playUrl();
				} catch (IOException e) {
					e.printStackTrace();
				}
			};
		};

		public void play() {
			handler.sendEmptyMessage(0);
		}

		private void playUrl() throws IOException {
			if (player.isPlaying()) {
				player.stop();
			}
			player.reset();
			player.setDataSource("http://218.75.215.19:9998/zzgps/swf/task/notes.mp3");
			player.prepare();
			player.start();
		}
	}
}
