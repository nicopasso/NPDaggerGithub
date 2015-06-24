package it.nicopasso.npdaggergithub.Activities.Presenters;

import com.google.common.collect.ImmutableList;

import it.nicopasso.npdaggergithub.Activities.RepositoriesListActivity;
import it.nicopasso.npdaggergithub.Managers.RepositoryManager;
import it.nicopasso.npdaggergithub.Model.Repository;
import it.nicopasso.npdaggergithub.SimpleObserver;

/**
 * Created by niccolo on 24/06/15.
 */
public class RepositoriesListActivityPresenter {

    private RepositoriesListActivity repositoriesListActivity;
    private RepositoryManager repositoryManager;

    public RepositoriesListActivityPresenter(RepositoriesListActivity repositoriesListActivity, RepositoryManager repositoryManager) {
        this.repositoriesListActivity = repositoriesListActivity;
        this.repositoryManager = repositoryManager;
    }

    public void initWithUsername(String username) {
        repositoriesListActivity.showLoading(true);
        repositoryManager.getUsersRepos(username).subscribe(new SimpleObserver<ImmutableList<Repository>>() {

            @Override
            public void onNext(ImmutableList<Repository> repositories) {
                repositoriesListActivity.showLoading(false);
                repositoriesListActivity.setRepositories(repositories);
            }

            @Override
            public void onError(Throwable e) {
                repositoriesListActivity.showLoading(false);
            }
        });
    }

}
