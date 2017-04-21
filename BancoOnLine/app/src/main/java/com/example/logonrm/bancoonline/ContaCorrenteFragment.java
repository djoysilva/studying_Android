package com.example.logonrm.bancoonline;


import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



/**
 * A simple {@link Fragment} subclass.
 */
public class ContaCorrenteFragment extends Fragment implements View.OnClickListener{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_conta_corrente, container, false);
        v.findViewById(R.id.btnSaldo).setOnClickListener(this);
        v.findViewById(R.id.btnExtrato).setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnSaldo){
            Log.i("Evento", "Verificar Saldo!!");

        }else if(v.getId() == R.id.btnExtrato){
            Log.i("Evento", "Verificar Extrato!!");
        }
    }
}
