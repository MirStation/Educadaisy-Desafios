package com.example.xmlparserv11;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;

public class MyScrollView extends ScrollView {

	private XMLParserV11 mainActivity;
	
	public MyScrollView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	public MyScrollView(Context context, AttributeSet attrs,
			int defStyle) {
		super(context, attrs, defStyle);
	}
 
	public MyScrollView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	protected void onScrollChanged(int l, int t, int oldl, int oldt) {
		View view = (View) getChildAt(getChildCount()-1);
		int diff = (view.getBottom()-(getHeight()+getScrollY()));
		if( diff == 0) {
			this.mainActivity.loadParagraphsBlock(1);
			
		}
		super.onScrollChanged(l, t, oldl, oldt);
	}
	
	public void setMainActivity(XMLParserV11 mainActivity) {
		this.mainActivity = mainActivity;
	}

}
