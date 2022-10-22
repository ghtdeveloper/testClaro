package claro.test.myapplication2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements IFragmentDataActivity {

    private TextView tvTextNameScreenMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTextNameScreenMain = findViewById(R.id.tvTextMessage);
        Button btnProfileScreen = findViewById(R.id.btnProfileScreen);
        Button btnAPiScreen = findViewById(R.id.btnApiScreen);

        btnProfileScreen.setOnClickListener(view -> {

        Fragment fragment;
        Bundle bundle = new Bundle();
        fragment = new ProfileFragment();
            bundle.putString("Screen","Profile Screen");
            fragment.setArguments(bundle);
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.frameLayout,fragment).commit();
        });

        btnAPiScreen.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(),ApiScreen.class);
            intent.putExtra("screen","Api Screen");
            startActivity(intent);
            tvTextNameScreenMain.setText(" ");
        });

        if(getIntent().getStringExtra("message") != null)
        {
            tvTextNameScreenMain.setText(getIntent().getStringExtra("message"));
        }

    }

    @Override
    public void sendMessage(String message) {
        Log.d("Info",message);
        tvTextNameScreenMain.setText(message);
    }
}