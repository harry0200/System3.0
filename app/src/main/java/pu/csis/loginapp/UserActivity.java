package pu.csis.loginapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaParser;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class UserActivity extends AppCompatActivity {

    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        mp = MediaPlayer.create(getApplicationContext(),R.raw.dingdong);
        mp.start();



        Bundle data = this.getIntent().getExtras();
        String name = data.getString("account");
        int age = data.getInt("age");


        Button webbtn = findViewById(R.id.webbtn);
        webbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri web = Uri.parse("http://www.pu.edu.tw");
                Intent it = new Intent(Intent.ACTION_VIEW,web);
                startActivity(it);
            }
        });
        Button feedback = findViewById(R.id.feedback);
        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(1000);
                Intent intent = new Intent(UserActivity.this, feedback.class);
                startActivity(intent);
            }
        });
        Button complain = findViewById(R.id.complain);
        complain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserActivity.this, complain.class);
                startActivity(intent);
            }
        });
        Button donate = findViewById(R.id.donate);
        donate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(1000);
                Intent it = new Intent(getApplicationContext(),donateActivity.class);
                startActivity(it);
            }
        });
        Button exit = findViewById(R.id.exit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(1000);
                Intent it = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(it);
                finish();
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("log","onStop");
        //mp.stop();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("log","onPause");
        mp.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mp.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu,menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.id1:
                Toast.makeText(getApplicationContext(), "select item1", Toast.LENGTH_SHORT).show();
                Button feedback = findViewById(R.id.id1);
                feedback.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Intent intent = new Intent(UserActivity.this, feedback.class);
                        startActivity(intent);
                    }
                });
                break;
            case R.id.id2:
                Toast.makeText(getApplicationContext(), "select item2", Toast.LENGTH_SHORT).show();
                Button complain = findViewById(R.id.id2);
                complain.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Intent intent = new Intent(UserActivity.this, complain.class);
                        startActivity(intent);
                    }
                });
                break;
            case R.id.id3:
                Toast.makeText(getApplicationContext(), "select item3", Toast.LENGTH_SHORT).show();
                Button donate = findViewById(R.id.id3);
                donate.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        Intent intent = new Intent(UserActivity.this, donateActivity.class);
                        startActivity(intent);
                    }
                });
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}