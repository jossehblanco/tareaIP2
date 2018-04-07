package jossehblanco.tareaip;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick1(View v){
        EditText edit1 = findViewById(R.id.edit1);
        EditText edit2 = findViewById(R.id.edit2);
        EditText edit3 = findViewById(R.id.edit3);
        EditText edit4 = findViewById(R.id.edit4);
        EditText edit5 = findViewById(R.id.edit5);
        EditText edit6 = findViewById(R.id.edit6);
        EditText edit7 = findViewById(R.id.edit7);
        if(edit1.getText().toString() != "" && edit2.getText().toString() != ""){
            String ip = edit1.getText().toString();
            String netmask = edit2.getText().toString();
            calculadoraIP calc = new calculadoraIP(ip, Integer.parseInt(netmask));
            edit3.setText(calc.genNetId());
            edit4.setText(calc.genBroadcast());
            edit5.setText(calc.genHosts());
            edit6.setText(calc.genRedpt());
            edit7.setText(calc.genHostpt());
        }
    }

    public void onClick2(View v){
        EditText edit1 = findViewById(R.id.edit1);
        EditText edit2 = findViewById(R.id.edit2);
        EditText edit3 = findViewById(R.id.edit3);
        EditText edit4 = findViewById(R.id.edit4);
        EditText edit5 = findViewById(R.id.edit5);
        EditText edit6 = findViewById(R.id.edit6);
        EditText edit7 = findViewById(R.id.edit7);
        edit1.setText("");
        edit2.setText("");
        edit3.setText("");
        edit4.setText("");
        edit5.setText("");
        edit6.setText("");
        edit7.setText("");
    }
}