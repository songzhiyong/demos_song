package com.demos_song.text;
import java.io.InputStream;
import java.net.URL;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import com.jerome.basebeans.BaseActivity;
/**
 * 多样文本
 * 
 * @author SongZhiyong
 * 
 */
public class HtmlText extends BaseActivity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		TextView textview = new TextView(this);
		setContentView(textview);
		String htmlText = "<font color='red' size='20px'>Hello</font><br/>";
		htmlText += "<font color='#44ccff' size='20px'><a href='http://www.baidu.com'>百度</a></font><br />";
		htmlText += "<a href='http://weibo.com/zhiyongs'><img src='http://tp3.sinaimg.cn/1604928822/180/5651681490/1' /></a>";
		Spanned sp = Html.fromHtml(htmlText, new Html.ImageGetter() {
			public Drawable getDrawable(String source) {
				InputStream is = null;
				try {
					is = (InputStream) new URL(source).getContent();
					Drawable d = Drawable.createFromStream(is, "src");
					d.setBounds(0, 0, d.getIntrinsicWidth(), d.getIntrinsicHeight());
					is.close();
					return d;
				} catch (Exception e) {
					return null;
				}
			}
		}, null);
		textview.setText(sp);
		textview.setMovementMethod(LinkMovementMethod.getInstance());
	}
}
