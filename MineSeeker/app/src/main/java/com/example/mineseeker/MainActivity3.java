package com.example.mineseeker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity3 extends AppCompatActivity {
    private Button playbutton;
    private Button optionButton;
    private Button helpButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        playbutton=(Button)findViewById(R.id.play);
        playbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openPlayActivity();
            }

        });
        optionButton=(Button)findViewById(R.id.option);
        optionButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openOptionActivity();
            }

        });
        helpButton=(Button)(findViewById((R.id.help)));
        helpButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                openHelpActivity();
            }
        });
    }
    public void openHelpActivity(){
        Intent intent=new Intent(this, MainActivity4.class);
        startActivity(intent);
    }
    public void openOptionActivity(){
        Intent intent=new Intent(this, MainActivity5.class);
        startActivity(intent);

    }
    public void openPlayActivity(){

        Intent intent=new Intent(this, MainActivity2.class);
        startActivity(intent);
    }

}