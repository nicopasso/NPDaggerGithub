package it.nicopasso.npdaggergithub.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import it.nicopasso.npdaggergithub.Activities.Components.DaggerMainActivityComponent;
import it.nicopasso.npdaggergithub.Activities.Modules.MainActivityModule;
import it.nicopasso.npdaggergithub.Activities.Presenters.MainActivityPresenter;
import it.nicopasso.npdaggergithub.ApplicationComponent;
import it.nicopasso.npdaggergithub.R;
import it.nicopasso.npdaggergithub.SimpleObserver;
import rx.android.widget.OnTextChangeEvent;
import rx.android.widget.WidgetObservable;

public class MainActivity extends BaseActivity {

    //Butterknife Injection
    @InjectView(R.id.username_edit)
    EditText mUsernameEdit;
    @InjectView(R.id.repos_button)
    Button mReposButton;
    @InjectView(R.id.loading_progress)
    ProgressBar mLoadingProgressBar;

    @Inject
    MainActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.inject(this);

        //Reactive!
        WidgetObservable.text(mUsernameEdit, true).subscribe(new SimpleObserver<OnTextChangeEvent>(){
            @Override
            public void onNext(OnTextChangeEvent onTextChangeEvent) {
                presenter.username = onTextChangeEvent.text().toString();

            }
        });
    }

    @Override
    protected void setupActivityComponent(ApplicationComponent applicationComponent) {
        DaggerMainActivityComponent.builder()
                .applicationComponent(applicationComponent)     //Takes appComponent explicitly (depends on it)
                .mainActivityModule(new MainActivityModule(this))
                .build()
                .inject(this);

    }

    @OnClick(R.id.repos_button)
    public void reposPressed() {
        presenter.onShowsReposClick();
    }

    public void showReposForUser(String username) {
        RepositoriesListActivity.startWithUsername(username, this);
    }

    public void showLoading(boolean loading) {
        mReposButton.setVisibility(loading ? View.GONE : View.VISIBLE);
        mLoadingProgressBar.setVisibility(loading ? View.VISIBLE : View.GONE);
    }


}
