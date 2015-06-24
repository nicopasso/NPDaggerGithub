package it.nicopasso.npdaggergithub.Activities.Components;

import dagger.Component;
import it.nicopasso.npdaggergithub.Activities.ActivityScope;
import it.nicopasso.npdaggergithub.Activities.Modules.RepositoriesListActivityModule;
import it.nicopasso.npdaggergithub.Activities.Presenters.RepositoriesListActivityPresenter;
import it.nicopasso.npdaggergithub.Activities.RepositoriesListActivity;
import it.nicopasso.npdaggergithub.ApplicationComponent;

/**
 * Created by niccolo on 24/06/15.
 */
@ActivityScope
@Component(
        modules = RepositoriesListActivityModule.class,
        dependencies = ApplicationComponent.class
)
public interface RepositoriesListActivityComponent {

    RepositoriesListActivity inject(RepositoriesListActivity repositoriesListActivity);

    RepositoriesListActivityPresenter presenter();

}
