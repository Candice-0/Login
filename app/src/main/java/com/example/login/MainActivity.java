package com.example.login;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.login);
        //loginButton.setOnClickListener(new View.OnClickListener(){
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                final LayoutInflater inflater = getLayoutInflater();
                final View v1 = inflater.inflate(R.layout.login_dialog, null);
                builder.setView(v1).setTitle("登录").setPositiveButton(R.string.login, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        EditText userID = v1.findViewById(R.id.editUserId);
                        EditText password = v1.findViewById(R.id.editPassword);
                        // if (!userID.getText().equals(null) && !password.getText().equals(null)) {
                        if (userID.getText().toString().equals("abc") && password.getText().toString().equals("123")) {
                            Toast.makeText(MainActivity.this, "登录成功！", Toast.LENGTH_SHORT).show();
                        } else if (!userID.getText().toString().equals("abc") && password.getText().toString().equals("123"))
                            Toast.makeText(MainActivity.this, "用户名错误！", Toast.LENGTH_SHORT).show();
                        else if (userID.getText().toString().equals("abc") && !password.getText().toString().equals("123"))
                            Toast.makeText(MainActivity.this, "密码错误！", Toast.LENGTH_SHORT).show();
                        else if (userID.getText().toString().equals(""))
                            Toast.makeText(MainActivity.this, "用户名不能为空！", Toast.LENGTH_SHORT).show();
                        else if (password.getText().toString().equals(""))
                            Toast.makeText(MainActivity.this, "密码不能为空！", Toast.LENGTH_SHORT).show();
                        // }
                    }
                }).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.show();
            }

        });
        button = (Button) findViewById(R.id.findPassword);
        //loginButton.setOnClickListener(new View.OnClickListener(){
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                final LayoutInflater inflater = getLayoutInflater();
                final View v1 = inflater.inflate(R.layout.password_dialog, null);
                builder.setView(v1).setTitle("找回密码").setPositiveButton(R.string.findPassword, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        EditText password = v1.findViewById(R.id.editText);
                        if (password.getText().toString().equals("abc")) {
                            Toast.makeText(MainActivity.this, "密码为：123", Toast.LENGTH_LONG).show();
                        }
                    }
                }).setNegativeButton(R.string.back, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.show();
            }

        });

    }
}
