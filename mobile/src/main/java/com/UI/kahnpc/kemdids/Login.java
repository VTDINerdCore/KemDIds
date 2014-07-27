package com.UI.kahnpc.kemdids;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

import com.UI.kahnpc.kemdids.Database.DBAdapter;
import com.UI.kahnpc.kemdids.R;

public class Login extends Activity {

    private static final String TAG = "Tag Test";
    DBAdapter myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new LoginFragment())
                    .commit();
            Log.d(TAG, "Login activity launched");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        closeDB();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    ////////////////////////////////////////////
    //           Database Operations          //
    ////////////////////////////////////////////
    private void openDB() {
        myDB = new DBAdapter(this);
        myDB.open();
    }

    private void closeDB() {
        myDB.close();
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class LoginFragment extends Fragment {

        public LoginFragment() {

        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_login, container, false);
            return rootView;
        }
    }
}
