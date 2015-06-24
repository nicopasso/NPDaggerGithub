package it.nicopasso.npdaggergithub.Model;

import android.os.Parcel;
import android.os.Parcelable;

import auto.parcel.AutoParcel;

/**
 * Created by niccolo on 24/06/15.
 */
@AutoParcel
public abstract class Repository implements Parcelable {

    public abstract long id();
    public abstract String name();
    public abstract String url();

    public static Repository create(long id, String name, String url) {
        return new AutoParcel_Repository(id, name, url);
    }

    /*public Repository() {
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
    }*/
}
