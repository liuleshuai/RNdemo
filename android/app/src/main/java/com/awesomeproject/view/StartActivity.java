package com.awesomeproject.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.awesomeproject.R;
import com.awesomeproject.rn.RNActivity;

public class StartActivity extends AppCompatActivity implements View.OnClickListener {

    Button button1, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        button1 = (Button) findViewById(R.id.button_activity);
        button2 = (Button) findViewById(R.id.button_fragment);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_activity:
                startActivity(new Intent(StartActivity.this, RNActivity.class));
                break;
            case R.id.button_fragment:
                startActivity(new Intent(StartActivity.this, Main2Activity.class));
                break;
            default:
                break;
        }
    }
}
