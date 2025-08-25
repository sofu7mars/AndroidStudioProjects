package pl.pollub.lab_2_3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText et1, et2, et3;
    TextView tv1, tv2;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        et1 = findViewById(R.id.editTextText);
        et2 = findViewById(R.id.editTextText2);
        et3 = findViewById(R.id.editTextText3);
        tv1 = findViewById(R.id.textView);
        tv2 = findViewById(R.id.textView2);

    }

    public void quaec(View v) {
        try {
            float a = Float.parseFloat(et1.getText().toString());
            float b = Float.parseFloat(et2.getText().toString());
            float c = Float.parseFloat(et3.getText().toString());

            float delta = (b * b) - 4 * a * c;
            double x1, x2, x;

            if (delta > 0) {
                x1 = (-b - Math.sqrt(delta)) / (2 * a);
                x2 = (-b + Math.sqrt(delta)) / (2 * a);
                tv1.setText("Dwa rowiązania");
                tv2.setText("x1 = " + String.valueOf(x1) + "\t x2 = " + String.valueOf(x2));
            } else if (delta == 0) {
                x = (-b) / (2 * a);
                tv1.setText("Jedno rozwiązanie");
                tv2.setText("x = " + String.valueOf(x));
            } else if (delta < 0) {
                tv1.setText("Nie ma rozwiązań");
                tv2.setText("Nie ma rozwiązań");
            }

        } catch (NumberFormatException e) {
            tv1.setText("Błąd");
            tv2.setText("Wporwadź liczby jeszcze raz.");
        }
    }
}