package com.example.unit5demo;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.unit5demo.fragments.BlueFragment;
import com.example.unit5demo.fragments.PinkFragment;
import com.example.unit5demo.meme.MemeFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void onFragmentBtnClicked(View view) {
        Fragment fragment;

        if (view == findViewById(R.id.blueBtn)) {
            fragment = new BlueFragment();
        } else {
            fragment = new PinkFragment();
        }

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        transaction.replace(R.id.fragmentView, fragment);

        transaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_option, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_home) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragmentView, new MemeFragment())
                    .commit();
            return true;
        } else if (item.getItemId() == R.id.menu_option_item) {
            Toast.makeText(this, "Opening settings...", Toast.LENGTH_SHORT).show();
            return true;
        } else if (item.getItemId() == R.id.menu_alert_dialog) {
            showCategoryDialog();
            return true;
        }

        return this.onOptionsItemSelected(item);
    }

    private void showCategoryDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("🔔 Alert Triggered!")
                .setMessage("Are you sure you are enjoying it?")
                .setPositiveButton("Yes", (dialog, id) -> dialog.dismiss())
                .setNegativeButton("May be", (dialog, id) -> dialog.dismiss())
                .create()
                .show();
    }
}