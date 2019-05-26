package nac2.studio.com.nac2_da;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView lista;
    private ArrayList<String> lista2 = new ArrayList<String>();
    private Button novoContato;
    private String[] novoNome = new String[80];
    private int aux;
    private static final String Arquivo_lista = "Arquivo_lista";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle extra = getIntent().getExtras();

        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {
            aux = (int) savedInstanceState.get("valor");
        }

        if (extra != null) {
            aux = soma1();
            novoNome[aux] = extra.getString("nome");
            lista2.add(novoNome[aux]);
        }

        lista = (ListView) findViewById(R.id.listViewId);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                lista2
        );
        lista.setAdapter(adaptador);

        novoContato = (Button) findViewById(R.id.novoId);

        novoContato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences(Arquivo_lista,0);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("aux",aux);
                editor.commit();


                Intent intent = new Intent(MainActivity.this, NovoContato.class);
                startActivity(intent);
            }
        });
    }

    public int soma1() {
        SharedPreferences sharedPreferences = getSharedPreferences(Arquivo_lista, 0);
        aux = sharedPreferences.getInt("aux", 0);
        aux = aux + 1;
        return aux;
    };
}
