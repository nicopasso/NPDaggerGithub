package it.nicopasso.npdaggergithub.Activities.Modules;

import dagger.Module;
import dagger.Provides;
import it.nicopasso.npdaggergithub.Activities.ActivityScope;
import it.nicopasso.npdaggergithub.Activities.Presenters.RepositoriesDetailsActivityPresenter;
import it.nicopasso.npdaggergithub.Activities.RepositoriesDetailsActivity;
import it.nicopasso.npdaggergithub.Activities.RepositoriesListActivity;

/**
 * Created by niccolo on 25/06/15.
 */
@Module
public class RepositoriesDetailsActivityModule {

    private RepositoriesDetailsActivity repositoriesDetailsActivity;

    public RepositoriesDetailsActivityModule(RepositoriesDetailsActivity repositoriesDetailsActivity) {
        this.repositoriesDetailsActivity = repositoriesDetailsActivity;
    }

    @Provides
    @ActivityScope
    RepositoriesDetailsActivity providesRepositoryDetailsActivity() {
        return repositoriesDetailsActivity;
    }

    @Provides
    @ActivityScope
    RepositoriesDetailsActivityPresenter providesRepositoriesDetailsActivityPresenter() {
        return new RepositoriesDetailsActivityPresenter(repositoriesDetailsActivity);
    }

}
