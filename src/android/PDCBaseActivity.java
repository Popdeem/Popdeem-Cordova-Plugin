package com.popdeem.cordova.plugin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import io.cordova.hellocordova.R;

public class PDCBaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdcbase);
    }
}
