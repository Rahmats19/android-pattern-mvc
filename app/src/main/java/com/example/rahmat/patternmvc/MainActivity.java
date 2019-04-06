package com.example.rahmat.patternmvc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.example.rahmat.patternmvc.View.MvcView;

public class MainActivity extends Activity {

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.ui_splash);

        Thread timer = new Thread()
        {
            public void run()
            {
                try
                {
                    sleep(1000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    Intent intent = new Intent ("com.example.rahmat.patternmvc.View.MvcView");
                    startActivity(intent);
                }
            }
        };

        timer.start();
    }
}
