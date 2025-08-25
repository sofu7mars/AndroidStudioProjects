package pl.pollub.lab_10_zad_1;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements
        SensorEventListener {
    TextView tv1, tv2, tv3, tv4;
    SensorManager sensorManager;
    Sensor accelerometer;
    float [] values;
    float x, y, z;
    int shakes = 0;
    long lastUpdate;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lastUpdate = System.currentTimeMillis();
        tv4 = findViewById(R.id.textView4);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
    }
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            values = event.values;
            x = values[0];
            y = values[1];
            z = values[2];
            long actualTime = event.timestamp;
            if (actualTime - lastUpdate < 200) {
                    // Accidental movement
                return;
            }

            float acceleration = (x * x + y * y + z * z) /
                    (SensorManager.GRAVITY_EARTH * SensorManager.GRAVITY_EARTH);
            if (acceleration > 2.5) {
                shakes = shakes + 1;
                tv4.setText("Shakes: " + String.valueOf(shakes));
            }
        }
    }
    public void onAccuracyChanged(Sensor sensor, int accuracy) {}
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }
    protected void onResume() {
        super.onResume();
        accelerometer =
                sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this, accelerometer,
                SensorManager.SENSOR_DELAY_NORMAL);
    }
}