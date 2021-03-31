package etec.ds.agenda07_luximetro;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SensorManager sensorManager;
    private Sensor sensor;
    private SensorEventListener sensorEventListener;
    static float maxLight;
    static float minLight = 40000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);


        if (sensor == null) {
            Toast.makeText(this, "O dispositivo não possui sensor de luz!",
                    Toast.LENGTH_SHORT).show();
            finish();
        }

        sensorEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                float value = sensorEvent.values[0];
                TextView txtMenorResultadoProg = (TextView) findViewById(R.id.txtMenorLux);
                TextView txtResultadoProg = (TextView) findViewById(R.id.txtResultado);
                TextView txtMaiorResultadoProg = (TextView) findViewById(R.id.txtMaiorResultado);

                // Valor máximo
                if (value > maxLight) {
                    maxLight = value;
                    txtMaiorResultadoProg.setText(maxLight + " Lx");
                }

                //v Valor minimo
                if (value < minLight) {
                    minLight = value;
                    txtMenorResultadoProg.setText(minLight + " Lx");
                }

                // Valor em tempo real
                txtResultadoProg.setText(value + " Lx");
            }
            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(sensorEventListener, sensor,
                SensorManager.SENSOR_DELAY_FASTEST);
    }
    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(sensorEventListener);
    }

}