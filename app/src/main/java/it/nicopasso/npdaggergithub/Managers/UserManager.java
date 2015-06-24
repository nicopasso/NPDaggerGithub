package it.nicopasso.npdaggergithub.Managers;

import javax.inject.Inject;

import it.nicopasso.npdaggergithub.Model.User;
import it.nicopasso.npdaggergithub.Model.UserResponse;
import it.nicopasso.npdaggergithub.RetrofitServices.GithubApiService;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by niccolo on 24/06/15.
 */
public class UserManager {

    private GithubApiService githubApiService;

    //@Inject
    public UserManager(GithubApiService githubApiService) {
        this.githubApiService = githubApiService;
    }

    public Observable<User> getUser(final String username) {
        return githubApiService.getUserInfo(username)
                .map(new Func1<UserResponse, User>() {
                    @Override
                    public User call(UserResponse userResponse) {
                        User user = new User();
                        user.login = userResponse.login;
                        user.id = userResponse.id;
                        user.url = userResponse.url;
                        user.email = userResponse.email;
                        return user;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }


}
