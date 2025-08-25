package pl.pollub.lab_9_zad_1;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button b1, b2;
    static int itemSelected;
    static boolean isSelected;
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
        b1 = findViewById(R.id.button1);
        b2 = findViewById(R.id.button2);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
    }

    public void onClick(View v) {
        FragmentManager manager = getSupportFragmentManager();
        Fragment fr = manager.findFragmentByTag("addCity");
        Fragment1 fr1 = (Fragment1)
                getSupportFragmentManager().findFragmentById(R.id.list);
        if (v.equals(b1)) {
            if (fr != null) {
                manager.beginTransaction().remove(fr).commit();
            }
            Fragment2 fr2 = new Fragment2();
            fr2.show(manager, "addCity");
        }
        if (v.equals(b2)) {
            if (!fr1.cities.isEmpty()) {
                if (isSelected) {
                    fr1.cities.remove(itemSelected);
                    fr1.adapter.notifyDataSetChanged();
                    itemSelected = 0;
                    isSelected = false;
                    fr1.getListView()
                            .setSelector(android.R.color.transparent);
                } else {
                    Toast.makeText(this, "Select city to be deleted",
                            Toast.LENGTH_LONG).show();
                }
            }

        }
    }
}