package pl.pollub.lab_3_z2;

import android.content.Intent;
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

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    TextView tv6, tv7, tv8, tv9;
    EditText et1, et2;
    Button b1;
    private static final int REQUEST_CODE = 1;
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
        b1 = findViewById(R.id.button);

        tv6 = findViewById(R.id.textView6);
        tv7 = findViewById(R.id.textView7);
        tv8 = findViewById(R.id.textView8);
        tv9 = findViewById(R.id.textView9);


    }
    public void startIntent(View v) {
        float a = Float.parseFloat(et1.getText().toString());
        float b = Float.parseFloat(et2.getText().toString());
        Intent i = new Intent(this, second_activity.class);
        i.putExtra("first_number", a);
        i.putExtra("second_number", b);
       //startActivity(i);
        startActivityForResult(i, REQUEST_CODE);
    }
    public void onActivityResult(int requestCode, int resultCode, Intent i) {
        super.onActivityResult(requestCode, resultCode, i);
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
            float sum = i.getFloatExtra("sum", 0);
            float sub = i.getFloatExtra("sub", 0);
            float mul = i.getFloatExtra("mul", 0);
            float div = i.getFloatExtra("div", 0);
            tv6.setText("Suma: " + String.valueOf(sum));
            tv7.setText("Różnica: " + String.valueOf(sub));
            tv8.setText("Iloczyn: " + String.valueOf(mul));
            tv9.setText("Iloraz: " + String.valueOf(div));

        }
    }
}