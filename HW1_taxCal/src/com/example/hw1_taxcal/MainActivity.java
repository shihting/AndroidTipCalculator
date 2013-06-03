package com.example.hw1_taxcal;



import java.math.BigDecimal;
import android.os.Bundle;
import android.app.Activity;
import android.util.SparseArray;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity {
	SparseArray<Double> tipMap = new SparseArray<Double>();
	TextView inputPriceView;
	TextView tipView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tipMap.put(R.id.tax10, 0.1);
		tipMap.put(R.id.tax15, 0.15);
		tipMap.put(R.id.tax20, 0.2);
		
		inputPriceView = (TextView)findViewById(R.id.priceText);
		tipView = (TextView)findViewById(R.id.tip);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	public void calTip(View v){
		String outputText = "tip is : unknow";
		String inputText = inputPriceView.getText().toString();
		if (inputText.equals("") == false && inputText.equals(".") == false) {
			Double inputPrice = Double.parseDouble(inputText);
			Button clickedButton = (Button)v;
			Double tip = tipMap.get(clickedButton.getId()) * inputPrice;
			
			BigDecimal bd= new BigDecimal(tip);   
			bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
			outputText = "tip is : " + String.valueOf(bd);
		}  
		tipView.setText(outputText);		
		
	}

}
