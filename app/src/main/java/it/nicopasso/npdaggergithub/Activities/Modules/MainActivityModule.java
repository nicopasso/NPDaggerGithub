package it.nicopasso.npdaggergithub.Activities.Modules;

import dagger.Module;
import dagger.Provides;
import it.nicopasso.npdaggergithub.Activities.ActivityScope;
import it.nicopasso.npdaggergithub.Activities.MainActivity;
import it.nicopasso.npdaggergithub.Activities.Presenters.MainActivityPresenter;
import it.nicopasso.npdaggergithub.Managers.UserManager;

/**
 * Created by niccolo on 24/06/15.
 */
@Module
public class MainActivityModule {

    private MainActivity mainActivity;

    public MainActivityModule(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Provides
    @ActivityScope
    MainActivity provideMainActivity() {
        return mainActivity;
    }

    @Provides
    @ActivityScope
    MainActivityPresenter provideMainActivityPresenter(UserManager userManager) {
        return new MainActivityPresenter(mainActivity, userManager);
    }

}
