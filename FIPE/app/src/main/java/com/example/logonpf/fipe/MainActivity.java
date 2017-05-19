package com.example.logonpf.fipe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity
        implements AdapterView.OnItemSelectedListener{

    private Spinner spMarca;
    private List<Marca> marcas;
    private ArrayAdapter<Marca> adpMarca;

    private Spinner spVeiculo;
    private List<Veiculo> veiculos;
    private ArrayAdapter<Veiculo> adpVeiculo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spMarca = (Spinner) findViewById(R.id.spMarca);
        spMarca.setOnItemSelectedListener(this);
        marcas = new ArrayList<Marca>();
        adpMarca = new ArrayAdapter<Marca>(this,
                android.R.layout.simple_spinner_item,marcas);
        spMarca.setAdapter(adpMarca);

        adpMarca.add(new Marca(-1, "Escolha a Marca"));


        spVeiculo = (Spinner) findViewById(R.id.spVeiculo);
        spVeiculo.setOnItemSelectedListener(this);
        veiculos = new ArrayList<Veiculo>();
        adpVeiculo = new ArrayAdapter<Veiculo>(this,
                android.R.layout.simple_spinner_item,veiculos);
        spVeiculo.setAdapter(adpVeiculo);

        adpVeiculo.add(new Veiculo(-1, "Escolha o Veículo"));

        carregarMarcas();

    }

    private void carregarMarcas() {

        String url = "http://fipeapi.appspot.com/api/1/carros/marcas.json";
        JsonArrayRequest req = new JsonArrayRequest(url,
                new RequestMarca(adpMarca),
                new RequestError());
        RequestQueue q = Volley.newRequestQueue(this);
        q.add(req);

    }

    private void carregarVeiculos(int idMarca) {

        String url = "http://fipeapi.appspot.com/api/1/carros/veiculos/" +  idMarca + ".json";
        JsonArrayRequest req = new JsonArrayRequest(url,
                new RequestVeiculo(adpVeiculo),
                new RequestError());
        RequestQueue q = Volley.newRequestQueue(this);
        q.add(req);

    }

    private void carregarModelo(int idMarca, int idVeiculo) {

        String url = "http://fipeapi.appspot.com/api/1/carros/veiculos/" +  idMarca + idVeiculo + ".json";
        JsonArrayRequest req = new JsonArrayRequest(url,
                new RequestVeiculo(adpVeiculo),
                new RequestError());
        RequestQueue q = Volley.newRequestQueue(this);
        q.add(req);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

       Object sel = parent.getItemAtPosition(position);
        if(sel instanceof Marca){
            carregarVeiculos(spMarca.getId());
        }else if(sel instanceof Veiculo){

        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
