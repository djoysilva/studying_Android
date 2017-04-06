package fiap.com.br.votacao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener,
                                                                AdapterView.OnItemClickListener{

    private List<CandidatoBean> prefeitos;
    private List<CandidatoBean> vereadores;
    private ArrayAdapter<CandidatoBean> adPrefeitos;
    private ArrayAdapter<CandidatoBean> adVereadores;
    private Spinner spCandidatos;
    private RadioGroup rgCargos;
    private CandidatoBean prefeitoVoto;
    private CandidatoBean vereadorVoto;
    private TextView txtPrefeito;
    private TextView txtVereador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        criarCandidados();
        popularPrefeito();

        spCandidatos = (Spinner) findViewById(R.id.spCandidatos);
        rgCargos = (RadioGroup) findViewById(R.id.rgCargos);
        txtPrefeito = (TextView) findViewById(R.id.txtPrefeito);
        txtVereador = (TextView) findViewById(R.id.txtVereador);

        rgCargos.setOnCheckedChangeListener(this);
        spCandidatos.setOnItemClickListener(this);

    }

    private void criarCandidados() {
       prefeitos = new ArrayList<CandidatoBean>();
       vereadores = new ArrayList<CandidatoBean>();

        prefeitos.add(new CandidatoBean("Zé da Feira","XTC"));
        prefeitos.add(new CandidatoBean("Maria Melhor", "LLL"));
        prefeitos.add(new CandidatoBean("Brandão","ZTO"));

        vereadores.add(new CandidatoBean("Vereador1", "Partido1"));
        vereadores.add(new CandidatoBean("V2", "P2"));
        vereadores.add(new CandidatoBean("V3", "P3"));
    }

    private void popularPrefeito(){
        adPrefeitos = new ArrayAdapter<CandidatoBean>(this, android.R.layout.simple_spinner_item, prefeitos);
        spCandidatos.setAdapter(adPrefeitos);
    }

    private void popularVereador(){
        adVereadores = new ArrayAdapter<CandidatoBean>(this, android.R.layout.simple_spinner_item, vereadores);
        spCandidatos.setAdapter(adVereadores);
    }

    private void Votar(View v){
        if(rgCargos.getCheckedRadioButtonId() == R.id.rbPrefeito){
            txtPrefeito.setText(prefeitoVoto.getNome());
        }else{
            txtPrefeito.setText(vereadorVoto.getNome());
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if(checkedId == R.id.rbPrefeito){
            popularPrefeito();
        }else{
            popularVereador();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(rgCargos.getCheckedRadioButtonId()== R.id.rbPrefeito){
            prefeitoVoto = (CandidatoBean) parent.getItemAtPosition(position);
        }else{
            vereadorVoto = (CandidatoBean) parent.getItemAtPosition(position);
        }
    }
}
