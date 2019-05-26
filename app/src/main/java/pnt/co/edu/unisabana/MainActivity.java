package pnt.co.edu.unisabana;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.x);
        final TextView textView = (TextView) findViewById(R.id.textView);
        final Button button = (Button) findViewById(R.id.button);
        
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://<yourapp>.herokuapp.com/")
                .build();

        final HerokuService service = retrofit.create(HerokuService.class);
    }
}
