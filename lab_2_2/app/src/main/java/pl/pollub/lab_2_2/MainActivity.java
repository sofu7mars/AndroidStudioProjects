package pl.pollub.lab_2_2;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    RadioButton rb1, rb2, rb3, rb4;
    EditText et1, et2;
    TextView tv1;

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
        rb1 = findViewById(R.id.radioButton);
        rb2 = findViewById(R.id.radioButton2);
        rb3 = findViewById(R.id.radioButton4);
        rb4 = findViewById(R.id.radioButton5);
        et1 = findViewById(R.id.editTextText);
        et2 = findViewById(R.id.editTextText2);
        tv1 = findViewById(R.id.textView);


    }
    public void math(View v) {
        float x = Float.parseFloat(et1.getText().toString());
        float y = Float.parseFloat(et2.getText().toString());
        float result = 0;
        if (rb1.isChecked()) {
            result = x + y;
            tv1.setText("Suma = " + String.valueOf(result));
        } else if (rb2.isChecked()) {
            result = x - y;
            tv1.setText("Różnica = " + String.valueOf(result));
        } else if (rb3.isChecked()) {
            result = x * y;
            tv1.setText("Iloczyn = " + String.valueOf(result));
        } else if(rb4.isChecked()) {
            if (y != 0) {
                result = x / y;
                tv1.setText("Iloraz = " + String.valueOf(result));
            }
        }

    }
}