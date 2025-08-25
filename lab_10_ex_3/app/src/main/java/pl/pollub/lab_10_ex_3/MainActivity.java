package pl.pollub.lab_10_ex_3;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements
        SensorEventListener {
    TextView tv1, tv2;
    SensorManager sensorManager;
    CameraManager cameraManager;

    Sensor proximitySensor, lightSensor;
    String cameraId;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = findViewById(R.id.textView);
        tv2 = findViewById(R.id.textView2);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        cameraManager = (CameraManager) getSystemService(CAMERA_SERVICE);
    }
    public void onAccuracyChanged(Sensor sensor, int accuracy) {}
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_PROXIMITY) {
            tv1.setText("Proximity: " + String.valueOf(event.values[0]));
        }
        if (event.sensor.getType() == Sensor.TYPE_LIGHT) {
            tv2.setText("Illuminance: " + String.valueOf(event.values[0] +
                    " lx"));
            try {
                cameraId = cameraManager.getCameraIdList()[0];
                if (event.values[0] < 10) {
                    cameraManager.setTorchMode(cameraId, true);
                } else {
                    cameraManager.setTorchMode(cameraId, false);
                }
            } catch (CameraAccessException e) {
                e.printStackTrace();
            }
        }
    }
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }
    protected void onResume() {
        super.onResume();
        proximitySensor =
                sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        sensorManager.registerListener(this, proximitySensor,
                SensorManager.SENSOR_DELAY_NORMAL);
        lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        sensorManager.registerListener(this, lightSensor,
                SensorManager.SENSOR_DELAY_NORMAL);
    }
}