package claro.test.myapplication2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import claro.test.myapplication2.adapter.AdapterCountries;
import claro.test.myapplication2.builder.ServiceBuilderCountry;
import claro.test.myapplication2.interfaces.CountryService;
import claro.test.myapplication2.model.CountryInfo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiScreen extends AppCompatActivity {

    //Objetcs
    private ArrayList<CountryInfo> lisDataCountry;
    private AdapterCountries adapterCountries;
    private RecyclerView rvCountries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api_screen);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Api Screen");
        Button btnDismiss = findViewById(R.id.btnDismissActivity);

        btnDismiss.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            intent.putExtra("message","See you again from Activity");
           startActivity(intent);
        });
        rvCountries= findViewById(R.id.rvCountries);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(rvCountries.getContext(),
                new LinearLayoutManager(this).getOrientation());
        rvCountries.addItemDecoration(dividerItemDecoration);
        rvCountries.setLayoutManager(new LinearLayoutManager(this));
        //Call WS
        getDatacountries();

    }

    private void getDatacountries()
    {
        lisDataCountry = new ArrayList<>();

        CountryService retrofit = (CountryService) ServiceBuilderCountry.INSTANCE.
                buildService(CountryService.class);
        retrofit.getAllCountries().enqueue(new Callback<ArrayList<CountryInfo>>() {
            @Override
            public void onResponse(Call<ArrayList<CountryInfo>> call, Response<ArrayList<CountryInfo>> response) {
                assert response.body() != null;
                if(response.body().isEmpty())
                {
                    Log.d("TAG","DATA WS IS EMPTY");
                }else
                {
                    Log.d("TAG","DATA WS IS FULL");
                    lisDataCountry.addAll(response.body());
                    adapterCountries = new AdapterCountries(lisDataCountry,getApplicationContext());
                    rvCountries.setAdapter(adapterCountries);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<CountryInfo>> call, Throwable t) {
                Log.e("TAG", "ERROR CALL WS " + t);
            }
        });
    }
}