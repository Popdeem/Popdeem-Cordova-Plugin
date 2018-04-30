/*
       Licensed to the Apache Software Foundation (ASF) under one
       or more contributor license agreements.  See the NOTICE file
       distributed with this work for additional information
       regarding copyright ownership.  The ASF licenses this file
       to you under the Apache License, Version 2.0 (the
       "License"); you may not use this file except in compliance
       with the License.  You may obtain a copy of the License at

         http://www.apache.org/licenses/LICENSE-2.0

       Unless required by applicable law or agreed to in writing,
       software distributed under the License is distributed on an
       "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
       KIND, either express or implied.  See the License for the
       specific language governing permissions and limitations
       under the License.
 */

/** extends CordovaActivity */

import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import com.popdeem.cordova.plugin.CordovaFragment;
import com.popdeem.cordova.plugin.PopdeemApplication;

public class PopdeemActivity extends FragmentActivity
{
    private static final String TAG = "PopdeemActivity";
    int counter;
    public CordovaFragment currentFragment;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);

        currentFragment = new CordovaFragment();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.add(android.R.id.content, currentFragment);
        ft.commit();
    }

    /**
     * Called when the system is about to start resuming a previous activity.
     */
    @Override
    protected void onPause() {
        super.onPause();
        currentFragment.onPause();
    }

    /**
     * Called when the activity will start interacting with the user.
     */
    @Override
    protected void onResume() {
        super.onResume();
        currentFragment.onResume();
    }

    /**
     * Called when the activity is no longer visible to the user.
     */
    @Override
    protected void onStop() {
        super.onStop();
        currentFragment.onStop();
    }

    /**
     * Called when the activity is becoming visible to the user.
     */
    @Override
    protected void onStart() {
        super.onStart();
        currentFragment.onStart();
    }

    /**
     * The final call you receive before your activity is destroyed.
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        currentFragment.onDestroy();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[],
                                            int[] grantResults) {
        currentFragment.onRequestPermissionsResult(requestCode,permissions,grantResults);
    }
}
