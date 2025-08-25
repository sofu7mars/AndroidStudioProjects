package pl.pollub.lab_10_ex_2_1;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import static java.lang.Math.round;
import static java.lang.Math.toDegrees;
public class MainActivity extends AppCompatActivity implements
        SensorEventListener {
    TextView tv1, tv2, tv3;
    SensorManager sensorManager;
    Sensor accelerometer, magneticField;
    float[] mAccelerometerData = new float[3];
    float[] mMagnetometerData = new float[3];
    float[] rotationMatrix = new float[9];
    float[] orientationValues = new float[3];
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = findViewById(R.id.textView);
        tv2 = findViewById(R.id.textView2);
        tv3 = findViewById(R.id.textView3);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
    }
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            mAccelerometerData = event.values.clone();
        } else {
            mMagnetometerData = event.values.clone();
        }
        SensorManager.getRotationMatrix(rotationMatrix,null,
                mAccelerometerData, mMagnetometerData);
        SensorManager.getOrientation(rotationMatrix, orientationValues);
        tv1.setText("Azimuth: " +
                String.valueOf(round(toDegrees(orientationValues[0]))) + "degrees");
        tv2.setText("Pitch: " +
                String.valueOf(round(toDegrees(orientationValues[1]))) + " degrees");
        tv3.setText("Roll: " +
                String.valueOf(round(toDegrees(orientationValues[2]))) + " degrees");
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
                SensorManager.SENSOR_DELAY_NORMAL, SensorManager.SENSOR_DELAY_UI);
        magneticField =
                sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
        sensorManager.registerListener(this, magneticField,
                SensorManager.SENSOR_DELAY_NORMAL, SensorManager.SENSOR_DELAY_UI);
    }
}