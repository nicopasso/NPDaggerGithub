package it.nicopasso.npdaggergithub.Activities.Modules;

import dagger.Module;
import dagger.Provides;
import it.nicopasso.npdaggergithub.Activities.ActivityScope;
import it.nicopasso.npdaggergithub.Activities.Presenters.RepositoriesListActivityPresenter;
import it.nicopasso.npdaggergithub.Activities.RepositoriesListActivity;
import it.nicopasso.npdaggergithub.Managers.RepositoryManager;

/**
 * Created by niccolo on 24/06/15.
 */
@Module
public class RepositoriesListActivityModule {

    private RepositoriesListActivity repositoriesListActivity;

    public RepositoriesListActivityModule(RepositoriesListActivity repositoriesListActivity) {
        this.repositoriesListActivity = repositoriesListActivity;
    }

    @Provides
    @ActivityScope
    RepositoriesListActivity provideRepositoriesListActivity() {
        return repositoriesListActivity;
    }

    @Provides
    @ActivityScope
    RepositoriesListActivityPresenter provideRepositoriesListActivityPresenter(RepositoryManager repositoryManager) {
        return new RepositoriesListActivityPresenter(repositoriesListActivity, repositoryManager);
    }


}
