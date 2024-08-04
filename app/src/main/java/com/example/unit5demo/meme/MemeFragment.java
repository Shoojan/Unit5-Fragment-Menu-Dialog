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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.PopupMenu;
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
        registerForContextMenu(memeImgView2);
        registerForContextMenu(memeImgView3);

        // Setting click listeners for popup menu
        memeImgView1.setOnClickListener(this::showPopupMenu);
        memeImgView2.setOnClickListener(this::showPopupMenu);
        memeImgView3.setOnClickListener(this::showPopupMenu);

        return view;
    }

    @Override
    public void onCreateContextMenu(@NonNull ContextMenu menu, @NonNull View v, @Nullable ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = requireActivity().getMenuInflater();
        inflater.inflate(R.menu.menu_context, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.menu_share) {
            Toast.makeText(getContext(), "Why share? Just enjoy!", Toast.LENGTH_SHORT).show();
            return true;
        } else if (itemId == R.id.menu_custom_dialog) {
            showCustomDialog();
            return true;
        }
        return super.onContextItemSelected(item);
    }

    private void showCustomDialog() {
        Dialog dialog = new Dialog(requireContext());
        dialog.setContentView(R.layout.dialog_custom);

        Button closeButton = dialog.findViewById(R.id.dialog_button);
        closeButton.setOnClickListener(v -> dialog.dismiss());

        dialog.show();
    }

    private void showPopupMenu(View view) {
        PopupMenu popup = new PopupMenu(requireContext(), view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_popup, popup.getMenu());
        popup.setOnMenuItemClickListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.menu_laugh) {
                Toast.makeText(getContext(), "Laugh Reaction", Toast.LENGTH_SHORT).show();
                return true;
            } else if (itemId == R.id.menu_love) {
                Toast.makeText(getContext(), "Love Reaction", Toast.LENGTH_SHORT).show();
                return true;
            } else if (itemId == R.id.menu_wow) {
                Toast.makeText(getContext(), "Wow Reaction", Toast.LENGTH_SHORT).show();
                return true;
            }
            return false;
        });
        popup.show();
    }
}