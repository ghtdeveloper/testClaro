package claro.test.myapplication2;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.squareup.picasso.Picasso;


public class ProfileFragment extends Fragment {

    private TextView textViewScreenName;
    private ImageView img;
    private Button btnDismiss;
    private ConstraintLayout layout;
    private View root;

    private IFragmentDataActivity mCallback;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            mCallback = (IFragmentDataActivity)  context;
        }catch (ClassCastException e)
        {
            throw new ClassCastException(context.toString()
                    + " must implement FragmentToActivity");
        }
    }


    @Override
    public void onDetach() {
        mCallback = null;
        super.onDetach();
    }

    public ProfileFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       root = inflater.inflate(R.layout.fragment_profile, container, false);
       init();
       return  root;
    }

    private void init()
    {
        textViewScreenName = root.findViewById(R.id.tvScreenProfileName);
        assert getArguments() != null;
        String textData = getArguments().getString("Screen");
        textViewScreenName.setText(textData);
        img = root.findViewById(R.id.imgData);
        Uri uri = Uri.parse("https://i.imgur.com/DvpvklR.png");
        Picasso.get().load(uri).into(img);
        btnDismiss = root.findViewById(R.id.btnDismiss);
        layout  = root.findViewById(R.id.frameLayout);
        btnDismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(requireContext(), "Say Bye Context", Toast.LENGTH_SHORT).show();
                root.setVisibility(View.GONE);
                //Pass Data to activity
                sendMessageActivity();
            }
        });
    }

    private void sendMessageActivity()
    {
        mCallback.sendMessage("See you again :) from fragment");
    }

}