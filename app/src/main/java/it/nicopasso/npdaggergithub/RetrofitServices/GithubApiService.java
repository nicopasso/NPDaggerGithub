package it.nicopasso.npdaggergithub.RetrofitServices;

import java.util.List;

import it.nicopasso.npdaggergithub.Model.Repository;
import it.nicopasso.npdaggergithub.Model.User;
import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

/**
 * Created by niccolo on 23/06/15.
 */
public interface GithubApiService {

    @GET("/users/{username}")
    Observable<User> getUserInfo(@Path("username") String username);

    @GET("/users/{username}/repos")
    Observable<List<Repository>> getUserRepos(@Path("username") String username);

}
