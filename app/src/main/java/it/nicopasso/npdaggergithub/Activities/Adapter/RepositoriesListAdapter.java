package it.nicopasso.npdaggergithub.Activities.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;
import it.nicopasso.npdaggergithub.Model.Repository;

/**
 * Created by niccolo on 24/06/15.
 */
public class RepositoriesListAdapter extends ArrayAdapter<Repository> {

    private LayoutInflater inflater;

    public RepositoriesListAdapter(Context context, List<Repository> objects) {
        super(context, 0, objects);
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        RepositoryHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
            holder = new RepositoryHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (RepositoryHolder)convertView.getTag();
        }

        Repository repository = getItem(position);
        holder.text1.setText(repository.name);

        return convertView;

    }

    static class RepositoryHolder {
        @InjectView(android.R.id.text1)
        TextView text1;

        public RepositoryHolder(View view) {
            ButterKnife.inject(this, view);
        }
    }
}
