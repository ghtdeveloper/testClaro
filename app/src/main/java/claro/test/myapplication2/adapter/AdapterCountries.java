package claro.test.myapplication2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

import claro.test.myapplication2.R;
import claro.test.myapplication2.model.CountryInfo;

/**
 * ***Created by: Edison Martinez,
 * ***Date:21,Friday,2022,
 * ***Proyect: My Application 2.
 **/
public class AdapterCountries  extends RecyclerView.Adapter<AdapterViewListCountries>
{
    private ArrayList<CountryInfo> mData;
    private Context context;


    public AdapterCountries(ArrayList<CountryInfo> arrayList, Context context)
    {
        this.mData = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterViewListCountries onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_country,
               parent,false);
        return new AdapterViewListCountries(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterViewListCountries holder, int position) {
       CountryInfo countryInfo = mData.get(position);
       holder.tvCountryName.setText(countryInfo.getName().getCommon());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
