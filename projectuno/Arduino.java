package capizzidev.projectuno;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Arduino extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arduino);

        TextView codice=(TextView) findViewById(R.id.codice);
        codice.setText(getIntent().getExtras().getString("tran"));
    }
}
