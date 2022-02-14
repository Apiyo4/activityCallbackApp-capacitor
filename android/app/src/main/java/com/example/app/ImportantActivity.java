package com.example.app;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ImportantActivity extends AppCompatActivity implements View.OnClickListener{
    private Button start, stop;
    Intent intent = new Intent();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_important);
        start = findViewById(R.id.btnDbl);
        stop = findViewById(R.id.btnTrp);
        start.setOnClickListener(this);
        stop.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        if(view==start){
            intent.putExtra("numberOperation", "doubleNumber");
            setResult(RESULT_OK, intent);
            finish();
            getApplicationContext().stopService(new Intent( this, BtnClickedService.class));
//            getApplicationContext().stopService(new Intent( this, ImportantActivity.class));
        }else if(view == stop){
            intent.putExtra("numberOperation", "tripleNumber");
            setResult(RESULT_OK, intent);
            finish();
            getApplicationContext().stopService(new Intent( this, BtnClickedService.class));
//            getApplicationContext().stopService(new Intent( this, ImportantActivity.class));
        }
    }
}
