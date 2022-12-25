package pu.csis.loginapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.login) ;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText name = findViewById(R.id.id);
                EditText pw = findViewById(R.id.pw);
                if( ( name.getText().toString().equals("harry0200")) &&
                        ( pw.getText().toString().equals("741852963")))
                {
                    Bundle data = new Bundle();
                    data.putString("account",name.getText().toString());
                    data.putInt("age",24);

                    Intent it = new Intent(getApplicationContext(),UserActivity.class);
                    it.putExtras(data);
                    startActivityForResult(it,100);
                    Toast.makeText(getApplicationContext(),"歡迎回來",Toast.LENGTH_LONG).show();
                    String name2 = data.getString("account");
                    Toast.makeText(getApplicationContext(),name2,Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(), "登入失敗", Toast.LENGTH_LONG).show();
                }

            }
        }

        );
        Button createaccount = findViewById(R.id.createaccount);
        createaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle data = new Bundle();
                Intent intent = new Intent(MainActivity.this,createActivity.class);
                startActivity(intent);
            }
        });
        Button exit = findViewById(R.id.leave);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(1000);
                Toast.makeText(getApplicationContext(), "再見", Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 100){
            if(requestCode == 1000)
            Toast.makeText(getApplicationContext(),"回傳OK",Toast.LENGTH_LONG).show();
        }
    }


}
