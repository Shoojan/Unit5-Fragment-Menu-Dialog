package com.example.unit5demo.meme;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import androidx.fragment.app.Fragment;

import com.example.unit5demo.R;


public class MemeFragment extends Fragment {

    private ImageView memeImgView1;
    private ImageView memeImgView2;
    private ImageView memeImgView3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_meme, container, false);

        memeImgView1 = view.findViewById(R.id.memeImageView1);
        memeImgView2 = view.findViewById(R.id.memeImageView2);
        memeImgView3 = view.findViewById(R.id.memeImageView3);

        // Registering context menu

        // Setting click listeners for popup menu

        return view;
    }
}