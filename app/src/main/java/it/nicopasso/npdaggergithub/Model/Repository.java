package it.nicopasso.npdaggergithub.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by niccolo on 24/06/15.
 */
public class Repository implements Parcelable {

    public long id;
    public String name;
    public String url;

    public Repository() {
    }

    private Repository(Parcel in) {
        this.id = in.readLong();
        this.name = in.readString();
        this.url = in.readString();
    }

    public static final Creator<Repository> CREATOR = new Creator<Repository>() {
        @Override
        public Repository createFromParcel(Parcel in) {
            return new Repository(in);
        }

        @Override
        public Repository[] newArray(int size) {
            return new Repository[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeString(this.name);
        dest.writeString(this.url);
    }
}
