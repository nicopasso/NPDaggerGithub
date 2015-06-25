package it.nicopasso.npdaggergithub.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import it.nicopasso.npdaggergithub.Activities.Components.DaggerRepositoriesDetailsActivityComponent;
import it.nicopasso.npdaggergithub.Activities.Modules.RepositoriesDetailsActivityModule;
import it.nicopasso.npdaggergithub.Activities.Presenters.RepositoriesDetailsActivityPresenter;
import it.nicopasso.npdaggergithub.ApplicationComponent;
import it.nicopasso.npdaggergithub.Model.Repository;
import it.nicopasso.npdaggergithub.R;

/**
 * Created by niccolo on 25/06/15.
 */
public class RepositoriesDetailsActivity extends BaseActivity {

    private static final String ARG_REPOS = "arg_repos";

    @InjectView(R.id.repo_name_text)
    TextView mRepoNameText;
    @InjectView(R.id.repo_detail_text)
    TextView mRepoDetailsText;

    @Inject
    RepositoriesDetailsActivityPresenter presenter;

    private Repository repository;

    public static void startWithRepository(Repository repository, Activity startingActivity) {
        Intent intent = new Intent(startingActivity, RepositoriesDetailsActivity.class);
        intent.putExtra(ARG_REPOS, repository);
        startingActivity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_details_repos);

        ButterKnife.inject(this);

        repository = getIntent().getParcelableExtra(ARG_REPOS);
        mRepoNameText.setText(repository.name());
        mRepoDetailsText.setText(repository.url());
    }

    @Override
    protected void setupActivityComponent(ApplicationComponent applicationComponent) {
        DaggerRepositoriesDetailsActivityComponent.builder()
                .applicationComponent(applicationComponent)
                .repositoriesDetailsActivityModule(new RepositoriesDetailsActivityModule(this))
                .build()
                .inject(this);
    }


}
