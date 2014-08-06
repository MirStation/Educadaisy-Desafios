package com.br.visualizacao;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

public class VisualizacaoActivity extends Activity {
	
	private Spinner tamanhoFonte;
	private Spinner corFonte;
	private Spinner corFonteDestacado;
	private Spinner corFundo;
	private Spinner corFundoDestacado;
	private Spannable spanText;
	
	private OnItemSelectedListener fonteListener = new OnItemSelectedListener() {

		@Override
		public void onItemSelected(AdapterView<?> parent, View view, int position,
				long id) {
			TextView tv = (TextView) findViewById(R.id.exemplo_texto);
			Object item = parent.getItemAtPosition(position);
			tv.setTextSize(Float.parseFloat(item.toString()));
			System.out.println("fonte-input: " + Float.parseFloat(item.toString()));
		}

		@Override
		public void onNothingSelected(AdapterView<?> parent) {
			// TODO Auto-generated method stub
			
		}
	
	};
	
	private OnItemSelectedListener corFonteListener = new OnItemSelectedListener() {

		@Override
		public void onItemSelected(AdapterView<?> parent, View view, int position,
				long id) {
			TextView tv = (TextView) findViewById(R.id.exemplo_texto);
//			TextView tvs = (TextView) findViewById(R.id.exemplo_texto_destacado);
			Object item = parent.getItemAtPosition(position);
			switch (item.toString()) {
			case "vermelho":
				tv.setTextColor(getResources().getColor(R.color.vermelho));
//				tvs.setTextColor(getResources().getColor(R.color.vermelho));
				break;
			case "verde":
				tv.setTextColor(getResources().getColor(R.color.verde));
//				tvs.setTextColor(getResources().getColor(R.color.verde));
				break;
			case "azul":
				tv.setTextColor(getResources().getColor(R.color.azul));
//				tvs.setTextColor(getResources().getColor(R.color.azul));
				break;
			case "preto":
				tv.setTextColor(getResources().getColor(R.color.preto));
//				tvs.setTextColor(getResources().getColor(R.color.preto));
				break;
			case "branco":
				tv.setTextColor(getResources().getColor(R.color.branco));
//				tvs.setTextColor(getResources().getColor(R.color.branco));
				break;
			default:
				System.out.println("Cor de fonte inválida!");
				break;
			}
			System.out.println("cor-fonte-input: " + item.toString());
		}

		@Override
		public void onNothingSelected(AdapterView<?> parent) {
			// TODO Auto-generated method stub
			
		}
	
	};
	
	private OnItemSelectedListener corFundoListener = new OnItemSelectedListener() {

		@Override
		public void onItemSelected(AdapterView<?> parent, View view, int position,
				long id) {
			ScrollView sv = (ScrollView) findViewById(R.id.exemplo);
			Object item = parent.getItemAtPosition(position);
			switch (item.toString()) {
			case "vermelho":
				sv.setBackgroundColor(getResources().getColor(R.color.vermelho));
				break;
			case "verde":
				sv.setBackgroundColor(getResources().getColor(R.color.verde));
				break;
			case "azul":
				sv.setBackgroundColor(getResources().getColor(R.color.azul));
				break;
			case "preto":
				sv.setBackgroundColor(getResources().getColor(R.color.preto));
				break;
			case "branco":
				sv.setBackgroundColor(getResources().getColor(R.color.branco));
				break;
			default:
				System.out.println("Cor de fundo inválida!");
				break;
			}
			System.out.println("cor-fundo-input: " + item.toString());
		}
		
		@Override
		public void onNothingSelected(AdapterView<?> parent) {
			// TODO Auto-generated method stub
			
		}
	
	};
	
