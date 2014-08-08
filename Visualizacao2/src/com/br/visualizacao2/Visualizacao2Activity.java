package com.br.visualizacao2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Visualizacao2Activity extends Activity {
	
	public static String tamanhoFonte = "";
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.visualizacao2);
	}
	
	@Override
	public void onStart() {
		super.onStart();
		Button b = (Button) findViewById(R.id.tamanho_fonte);
		if (tamanhoFonte.isEmpty()) {
			b.setText("Tamanho da fonte [--]");
		} else {
			b.setText("Tamanho da fonte [" + tamanhoFonte + "]");
		}
	}
	
	public void selecionarTamanhoDaFonte(View v){
		System.out.println("Selecionar tamanho da fonte!");
		startActivity(new Intent(this,TamanhoDaFonteActivity.class));
	}
	
	public void selecionarCorDaFonte(View v){
		System.out.println("Selecionar cor da fonte!");
		//startActivity(new Intent(this,CorDaFonteActivity.class));
	}
	
	public void selecionarCorDoFundo(View v){
		System.out.println("Selecionar cor do fundo!");
		//startActivity(new Intent(this,CorDoFundoActivity.class));
	}
	
	public void selecionarCorDaFonteDestacado(View v){
		System.out.println("Selecionar cor da fonte destacado!");
		//startActivity(new Intent(this,CorDaFonteDestacadoActivity.class));
	}
	
	public void selecionarCorDoFundoDestacado(View v){
		System.out.println("Selecionar cor do fundo destacado!");
		//startActivity(new Intent(this,CorDoFundoDestacadoActivity.class));
	}

}
