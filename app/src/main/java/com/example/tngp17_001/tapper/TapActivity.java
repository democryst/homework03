package com.example.tngp17_001.tapper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.InvalidPropertiesFormatException;

public class TapActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView value_text;
    private ImageButton coin_btn;

    int goal_val;
    int count = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tap);

        Intent intent = getIntent();
        goal_val = intent.getIntExtra("goal_value", 0);

        value_text = (TextView)findViewById(R.id.box_in_text);
        coin_btn = (ImageButton) findViewById(R.id.coin_btn);
        coin_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == coin_btn){
            count = count + 1;

            if (count > goal_val){
                count = 0;
                super.onBackPressed();
            }else{
                try{
                    value_text.setText(count+"");
                }catch (NullPointerException npe){
                    Log.d("setText fail", "NullPointerException: "+npe);
                }catch (Exception e){
                    Log.d("Exception", "event : "+e);
                }
            }

        }

    }
}
