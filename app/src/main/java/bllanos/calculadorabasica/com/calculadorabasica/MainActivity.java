package bllanos.calculadorabasica.com.calculadorabasica;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText numero1,numero2;
    Button calcular,limpiar;
    Spinner operacion;
    TextView vresultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Asignamos los ids a las variables
        numero1 = findViewById(R.id.numero1);
        numero2 = findViewById(R.id.numero2);
        calcular = findViewById(R.id.calcular);
        limpiar = findViewById(R.id.limpiar);
        operacion = findViewById(R.id.operaciones);
        vresultado = findViewById(R.id.vResultado);

        calcular.setOnClickListener(new View.OnClickListener(){
            @Override
            public  void onClick(View view){
                try{
                    Integer num1 = 0,num2 = 0;
                    float resultado;
                    String operar = operacion.getSelectedItem().toString().toLowerCase();
                    if(numero1.getText().toString().equals("")){
                        showMessage("Debe ingresar el numero 1");
                        return;
                    }
                    if(numero2.getText().toString().equals("")){
                        showMessage("Debe ingresar el numero 2");
                        return;
                    }
                    num1 = Integer.parseInt(numero1.getText().toString());
                    num2 = Integer.parseInt(numero2.getText().toString());
                    switch (operar){
                        case "suma":
                            resultado = (Integer) (num1+num2);
                            vresultado.setText("" + resultado);
                            break;
                        case "resta":
                            resultado = (Integer) (num1-num2);
                            vresultado.setText("" + resultado);
                            break;
                        case "multiplicación":
                            resultado = (Integer)(num1*num2);
                            vresultado.setText("" + resultado);
                            break;
                        case "división":
                            if(num2==0){
                                showMessage("No se puede dividir entre cero");
                                return;
                            }
                            resultado = (float)num1/num2;
                            vresultado.setText("" + resultado);
                            break;
                        case "potenciación":
                            resultado = (float) Math.pow(num1,num2);
                            vresultado.setText("" + resultado);
                            break;
                        default:
                            break;
                    }
                }catch (Exception e){
                    showMessage(e.getMessage().toString());
                }

                limpiar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        limpiar();
                    }
                });
            }
        });
    }

    public void showMessage(String message){
        Context context = getApplicationContext();
        CharSequence text = message;
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    private void limpiar(){
        numero1.setText("0");
        numero2.setText("0");
        vresultado.setText("0");
    }
}
