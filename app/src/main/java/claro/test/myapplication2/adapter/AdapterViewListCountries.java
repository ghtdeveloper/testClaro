package claro.test.myapplication2.adapter;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import claro.test.myapplication2.R;

/**
 * ***Created by: Edison Martinez,
 * ***Date:21,Friday,2022,
 * ***Proyect: My Application 2.
 **/
public class AdapterViewListCountries extends RecyclerView.ViewHolder
{
    //public ImageView imgFlagCountry;
    public TextView tvCountryName;

    public AdapterViewListCountries(@NonNull View itemView) {
        super(itemView);
        //imgFlagCountry = itemView.findViewById(R.id.imgFlagCountry);
        tvCountryName = itemView.findViewById(R.id.tvCountryName);
    }
}
