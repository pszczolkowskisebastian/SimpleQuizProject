package pszczolkowskisebastian.simplequiz.model.gsonQuestion;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Sebastian on 02.12.2016.
 */


public class SubImageBranch implements Parcelable {

    @SerializedName("author")
    @Expose
    private String author;
    @SerializedName("width")
    @Expose
    private String width;
    @SerializedName("mediaId")
    @Expose
    private String mediaId;
    @SerializedName("source")
    @Expose
    private String source;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("height")
    @Expose
    private String height;

    /**
     * @return The author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author The author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @return The width
     */
    public String getWidth() {
        return width;
    }

    /**
     * @param width The width
     */
    public void setWidth(String width) {
        this.width = width;
    }

    /**
     * @return The mediaId
     */
    public String getMediaId() {
        return mediaId;
    }

    /**
     * @param mediaId The mediaId
     */
    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    /**
     * @return The source
     */
    public String getSource() {
        return source;
    }

    /**
     * @param source The source
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * @return The url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return The height
     */
    public String getHeight() {
        return height;
    }

    /**
     * @param height The height
     */
    public void setHeight(String height) {
        this.height = height;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.author);
        dest.writeString(this.width);
        dest.writeString(this.mediaId);
        dest.writeString(this.source);
        dest.writeString(this.url);
        dest.writeString(this.height);
    }

    public SubImageBranch() {
    }

    protected SubImageBranch(Parcel in) {
        this.author = in.readString();
        this.width = in.readString();
        this.mediaId = in.readString();
        this.source = in.readString();
        this.url = in.readString();
        this.height = in.readString();
    }

    public static final Parcelable.Creator<SubImageBranch> CREATOR = new Parcelable.Creator<SubImageBranch>() {
        @Override
        public SubImageBranch createFromParcel(Parcel source) {
            return new SubImageBranch(source);
        }

        @Override
        public SubImageBranch[] newArray(int size) {
            return new SubImageBranch[size];
        }
    };
}
