package com.example.frahmenthomework;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements LoginFragment.onMessageListenner {
    FragmentManager fragmentManager=getSupportFragmentManager();
    FragmentTransaction fragmentTransaction;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.text_view);
        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, new HomeFragment()).commit();
    }

    @Override
    public void onMessageSend(String name) {
        String data=name;
        WelcomeFragment welcomeFragment=new WelcomeFragment();
        Bundle bundle=new Bundle();
        bundle.putString("NAME",name);
        welcomeFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, welcomeFragment).addToBackStack(null).commit();
    }
}
