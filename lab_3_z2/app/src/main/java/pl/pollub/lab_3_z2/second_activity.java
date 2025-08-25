package pl.pollub.lab_3_z2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class second_activity extends AppCompatActivity {
    TextView tv1, tv2;
    float a, b;
    float sum, sub, mul, div;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        tv1 = findViewById(R.id.textView11);
        tv2 = findViewById(R.id.textView12);
        a = getIntent().getFloatExtra("first_number", 0);
        b = getIntent().getFloatExtra("second_number", 0);
        tv1.setText(String.valueOf(a));
        tv2.setText(String.valueOf(b));



    }
    public void finish() {
        sum = a + b;
        sub = a - b;
        mul = a * b;
        if (b != 0) {
            div = a / b;
        }
        Intent i = new Intent();

        i.putExtra("sum", sum);
        i.putExtra("sub", sub);
        i.putExtra("mul", mul);
        i.putExtra("div", div);
        setResult(RESULT_OK, i);
        super.finish();

    }

}