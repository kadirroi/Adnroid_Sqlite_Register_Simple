package com.example.register;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		final DatabaseHandler db = new DatabaseHandler(this);
		final Intent intent = new Intent(this, Home.class);
		Button signup = (Button) findViewById(R.id.button1);
		
		signup.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Bundle bundle = new Bundle();
		         
				EditText username = (EditText) findViewById(R.id.editText_register_username);
				EditText password = (EditText) findViewById(R.id.editText_register_password);
				String userName = username.getText().toString();
				String userPassword = password.getText().toString();
				// Burda veritabanýna kaydetmen gerekiyor
				db.addUser(new User(userName,userPassword));
				
				bundle.putString("userName", userName);
				bundle.putString("userPassword", userPassword);
				intent.putExtras(bundle);
				startActivity(intent);
			
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
