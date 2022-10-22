package claro.test.myapplication2.interfaces;

import java.util.ArrayList;
import java.util.List;

import claro.test.myapplication2.model.CountryInfo;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * ***Created by: Edison Martinez,
 * ***Date:21,Friday,2022,
 * ***Proyect: My Application 2.
 **/
public interface CountryService {

    @GET("all")
    Call<ArrayList<CountryInfo>> getAllCountries();

}
