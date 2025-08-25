package pl.pollub.lab_8_ex_1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private CountryAdapter cAdapter;
    private DrawerLayout dl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.countries_list);
        ArrayList<Country> countriesList = new ArrayList<>();
        countriesList.add(new Country(R.drawable.norris, "Chuck Norris","chuckie@gmail.com", "111222333"));
        countriesList.add(new Country(R.drawable.chan, "Jackie Chan","jackie@gmail.com","444555666"));
        countriesList.add(new Country(R.drawable.seagal,"Steven Seagal", "stevenseag@gmail.com","777888999"));
        cAdapter = new CountryAdapter(this, countriesList);
        listView.setAdapter(cAdapter);
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> parent, View view,
                                            int position, long id) {
                        Toast.makeText(MainActivity.this,
                                "Your choice is " + countriesList.get(position).getName(), Toast.LENGTH_SHORT).show();
                    }
                });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });
    }
}