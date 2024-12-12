package com.example.wydarzeniewsudetach;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button addLike;
    private Button deleteLike;
    private Button save;
    private Button showUser;
    private TextView likeCount;
    private TextView infoBox;
    private EditText emailEditText;
    private EditText passEditText;
    private EditText repPassEditText;
    private int likeCounter = 0;
    private Resources res;
    private String lastRegisteredEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        addLike = findViewById(R.id.addLike);
        deleteLike = findViewById(R.id.deleteLike);
        save = findViewById(R.id.save);
        showUser = findViewById(R.id.showUser);
        likeCount = findViewById(R.id.likeCount);
        infoBox = findViewById(R.id.infoBox);
        emailEditText = findViewById(R.id.emailEditText);
        passEditText = findViewById(R.id.passEditText);
        repPassEditText = findViewById(R.id.repPassEditText);
        res = getResources();

        likeCount.setText(res.getString(R.string.likes, String.valueOf(likeCounter)));

        addLike.setOnClickListener(v -> {
            likeCounter++;
            likeCount.setText(res.getString(R.string.likes, String.valueOf(likeCounter)));
        });
        deleteLike.setOnClickListener(v -> {
            if(likeCounter > 0){
                likeCounter--;
            }
            likeCount.setText(res.getString(R.string.likes, String.valueOf(likeCounter)));
        });
        save.setOnClickListener(v -> checkForm());
        showUser.setOnClickListener(v -> showUser());
    }
    public void checkForm(){
        String emailContent = String.valueOf(emailEditText.getText());
        String passContent = String.valueOf(passEditText.getText());
        String repPassContent = String.valueOf(repPassEditText.getText());

        if(!emailContent.contains("@")){
            infoBox.setText("Nieprawidłowy adres e-mail");
        }else if(!passContent.equals(repPassContent)){
            infoBox.setText("Hasła się różnią");
        }else {
            infoBox.setText("Zarejestrowano " + emailContent);
            lastRegisteredEmail = emailContent;
        }
    }
    public void showUser(){
            infoBox.setText(lastRegisteredEmail);
    }
}