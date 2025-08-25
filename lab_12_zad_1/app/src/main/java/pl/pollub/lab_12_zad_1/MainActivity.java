package pl.pollub.lab_12_zad_1;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener {
    ImageView im1;
    ImageButton ibr, ibl;
    int[] images = {R.drawable.img01, R.drawable.img02,
            R.drawable.img03, R.drawable.img04, R.drawable.img05};
    int count = 0;
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
        im1 = findViewById(R.id.imageView3);
        ibr = findViewById(R.id.imageButton9);
        ibl = findViewById(R.id.imageButton10);

        ibr.setOnClickListener(this);
        ibl.setOnClickListener(this);
    }
    public void onClick(View v) {
        count += (v.equals(ibr)) ? 1 : -1;
        count = (count + 5) % 5;
        im1.setImageResource(images[count]);
    }
}