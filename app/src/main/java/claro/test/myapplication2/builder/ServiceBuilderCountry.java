package claro.test.myapplication2.builder;

import org.jetbrains.annotations.NotNull;

import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * ***Created by: Edison Martinez,
 * ***Date:21,Friday,2022,
 * ***Proyect: My Application 2.
 **/
public class ServiceBuilderCountry {

    private static final OkHttpClient client;
    private static final Retrofit retrofit;
    @NotNull
    public static final ServiceBuilderCountry INSTANCE;

    public final Object buildService(@NotNull Class service) {
        Intrinsics.checkNotNullParameter(service, "service");
        return retrofit.create(service);
    }

    private ServiceBuilderCountry() {
    }

    static {
        ServiceBuilderCountry var0 = new ServiceBuilderCountry();
        INSTANCE = var0;
        client = (new OkHttpClient.Builder()).build();
        retrofit = (new retrofit2.Retrofit.Builder()).baseUrl("https://restcountries.com/v3.1/").addConverterFactory((Converter.Factory) GsonConverterFactory.create()).client(client).build();
    }

}
