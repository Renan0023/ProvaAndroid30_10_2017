package auladv.com.br.provaandroid30_10_2017;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView btnTel = (TextView) findViewById(R.id.tx3);
        btnTel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MainActivitySegunda.class);
                intent.putExtra("TELEFONE_CLINICA", btnTel.getText());
                startActivity(intent);

            }
        });


    }
}
