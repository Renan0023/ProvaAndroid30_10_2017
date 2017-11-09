package auladv.com.br.provaandroid30_10_2017;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivitySegunda extends AppCompatActivity {
    private String telefoneClincia;
    private String resumo;
    private objetoDoutor mobjetoDoutor;
    private TextView apresentacao;
    private TextView telefone;
    private EditText nome;
    private RadioButton segunda;
    private RadioButton terca;
    private Button enviarEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_segunda);
        mobjetoDoutor = new objetoDoutor();
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();

            telefoneClincia = extras.getString("TELEFONE_CLINICA");
        }
        apresentacao = (TextView) findViewById(R.id.CorpoEmailEXAMPLE);
        telefone = (TextView) findViewById(R.id.telefone);
        nome = (EditText) findViewById(R.id.nome);
        segunda = (RadioButton) findViewById(R.id.rdbsim);
        terca = (RadioButton) findViewById(R.id.rdbnao);
        enviarEmail = (Button) findViewById(R.id.btnEnviar);
        telefone.setText(telefoneClincia);

        segunda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (terca.isChecked()) {
                    segunda.setChecked(true);
                    terca.setChecked(false);
                    mobjetoDoutor.setDiasemana(segunda.getText().toString());
                } else {
                    segunda.setChecked(false);
                    terca.setChecked(true);
                    mobjetoDoutor.setDiasemana(terca.getText().toString());

                }

            }
        });

        terca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (segunda.isChecked()) {
                    segunda.setChecked(false);
                    terca.setChecked(true);
                    mobjetoDoutor.setDiasemana(terca.getText().toString());
                } else {
                    terca.setChecked(false);
                    segunda.setChecked(true);
                    mobjetoDoutor.setDiasemana(segunda.getText().toString());
                }
            }
        });


        enviarEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mobjetoDoutor.getDiasemana().toString() == null) {
                    mobjetoDoutor.setDiasemana("segund-faeira");
                }
                mobjetoDoutor.setTelefone(telefoneClincia);
                mobjetoDoutor.setNomepaci(nome.getText().toString());
                String texto = "Dia da semana : " + mobjetoDoutor.getDiasemana() + "\n" + " Nome Paciente : " + mobjetoDoutor.getNomepaci() + "\n" + " Telefone : " + mobjetoDoutor.getTelefone();

                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "renan@f10.com.br", null));
                emailIntent.setType("message/rfc822");
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
                emailIntent.putExtra(Intent.EXTRA_TEXT, texto);
                startActivity(Intent.createChooser(emailIntent, "enviar e-mail atráves de..."));

                apresentacao.setText(texto);
            }
        });

    }
}
