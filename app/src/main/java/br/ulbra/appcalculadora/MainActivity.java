package br.ulbra.appcalculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView resultado;
    EditText val1, val2;
    Button botaoSomar, botaoSubtrair, botaoMultiplicar, botaoDividir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        val1 = findViewById(R.id.edtVal1);
        val2 = findViewById(R.id.edtVal2);
        botaoSomar = findViewById(R.id.btnSomar);
        botaoSubtrair = findViewById(R.id.btnSubtrair);
        botaoMultiplicar = findViewById(R.id.btnMultiplicar);
        botaoDividir = findViewById(R.id.btnDividir);
        resultado = findViewById(R.id.txtResultado);

        botaoSomar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcular('+');
            }
        });

        botaoSubtrair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcular('-');
            }
        });

        botaoMultiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcular('*');
            }
        });

        botaoDividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcular('/');
            }
        });
    }

    private void calcular(char operacao) {
        double v1, v2, result;
        try {
            v1 = Double.parseDouble(val1.getText().toString());
            v2 = Double.parseDouble(val2.getText().toString());

            switch (operacao) {
                case '+':
                    result = v1 + v2;
                    resultado.setText("Resultado: A soma é " + result);
                    break;
                case '-':
                    result = v1 - v2;
                    resultado.setText("Resultado: A subtração é " + result);
                    break;
                case '*':
                    result = v1 * v2;
                    resultado.setText("Resultado: A multiplicação é " + result);
                    break;
                case '/':
                    if (v2 != 0) {
                        result = v1 / v2;
                        resultado.setText("Resultado: A divisão é " + result);
                    } else {
                        Toast.makeText(this, "Não é possível dividir por zero", Toast.LENGTH_SHORT).show();
                    }
                    break;
                default:
                    Toast.makeText(this, "Operação inválida", Toast.LENGTH_SHORT).show();
            }
        } catch (NumberFormatException e) {
            // Trata o erro caso algum campo esteja vazio ou tenha um valor inválido
            Toast.makeText(this, "Por favor, preencha ambos os campos com números válidos", Toast.LENGTH_SHORT).show();
        }
    }
}