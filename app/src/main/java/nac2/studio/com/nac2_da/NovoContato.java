package nac2.studio.com.nac2_da;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NovoContato extends AppCompatActivity {

    private Button botaoSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_contato);

        botaoSalvar = (Button) findViewById(R.id.botaoSalvarId);

        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText nome = (EditText) findViewById(R.id.nomeId);
                Intent intent = new Intent(NovoContato.this, MainActivity.class);
                intent.putExtra("nome",nome.getText().toString());
                startActivity(intent);
            }
        });

    }
}
