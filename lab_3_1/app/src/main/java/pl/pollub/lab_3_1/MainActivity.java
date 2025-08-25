package pl.pollub.lab_3_1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button b1, b2;
    EditText et1, et2;
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
        b1 = findViewById(R.id.button);
        b2 = findViewById(R.id.button2);
        et1 = findViewById(R.id.editTextText);
        et2 = findViewById(R.id.editTextText2);

    }
    public void startInternet(View v) {
        if (v.getId() == R.id.button) {
            String name = et1.getText().toString();
            int age = Integer.parseInt(et2.getText().toString());
            Intent i = new Intent(this, ResultActivity.class);
            i.putExtra("name", name);
            i.putExtra("age", age);
            startActivity(i);
            startActivityForResult(i, REQUEST_CODE);
        } else {
            Intent i = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://www.pollub.pl/"));
            startActivity(i);
        }
    }
    public void onActivityResult(int requestCode, int resultCode, Intent i){
        super.onActivityResult(requestCode, resultCode, i);
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
            String name = i.getStringExtra("name");
            int year = i.getIntExtra("year", 0);
            Toast.makeText(this, name + ", you were born in " +
                            String.valueOf(year) + " \nor a year earlier",
                    Toast.LENGTH_LONG).show();
        }
    }

}