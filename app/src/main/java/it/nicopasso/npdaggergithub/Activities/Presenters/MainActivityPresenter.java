package it.nicopasso.npdaggergithub.Activities.Presenters;

import it.nicopasso.npdaggergithub.Activities.MainActivity;
import it.nicopasso.npdaggergithub.Managers.UserManager;
import it.nicopasso.npdaggergithub.Model.User;
import it.nicopasso.npdaggergithub.SimpleObserver;

/**
 * Created by niccolo on 24/06/15.
 */
public class MainActivityPresenter {

    public String username;

    private MainActivity mainActivity;
    private UserManager userManager;

    public MainActivityPresenter(MainActivity mainActivity, UserManager userManager) {
        this.mainActivity = mainActivity;
        this.userManager = userManager;
    }

    public void onShowsReposClick() {

        mainActivity.showLoading(true);

        userManager.getUser(username).subscribe(new SimpleObserver<User>() {

            @Override
            public void onNext(User user) {
                mainActivity.showLoading(false);
                mainActivity.showReposForUser(username);
            }

            @Override
            public void onError(Throwable e) {
                mainActivity.showLoading(false);
            }
        });

    }

}
