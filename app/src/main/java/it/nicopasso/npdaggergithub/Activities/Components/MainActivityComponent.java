package it.nicopasso.npdaggergithub.Activities.Components;

import dagger.Component;
import it.nicopasso.npdaggergithub.Activities.ActivityScope;
import it.nicopasso.npdaggergithub.Activities.MainActivity;
import it.nicopasso.npdaggergithub.Activities.Modules.MainActivityModule;
import it.nicopasso.npdaggergithub.Activities.Presenters.MainActivityPresenter;
import it.nicopasso.npdaggergithub.ApplicationComponent;

/**
 * Created by niccolo on 24/06/15.
 */
@ActivityScope
@Component(
        modules = MainActivityModule.class,
        dependencies = ApplicationComponent.class
)
public interface MainActivityComponent {

    //We have to refer in which classes we want to inject dependencies from this component
    MainActivity inject(MainActivity mainActivity);

    MainActivityPresenter presenter();
}
