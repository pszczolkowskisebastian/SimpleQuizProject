package pszczolkowskisebastian.simplequiz.model.gsonTitle;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Sebastian on 01.12.2016.
 */
public class MainPhoto implements Parcelable {

    @SerializedName("author")
    @Expose
    public String author;
    @SerializedName("height")
    @Expose
    public Integer height;
    @SerializedName("source")
    @Expose
    public String source;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("url")
    @Expose
    public String url;
    @SerializedName("width")
    @Expose
    public Integer width;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.author);
        dest.writeValue(this.height);
        dest.writeString(this.source);
        dest.writeString(this.title);
        dest.writeString(this.url);
        dest.writeValue(this.width);
    }

    public MainPhoto() {
    }

    protected MainPhoto(Parcel in) {
        this.author = in.readString();
        this.height = (Integer) in.readValue(Integer.class.getClassLoader());
        this.source = in.readString();
        this.title = in.readString();
        this.url = in.readString();
        this.width = (Integer) in.readValue(Integer.class.getClassLoader());
    }

    public static final Creator<MainPhoto> CREATOR = new Creator<MainPhoto>() {
        @Override
        public MainPhoto createFromParcel(Parcel source) {
            return new MainPhoto(source);
        }

        @Override
        public MainPhoto[] newArray(int size) {
            return new MainPhoto[size];
        }
    };
}
