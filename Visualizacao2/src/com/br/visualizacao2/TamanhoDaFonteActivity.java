package com.br.visualizacao2;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Display;
import android.widget.Button;
import android.widget.TextView;

public class TamanhoDaFonteActivity extends Activity {
	
	private String[] tamanhos = {"10","20","30","40","50"};
	private int i = 0;
	private TextView tv;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.seletor);
		Display disp = getWindowManager().getDefaultDisplay();
		Point sz = new Point();
		disp.getSize(sz);
		int width = sz.x;
		tv = (TextView) findViewById(R.id.valor);
		tv.setText(tamanhos[i]);
		tv.setTextSize(TypedValue.COMPLEX_UNIT_PX, (float)(width*0.3));
		tv.setOnTouchListener(new SwipeLeftOrRightListener(this){
			@Override
			public void onSwipeLeft(){
				if (i == tamanhos.length - 1) {
					i = 0;
				} else {
					i++;
				}
				tv.setText(tamanhos[i]);
			}
			@Override
			public void onSwipeRight(){
				if (i == 0) {
					i = tamanhos.length - 1;
				} else {
					i--;
				}
				tv.setText(tamanhos[i]);
			}
			@Override
			public void setValue(){
				finish();
				Visualizacao2Activity.tamanhoFonte = tamanhos[i];
			}
		});
	}

}
