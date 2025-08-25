package pl.pollub.lab_4_ex_3_1;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    EditText et1;
    TextView tv1;
    double result = 0;
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
        toolbar=findViewById(R.id.myToolBar);
        setSupportActionBar(toolbar);
        et1=findViewById(R.id.editTextText);
        tv1=findViewById(R.id.textView);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        float a = Float.parseFloat(et1.getText().toString());
        if (item.getItemId() == R.id.CtoF) {
            result = (a * (9/5)) + 32;
            tv1.setText(String.format("%.2f [F]", result));
        } else if (item.getItemId() == R.id.CtoK) {
            result = a + 273.15;
            tv1.setText(String.format("%.2f [K]", result));
        } else if (item.getItemId() == R.id.FtoC) {
            result = ((a - 32) * 5)/9;
            tv1.setText(String.format("%.2f [C]", result));
        } else if (item.getItemId() == R.id.FtoK) {
            result = (((a - 35) * 5) / 9) + 273.15;
            tv1.setText(String.format("%.2f [K]", result));
        } else if (item.getItemId() == R.id.KtoC) {
            result = 273.15 - a;
            tv1.setText(String.format("%.2f [C]", result));
        } else if (item.getItemId() == R.id.KtoF) {
            result = (((a - 273.15)*9) / 5) + 32;
            tv1.setText(String.format("%.2f [F]", result));
        }
        return true;
    }
}