package com.example.marvel.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Item implements Parcelable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName(value = "name", alternate = {"title"})
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("modified")
    @Expose
    private String modified;
    @SerializedName("thumbnail")
    @Expose
    private Thumbnail thumbnail;
    @SerializedName("resourceURI")
    @Expose
    private String resourceURI;
    @SerializedName("comics")
    @Expose
    private Comics comics;
    @SerializedName("series")
    @Expose
    private Series series;
    @SerializedName("stories")
    @Expose
    private Stories stories;
    @SerializedName("events")
    @Expose
    private Events events;
    @SerializedName("urls")
    @Expose
    private ArrayList<Url> urls = null;


    protected Item(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        name = in.readString();
        description = in.readString();
        modified = in.readString();
        thumbnail = in.readParcelable(Thumbnail.class.getClassLoader());
        resourceURI = in.readString();
        comics = in.readParcelable(Comics.class.getClassLoader());
        series = in.readParcelable(Series.class.getClassLoader());
        stories = in.readParcelable(Stories.class.getClassLoader());
        events = in.readParcelable(Events.class.getClassLoader());
        urls = in.createTypedArrayList(Url.CREATOR);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(id);
        }
        dest.writeString(name);
        dest.writeString(description);
        dest.writeString(modified);
        dest.writeParcelable(thumbnail, flags);
        dest.writeString(resourceURI);
        dest.writeParcelable(comics, flags);
        dest.writeParcelable(series, flags);
        dest.writeParcelable(stories, flags);
        dest.writeParcelable(events, flags);
        dest.writeTypedList(urls);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }


    public Thumbnail getThumbnail() {
        return thumbnail;
    }


    public Comics getComics() {
        return comics;
    }

    public Series getSeries() {
        return series;
    }


    public Events getEvents() {
        return events;
    }

    public ArrayList<Url> getUrls() {
        return urls;
    }
}
