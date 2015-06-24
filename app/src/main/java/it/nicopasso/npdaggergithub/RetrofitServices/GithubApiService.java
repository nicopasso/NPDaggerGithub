package it.nicopasso.npdaggergithub.RetrofitServices;

import java.util.List;

import it.nicopasso.npdaggergithub.Model.RepositoryResponse;
import it.nicopasso.npdaggergithub.Model.UserResponse;
import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

/**
 * Created by niccolo on 23/06/15.
 */
public interface GithubApiService {

    @GET("/users/{username}")
    Observable<UserResponse> getUserInfo(@Path("username") String username);

    @GET("/users/{username}/repos")
    Observable<List<RepositoryResponse>> getUserRepos(@Path("username") String username);

}
