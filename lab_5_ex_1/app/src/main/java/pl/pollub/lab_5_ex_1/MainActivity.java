package pl.pollub.lab_5_ex_1;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout dl;
    private ActionBarDrawerToggle abdt;
    private NavigationView nv;
    private TextView tv1;
    private ImageView iv1;
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
        tv1 = findViewById(R.id.textView);
        iv1 = findViewById(R.id.imageView);
        dl = findViewById(R.id.main);
        abdt = new ActionBarDrawerToggle(this, dl, 0, 0);
        dl.addDrawerListener(abdt);
        nv = findViewById(R.id.nv);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            public boolean onNavigationItemSelected(MenuItem item) {
                if (item.getItemId() == R.id.f1) {
                    Toast.makeText(MainActivity.this,
                            "Formula 1",Toast.LENGTH_SHORT).show();
                    iv1.setImageResource(R.drawable.mc);
                    tv1.setText("Formuła 1: Najwyższa klasa wyścigów samochodowych.");
                    dl.closeDrawer(Gravity.LEFT);
                } else if (item.getItemId() == R.id.mgp) {
                    Toast.makeText(MainActivity.this,
                            "Moto gp",Toast.LENGTH_SHORT).show();
                    tv1.setText("MotoGP: Najważniejsza seria wyścigowa motocykli.");
                    iv1.setImageResource(R.drawable.mt);
                    dl.closeDrawer(Gravity.LEFT);
                } else if (item.getItemId() == R.id.hc) {
                    Toast.makeText(MainActivity.this,
                            "Hypercar",Toast.LENGTH_SHORT).show();
                    iv1.setImageResource(R.drawable.hycp);
                    tv1.setText("Hipersamochody: Najszybsze i najbardziej luksusowe auta na świecie.");
                    dl.closeDrawer(Gravity.LEFT);
                } else if (item.getItemId() == R.id.lmgt3) {
                    Toast.makeText(MainActivity.this,
                            "LM GT3",Toast.LENGTH_SHORT).show();
                    iv1.setImageResource(R.drawable.lmg);
                    tv1.setText("MGT3: Klasa wyścigowa w długodystansowych mistrzostwach świata.");
                    dl.closeDrawer(Gravity.LEFT);
                }
                return true;
            }
        });
    }
}