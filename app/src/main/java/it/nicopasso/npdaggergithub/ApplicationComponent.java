package it.nicopasso.npdaggergithub;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Component;
import it.nicopasso.npdaggergithub.DaggerModules.ApplicationModule;
import it.nicopasso.npdaggergithub.DaggerModules.GithubApiModule;
import it.nicopasso.npdaggergithub.Managers.RepositoryManager;
import it.nicopasso.npdaggergithub.Managers.UserManager;

/**
 * Created by niccolo on 23/06/15.
 */
@Singleton
@Component(
        modules = {
                ApplicationModule.class,
                GithubApiModule.class
        }
)
public interface ApplicationComponent {

    //void inject(GithubDaggerApplication application);

    Application getApplication();

    UserManager getUserManager();

    RepositoryManager getRepositoryManager();

}
