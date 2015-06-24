package it.nicopasso.npdaggergithub;

import android.app.Application;
import android.content.Context;

import it.nicopasso.npdaggergithub.DaggerModules.ApplicationModule;
import it.nicopasso.npdaggergithub.DaggerModules.GithubApiModule;

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

        //After we have create all of the dependencies, build the project. Dagger will create the DaggerApplicationComponent class
       applicationComponent = DaggerApplicationComponent.builder()
               .applicationModule(new ApplicationModule(this))
               .githubApiModule(new GithubApiModule())
               .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
