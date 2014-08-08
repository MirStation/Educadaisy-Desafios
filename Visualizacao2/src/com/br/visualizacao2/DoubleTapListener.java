package com.br.visualizacao2;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.View.OnTouchListener;

public class DoubleTapListener implements OnTouchListener {

	private GestureDetector gestureDetector;

    public DoubleTapListener(Context context) {
        gestureDetector = new GestureDetector(context, new GestureListener());
    }

    public void setValue() {
    }

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		return gestureDetector.onTouchEvent(event);
	}
	
	private final class GestureListener extends SimpleOnGestureListener {

        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }
        
        @Override
        public boolean onDoubleTap(MotionEvent e) {
        	setValue();
        	return true;
        }
    }

}
