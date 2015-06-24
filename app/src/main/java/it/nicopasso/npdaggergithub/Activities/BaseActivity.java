package it.nicopasso.npdaggergithub.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import it.nicopasso.npdaggergithub.ApplicationComponent;
import it.nicopasso.npdaggergithub.GithubDaggerApplication;

/**
 * Created by niccolo on 23/06/15.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setupActivityComponent(GithubDaggerApplication.get(this).getApplicationComponent());
    }

    protected abstract void setupActivityComponent(ApplicationComponent applicationComponent);
}
