package com.example.logonrm.tabuada;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    private TextView textNum1;
    private TextView textNum2;
    private EditText edtResp;
    private ImageView[] img = new ImageView[4];
    private int placar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sortear();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.textNum1 = (TextView) findViewById(R.id.textNum1);
        this.textNum2 = (TextView) findViewById(R.id.textNum2);
        this.edtResp = (EditText) findViewById(R.id.edtResposta);
        this.img[0] = (ImageView) findViewById(R.id.imgGarrafa0);
        this.img[1] = (ImageView) findViewById(R.id.imgGarrafa1);
        this.img[2] = (ImageView) findViewById(R.id.imgGarrafa2);
        this.img[3] = (ImageView) findViewById(R.id.imgGarrafa3);
        sortear();
    }
    public void conferir(View v) {
        int r = Integer.parseInt(this.edtResp.getText().toString());
        int nn1 = Integer.parseInt(this.textNum1.getText().toString());
        int nn2 = Integer.parseInt(this.textNum2.getText().toString());

        if(r == nn1 * nn2){
            img[placar].setImageResource(android.R.drawable.screen_background_light_transparent);
            placar++;
            img[placar].setImageResource(R.drawable.garrafa);
            if(placar == (img.length - 1)) {
                img[placar].setImageResource(android.R.drawable.screen_background_light_transparent);
                placar = 0;
                img[placar].setImageResource(R.drawable.garrafa);
            }
        }
        sortear();
    }

    private void sortear(){
        Random r = new Random();
        int nn1 = r.nextInt(9) + 1;
        int nn2 = r.nextInt(9) + 1;
        this.textNum1.setText(String.valueOf(nn1));
        this.textNum2.setText(String.valueOf(nn2));
    }

}
