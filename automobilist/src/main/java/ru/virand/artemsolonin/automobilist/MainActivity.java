package ru.virand.artemsolonin.automobilist;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    int currentImage=1;
    float x1=0, x2=0, y1=0, y2=0, dx=0, dy=0;

    public void setImage(int numberOfImage)
    {
        ImageView v = (ImageView)findViewById(R.id.high_stats);
        switch(numberOfImage){
            case 1:
                ((ImageView) v.findViewById(R.id.high_stats)).setImageResource(R.drawable.month);
                break;
            case 2:
                ((ImageView) v.findViewById(R.id.high_stats)).setImageResource(R.drawable.year);
                break;
            case 3:
                ((ImageView) v.findViewById(R.id.high_stats)).setImageResource(R.drawable.all);
                break;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {

        String direction;
        switch(event.getAction()) {
            case(MotionEvent.ACTION_DOWN):
                x1 = event.getX();
                y1 = event.getY();
                break;

            case(MotionEvent.ACTION_UP): {
                x2 = event.getX();
                y2 = event.getY();
                dx = x2-x1;
                dy = y2-y1;
                Log.d("VIRAND_LOG X1", String.valueOf(x1));
                Log.d("VIRAND_LOG X2", String.valueOf(x2));
                Log.d("VIRAND_LOG Y1", String.valueOf(y1));
                Log.d("VIRAND_LOG Y2", String.valueOf(y2));
                // Use dx and dy to determine the direction
                if(Math.abs(dx) > Math.abs(dy)) {
                    if(dx>0) {
                        direction = "right";
                        Log.d("VIRAND_LOG", "RIGHT");
                        if(currentImage==3)
                        {

                        }
                        else
                        {
                            currentImage++;
                            this.setImage(currentImage);
                        }
                    }
                    else
                    {
                        direction = "left";
                        Log.d("VIRAND_LOG","LEFT");
                        if(currentImage==0)
                        {

                        }
                        else
                        {
                            currentImage--;
                            this.setImage(currentImage);
                        }
                    }

                } else {
                    if(dy>0){
                        direction = "down";
                        Log.d("VIRAND_LOG","DOWN");
                    }

                    else
                    {
                        direction = "up";
                        Log.d("VIRAND_LOG","UP");
                    }

                }
            }
        }

        return true;
    }

    public void onClickAuto(View v) {
        // действия при нажатии на кнопку
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onClickEvents(View v) {
        // действия при нажатии на кнопку
        Intent intent = new Intent(this, ShowEventsActivity.class);
        startActivity(intent);
    }

    public void onClickPdd(View v) {
        // действия при нажатии на кнопку
        Intent intent = new Intent(this, PddActivity.class);
        startActivity(intent);
    }

    public void onClickNotifications(View v) {
        // действия при нажатии на кнопку
        Intent intent = new Intent(this, ShowNotificationsActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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