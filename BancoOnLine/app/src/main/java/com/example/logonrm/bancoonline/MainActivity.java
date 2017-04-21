package com.example.logonrm.bancoonline;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        telaCC();
    }

    public void contaCorrente(View v){
        telaCC();
    }

    public void aplicacao(View v){
        telaAplicacao();
    }
    private void telaCC(){
        FragmentManager fm = getFragmentManager();
        FragmentTransaction t = fm.beginTransaction();

        t.replace(R.id.frame, new ContaCorrenteFragment());

        t.commit();
    }

    private void telaAplicacao(){
        FragmentManager fm = getFragmentManager();
        FragmentTransaction t = fm.beginTransaction();

        t.replace(R.id.frame, new AplicacaoFragment());

        t.commit();
    }
}
