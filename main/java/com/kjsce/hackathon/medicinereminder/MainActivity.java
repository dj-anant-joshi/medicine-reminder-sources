package com.kjsce.hackathon.medicinereminder;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.kjsce.hackathon.medicinereminder.setting_meals.SetMealsFragment;

public class MainActivity extends AppCompatActivity {
    private static final String MEAL_TIME_FRAGMENT_TAG = "MTFT";
    public static final String PREFS_NAME = "mealtime_preference";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences preferences = this.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        boolean breakfast, lunch, dinner;
        breakfast = preferences.contains("breakfast");
        lunch = preferences.contains("lunch");
        dinner = preferences.contains("dinner");
        if(breakfast && lunch && dinner){
            if(findViewById(R.id.activity_main) != null){
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.activity_main, new MainFragment()).commit();
            }
        }else{
            if(findViewById(R.id.activity_main)!=null){
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.activity_main, new SetMealsFragment(), MEAL_TIME_FRAGMENT_TAG).commit();
            }
        }
    }
}