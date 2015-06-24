package it.nicopasso.npdaggergithub.Managers;

import com.google.common.collect.ImmutableList;

import java.util.List;

import javax.inject.Inject;

import it.nicopasso.npdaggergithub.Model.Repository;
import it.nicopasso.npdaggergithub.Model.RepositoryResponse;
import it.nicopasso.npdaggergithub.RetrofitServices.GithubApiService;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by niccolo on 24/06/15.
 */
public class RepositoryManager {

    private GithubApiService githubApiService;

    @Inject
    public RepositoryManager(GithubApiService githubApiService) {
        this.githubApiService = githubApiService;
    }

    public Observable<ImmutableList<Repository>> getUsersRepos(String username) {
        return githubApiService.getUserRepos(username)
                .map(new Func1<List<RepositoryResponse>, ImmutableList<Repository>>() {
                    @Override
                    public ImmutableList<Repository> call(List<RepositoryResponse> repositoryListResponse) {
                        final ImmutableList.Builder<Repository> listBuilder = ImmutableList.builder();

                        for (RepositoryResponse repositoryResponse : repositoryListResponse) {
                            Repository repo = new Repository();
                            repo.id = repositoryResponse.id;
                            repo.name = repositoryResponse.name;
                            repo.url = repositoryResponse.url;
                            listBuilder.add(repo);
                        }

                        return listBuilder.build();
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
