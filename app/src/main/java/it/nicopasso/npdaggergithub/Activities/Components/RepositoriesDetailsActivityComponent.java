package it.nicopasso.npdaggergithub.Activities.Components;

import dagger.Component;
import it.nicopasso.npdaggergithub.Activities.ActivityScope;
import it.nicopasso.npdaggergithub.Activities.Modules.RepositoriesDetailsActivityModule;
import it.nicopasso.npdaggergithub.Activities.Presenters.RepositoriesDetailsActivityPresenter;
import it.nicopasso.npdaggergithub.Activities.RepositoriesDetailsActivity;
import it.nicopasso.npdaggergithub.ApplicationComponent;

/**
 * Created by niccolo on 25/06/15.
 */
@ActivityScope
@Component(
        modules = RepositoriesDetailsActivityModule.class,
        dependencies = ApplicationComponent.class
)
public interface RepositoriesDetailsActivityComponent {

        RepositoriesDetailsActivity inject(RepositoriesDetailsActivity repositoriesDetailsActivity);

        RepositoriesDetailsActivityPresenter presenter();

}
