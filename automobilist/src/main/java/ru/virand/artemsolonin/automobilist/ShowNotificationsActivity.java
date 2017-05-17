package ru.virand.artemsolonin.automobilist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by artemsolonin on 16.05.2017.
 */

public class ShowNotificationsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_notifications);
    }

    public void onClickAddEvent(View v) {
        // действия при нажатии на кнопку
        Intent intent = new Intent(this, AddEventActivity.class);
        startActivity(intent);
    }
}
