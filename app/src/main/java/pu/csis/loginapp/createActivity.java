package pu.csis.loginapp;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class createActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        Button create = findViewById(R.id.create) ;
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText E_mail = findViewById(R.id.E_mail);
                EditText create_pw = findViewById(R.id.create_pw);
                EditText check_pw = findViewById(R.id.check_pw);
                if((create_pw.getText().toString().equals("1")) == ( check_pw.getText().toString()).equals("1"))
                {
                    Bundle data = new Bundle();
                    data.putString("account",E_mail.getText().toString());

                    Intent it = new Intent(getApplicationContext(),UserActivity.class);
                    it.putExtras(data);
                    startActivityForResult(it,100);
                    Toast.makeText(getApplicationContext(), "註冊成功", Toast.LENGTH_LONG).show();
                    Toast.makeText(getApplicationContext(), "歡迎", Toast.LENGTH_LONG).show();
                    String name2 = data.getString("account");
                    Toast.makeText(getApplicationContext(),name2,Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(), "註冊失敗", Toast.LENGTH_LONG).show();
                }

            }
        });
    }


}
