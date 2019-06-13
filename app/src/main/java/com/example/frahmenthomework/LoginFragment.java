package com.example.frahmenthomework;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {
    EditText name_editText;
    EditText password_editText;
    Button login;
   onMessageListenner messageListenner;
    public LoginFragment() {
        // Required empty public constructor
    }
    public interface onMessageListenner{
        public void onMessageSend(String name);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_login, container, false);
        name_editText=view.findViewById(R.id.edit_text_name);
        password_editText=view.findViewById(R.id.edit_text_password);
        login=view.findViewById(R.id.button_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=name_editText.getText().toString();
                String password=password_editText.getText().toString();
                if(name.equals("admin")&&password.equals("123")){
                    messageListenner.onMessageSend(name);
                }else{
                    Toast.makeText(getContext(), "your name and password doesn't match", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        MainActivity activity=(MainActivity) context;
        messageListenner=(onMessageListenner) activity;
    }
}
