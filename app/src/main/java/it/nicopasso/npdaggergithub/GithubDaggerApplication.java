package it.nicopasso.npdaggergithub;

import android.app.Application;
import android.content.Context;

/**
 * Created by niccolo on 23/06/15.
 */
public class GithubDaggerApplication extends Application {

    private ApplicationComponent applicationComponent;

    public static GithubDaggerApplication get(Context context) {
        return (GithubDaggerApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        //TODO: creare il component
        getApplicationComponent().inject(this);
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
