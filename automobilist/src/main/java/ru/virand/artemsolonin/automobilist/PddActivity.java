package ru.virand.artemsolonin.automobilist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by artemsolonin on 15.05.2017.
 */

public class PddActivity  extends AppCompatActivity {
    String[] names = { "ПДД РФ", "Дорожные знаки и разметка", "Таблица штрафов", "Технический регламент", "Административный регламент", "Допуск ТС к эксплуатации",
            "Перечень неисправностей", "Освидетельствование" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdd);

        // находим список
        ListView lvMain = (ListView) findViewById(R.id.lvMain);

        // создаем адаптер
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, names);

        // присваиваем адаптер списку
        lvMain.setAdapter(adapter);


    }

    public void onClickBtnDownload(View v) {
        // действия при нажатии на кнопку
        Intent intent = new Intent(this, DownloadActivity.class);
        startActivity(intent);
    }

    public void onClickBtnFirstLaunch(View v){
        Intent intent = new Intent(this, FirstLaunchActivity.class);
        startActivity(intent);
    }

    public void onClickBtnMain(View v)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
