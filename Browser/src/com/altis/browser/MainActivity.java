package com.altis.browser;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {
	final int upcode = KeyEvent.KEYCODE_E;
	final int rightcode = KeyEvent.KEYCODE_R;
	final int leftcode = KeyEvent.KEYCODE_D;
	final int bottomcode = KeyEvent.KEYCODE_F;
	final int scroll_x = 0;
	final int scroll_y = 100;
	WebView  myWebView;

	@SuppressLint("SetJavaScriptEnabled")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//レイアウトで指定したWebViewのIDを指定する。
		myWebView = (WebView)findViewById(R.id.webView);
		 
		//リンクをタップしたときに標準ブラウザを起動させない
		myWebView.setWebViewClient(new WebViewClient());
		 
		//最初にYahoo! Japanのページを表示する。
		myWebView.loadUrl("http://www.yahoo.co.jp/");
		
		//jacascriptを許可する
		myWebView.getSettings().setJavaScriptEnabled(true);
	}

	@Override
	public boolean dispatchKeyEvent(KeyEvent e) {
	 
	   // DOWNとUPが取得できるのでログの2重表示防止のためif
		/*
	   if (e.getAction() == KeyEvent.ACTION_DOWN) {
	       //キーコード表示
	       Log.d("KeyCode","KeyCode:"+ e.getKeyCode());
	   }*/
		switch (e.getKeyCode()) {
		case upcode:
			if (e.getAction() == KeyEvent.ACTION_DOWN) {
				myWebView.pageUp(false);
				Log.d("KeyCode","KeyCode:"+ e.getKeyCode());
				return true;
		}
		case bottomcode:
			if (e.getAction() == KeyEvent.ACTION_DOWN) {
				myWebView.pageDown(false);
				Log.d("KeyCode","KeyCode:"+ e.getKeyCode());
				return true;
			}
		}
	 
	   return super.dispatchKeyEvent(e);
	}
	public boolean onKeyUp(int keyCode, KeyEvent event) {
		//keyCodeはハンドルしたキーを特定するための数値
		//eventにはイベント関連情報が入っています。ここではeventは利用しません。
		switch (keyCode) {
		case upcode:
			myWebView.pageUp(false);
			break;
		case rightcode:
			break;
		case bottomcode:
			myWebView.pageDown(false);
			break;
		case leftcode:
			break;
		default:
			break;
		}
		return true;
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
