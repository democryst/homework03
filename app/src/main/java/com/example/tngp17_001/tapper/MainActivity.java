package com.example.tngp17_001.tapper;

import android.app.ActionBar;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText input_text;
    ImageView playbtn;
    int value_f;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = getIntent();
        initialize();


    }

    void initialize(){
        input_text = (EditText) findViewById(R.id.box_in_text);
        input_text.setText("");
        playbtn = (ImageView) findViewById(R.id.playbtn);

        playbtn.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v == playbtn){
//            Toast.makeText(MainActivity.this, "Click", Toast.LENGTH_LONG).show();
            try{
                value_f = Integer.parseInt(input_text.getText().toString());
            }catch (NumberFormatException nfe){
                Log.d("parseInt", "cast fail :"+nfe);
            }

            if(value_f != 0){
                Intent intent = new Intent(MainActivity.this, TapActivity.class);
                intent.putExtra("goal_value", value_f);
                startActivity(intent);
            }
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        value_f = 0;
        input_text.setText("");
    }
}
