package com.example.unit5demo.meme;

import android.app.Dialog;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
        registerForContextMenu(memeImgView1);

        // Setting click listeners for popup menu
        memeImgView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(requireContext(), view);

                MenuInflater popMenuInflater = popupMenu.getMenuInflater();
                popMenuInflater.inflate(R.menu.menu_popup, popupMenu.getMenu());

//                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
//                    @Override
//                    public boolean onMenuItemClick(MenuItem item) {
//                        return false;
//                    }
//                });

                popupMenu.setOnMenuItemClickListener(item -> {
                    if (item.getItemId() == R.id.menu_like) {
                        Toast
                                .makeText(
                                        getContext(),
                                        "Liked!",
                                        Toast.LENGTH_SHORT
                                )
                                .show();
                        return true;
                    }
                    return false;
                });

                popupMenu.show();

            }
        });

        return view;
    }

    @Override
    public void onCreateContextMenu(@NonNull ContextMenu menu, @NonNull View v, @Nullable ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = requireActivity().getMenuInflater();
        menuInflater.inflate(R.menu.menu_context, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_share) {

        } else if (item.getItemId() == R.id.menu_custom_dialog) {
            Dialog customDialog = new Dialog(requireContext());
            customDialog.setContentView(R.layout.dialog_custom);

            Button customDialogCloseButton = customDialog
                    .findViewById(R.id.dialog_button);
            customDialogCloseButton.setOnClickListener(view ->
                    customDialog.dismiss()
            );

            customDialog.show();
        }

        return super.onContextItemSelected(item);
    }

//    private void showPopMenu(View view){
//
//    }
}