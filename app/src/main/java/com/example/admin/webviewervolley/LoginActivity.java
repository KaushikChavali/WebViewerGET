package com.example.admin.webviewervolley;

/**
 * Created by admin on 8/16/2014.
 */
        import android.app.Activity;
        import android.content.Intent;
        import android.os.Bundle;
        import android.text.method.ScrollingMovementMethod;
        import android.view.View;
        import android.widget.EditText;
        import android.widget.ProgressBar;
        import android.widget.TextView;
        import android.widget.Toast;

        import java.util.ArrayList;

/**
 * Created by admin on 7/23/2014.
 */
public class LoginActivity extends Activity {

    public final static String EXTRA_NAME = "com.example.admin.webviewer.NAME";
    public final static String EXTRA_PASS = "com.example.admin.webviewer.PASS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


    }

    public void onClick(View view){

        Intent intent = new Intent(this, MyActivity.class);

        EditText txt1 = (EditText) findViewById(R.id.user);
        String username = txt1.getText().toString();

        EditText txt2 = (EditText) findViewById(R.id.pass);
        String pass = txt2.getText().toString();

        intent.putExtra(EXTRA_NAME, username);
        intent.putExtra(EXTRA_PASS, pass);

        startActivity(intent);
    }
}
