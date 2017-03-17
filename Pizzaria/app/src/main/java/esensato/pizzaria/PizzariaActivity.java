package esensato.pizzaria;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class PizzariaActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private Spinner spSabores;
    private ImageView imgPizza;
    private List<PizzaBean> pizzas;
    private ArrayAdapter<PizzaBean> adpPizza;
    private PizzaBean selecionada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizzaria);
        spSabores = (Spinner) findViewById(R.id.spSabor);
        criarPizzasTeste();
        popularSpinnerSabores();
        spSabores.setOnItemSelectedListener(this);
        imgPizza = (ImageView) findViewById(R.id.imgPizza);

    }


    private void popularSpinnerSabores() {

        adpPizza = new ArrayAdapter<PizzaBean>(this,
                android.R.layout.simple_spinner_item,
                this.pizzas);

        spSabores.setAdapter(adpPizza);
    }

    private void criarPizzasTeste() {

        pizzas = new ArrayList<PizzaBean>();
        pizzas.add(new PizzaBean("Super Bacon", 10.0, R.drawable.pizzabacon));
        pizzas.add(new PizzaBean("Mega Carbonara", 20.0, R.drawable.pizzacarbonara));
        pizzas.add(new PizzaBean("La Pancia del Nono", 15.0, R.drawable.pizzapancianono));
        pizzas.add(new PizzaBean("Queijo Puxa Puxa", 13.0, R.drawable.pizzaqueijo));
        pizzas.add(new PizzaBean("Ridiculúcula", 30.0, R.drawable.pizzarucula));

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        PizzaBean pizza = (PizzaBean) parent.getItemAtPosition(position);
        Toast.makeText(this, pizza.getSabor(), Toast.LENGTH_SHORT).show();
        imgPizza.setImageResource(pizza.getImagem());
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

