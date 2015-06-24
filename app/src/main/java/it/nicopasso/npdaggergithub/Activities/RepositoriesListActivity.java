package it.nicopasso.npdaggergithub.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnItemClick;
import it.nicopasso.npdaggergithub.Activities.Adapter.RepositoriesListAdapter;
import it.nicopasso.npdaggergithub.Activities.Components.DaggerRepositoriesListActivityComponent;
import it.nicopasso.npdaggergithub.Activities.Modules.RepositoriesListActivityModule;
import it.nicopasso.npdaggergithub.Activities.Presenters.RepositoriesListActivityPresenter;
import it.nicopasso.npdaggergithub.ApplicationComponent;
import it.nicopasso.npdaggergithub.Model.Repository;
import it.nicopasso.npdaggergithub.R;

/**
 * Created by niccolo on 24/06/15.
 */
public class RepositoriesListActivity extends BaseActivity {

    private static final String ARG_USERNAME = "arg_username";

    @InjectView(R.id.repos_list)
    ListView mReposList;
    @InjectView(R.id.loading_progress)
    ProgressBar mLoadingProgress;

    @Inject
    RepositoriesListActivityPresenter presenter;

    private RepositoriesListAdapter repositoriesListAdapter;

    public static void startWithUsername(String username, Activity startingActivity) {
        Intent intent = new Intent(startingActivity, RepositoriesListActivity.class);
        intent.putExtra(ARG_USERNAME, username);
        startingActivity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_list_repos);
        ButterKnife.inject(this);

        //PRESENTER INIT
        presenter.initWithUsername(getIntent().getStringExtra(ARG_USERNAME));

        //ADAPTER
        repositoriesListAdapter = new RepositoriesListAdapter(this, new ArrayList<Repository>());
        mReposList.setAdapter(repositoriesListAdapter);
    }

    @Override
    protected void setupActivityComponent(ApplicationComponent applicationComponent) {
        DaggerRepositoriesListActivityComponent.builder()
                .applicationComponent(applicationComponent)
                .repositoriesListActivityModule(new RepositoriesListActivityModule(this))
                .build()
                .inject(this);
    }

    public void showLoading(boolean loading) {
        mReposList.setVisibility(loading ? View.GONE : View.VISIBLE);
        mLoadingProgress.setVisibility(loading ? View.VISIBLE : View.GONE);
    }

    public void setRepositories(ImmutableList<Repository> repositories) {
        repositoriesListAdapter.clear();
        repositoriesListAdapter.addAll(repositories);
    }

    @OnItemClick(R.id.repos_list)
    public void onRepositoryPressed(int position) {
        Repository repository = repositoriesListAdapter.getItem(position);
        //TODO: open DetailsActivity
    }
}