	private OnItemSelectedListener corFonteDestacadoListener = new OnItemSelectedListener() {

		@Override
		public void onItemSelected(AdapterView<?> parent, View view, int position,
				long id) {
			TextView tv = (TextView) findViewById(R.id.exemplo_texto);
			Object item = parent.getItemAtPosition(position);
			switch (item.toString()) {
			case "amarelo":
				spanText.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.amarelo)), tv.getText().toString().indexOf(" E"), tv.getText().length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
				break;
			case "azul marinho":
				spanText.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.azulmarinho)), tv.getText().toString().indexOf(" E"), tv.getText().length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
				break;
			case "violeta":
				spanText.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.violeta)), tv.getText().toString().indexOf(" E"), tv.getText().length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
				break;
			case "cinzento":
				spanText.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.cinzento)), tv.getText().toString().indexOf(" E"), tv.getText().length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
				break;
			default:
				System.out.println("Cor de fonte destacada inválida!");
				break;
			}
			tv.setText(spanText);
			System.out.println("cor-fonte-destacada-input: " + item.toString());
		}
		
		@Override
		public void onNothingSelected(AdapterView<?> parent) {
			// TODO Auto-generated method stub
		}
	
	};
	
	private OnItemSelectedListener corFundoDestacadoListener = new OnItemSelectedListener() {

		@Override
		public void onItemSelected(AdapterView<?> parent, View view, int position,
				long id) {
			TextView tv = (TextView) findViewById(R.id.exemplo_texto);
			Object item = parent.getItemAtPosition(position);
			switch (item.toString()) {
			case "amarelo":
				spanText.setSpan(new BackgroundColorSpan(getResources().getColor(R.color.amarelo)), tv.getText().toString().indexOf(" E"), tv.getText().length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
				break;
			case "azul marinho":
				spanText.setSpan(new BackgroundColorSpan(getResources().getColor(R.color.azulmarinho)), tv.getText().toString().indexOf(" E"), tv.getText().length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
				break;
			case "violeta":
				spanText.setSpan(new BackgroundColorSpan(getResources().getColor(R.color.violeta)), tv.getText().toString().indexOf(" E"), tv.getText().length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
				break;
			case "cinzento":
				spanText.setSpan(new BackgroundColorSpan(getResources().getColor(R.color.cinzento)), tv.getText().toString().indexOf(" E"), tv.getText().length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
				break;
			default:
				System.out.println("Cor de fundo destacada inválida!");
				break;
			}
			tv.setText(spanText);
			System.out.println("cor-fundo-destacada-input: " + item.toString());
		}
		
		@Override
		public void onNothingSelected(AdapterView<?> parent) {
			// TODO Auto-generated method stub
		}
	
	};	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.visualizacao);
		
		ArrayAdapter<CharSequence> adapter;
		
		adapter = ArrayAdapter.createFromResource(this, R.array.categoria_tamanho_fonte,android.R.layout.simple_spinner_item);
		tamanhoFonte = (Spinner) findViewById(R.id.tamanho_fonte);
		tamanhoFonte.setAdapter(adapter);
		tamanhoFonte.setOnItemSelectedListener(fonteListener);
		
		adapter = ArrayAdapter.createFromResource(this, R.array.categoria_cor_fonte,android.R.layout.simple_spinner_item);
		corFonte = (Spinner) findViewById(R.id.cor_fonte);
		corFonte.setAdapter(adapter);
		corFonte.setOnItemSelectedListener(corFonteListener);
		
		adapter = ArrayAdapter.createFromResource(this, R.array.categoria_cor_fundo,android.R.layout.simple_spinner_item);
		corFundo = (Spinner) findViewById(R.id.cor_fundo);
		corFundo.setAdapter(adapter);
		corFundo.setOnItemSelectedListener(corFundoListener);
		
		adapter = ArrayAdapter.createFromResource(this, R.array.categoria_cor_fonte_destacado,android.R.layout.simple_spinner_item);
		corFonteDestacado = (Spinner) findViewById(R.id.cor_fonte_destacado);
		corFonteDestacado.setAdapter(adapter);
		corFonteDestacado.setOnItemSelectedListener(corFonteDestacadoListener);
		
		adapter = ArrayAdapter.createFromResource(this, R.array.categoria_cor_fundo_destacado,android.R.layout.simple_spinner_item);
		corFundoDestacado = (Spinner) findViewById(R.id.cor_fundo_destacado);
		corFundoDestacado.setAdapter(adapter);
		corFundoDestacado.setOnItemSelectedListener(corFundoDestacadoListener);
		
		TextView tv = (TextView) findViewById(R.id.exemplo_texto);
		spanText = Spannable.Factory.getInstance().newSpannable(tv.getText());
		spanText.setSpan(new BackgroundColorSpan(0xFFFFFF00), tv.getText().toString().indexOf(" E"), tv.getText().length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		spanText.setSpan(new ForegroundColorSpan(Color.GREEN), tv.getText().toString().indexOf(" E"), tv.getText().length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		tv.setText(spanText);
	}

}
