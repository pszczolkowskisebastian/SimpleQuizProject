package pszczolkowskisebastian.simplequiz.model.gsonQuestion;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Sebastian on 02.12.2016.
 */

public class Image implements Parcelable {

    @SerializedName("author")
    @Expose
    private String author;
    @SerializedName("width")
    @Expose
    private Integer width;
    @SerializedName("mediaId")
    @Expose
    private Integer mediaId;
    @SerializedName("source")
    @Expose
    private String source;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("height")
    @Expose
    private Integer height;

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
    public Integer getWidth() {
        return width;
    }

    /**
     * @param width The width
     */
    public void setWidth(Integer width) {
        this.width = width;
    }

    /**
     * @return The mediaId
     */
    public Integer getMediaId() {
        return mediaId;
    }

    /**
     * @param mediaId The mediaId
     */
    public void setMediaId(Integer mediaId) {
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
    public Integer getHeight() {
        return height;
    }

    /**
     * @param height The height
     */
    public void setHeight(Integer height) {
        this.height = height;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.author);
        dest.writeValue(this.width);
        dest.writeValue(this.mediaId);
        dest.writeString(this.source);
        dest.writeString(this.url);
        dest.writeValue(this.height);
    }

    public Image() {
    }

    protected Image(Parcel in) {
        this.author = in.readString();
        this.width = (Integer) in.readValue(Integer.class.getClassLoader());
        this.mediaId = (Integer) in.readValue(Integer.class.getClassLoader());
        this.source = in.readString();
        this.url = in.readString();
        this.height = (Integer) in.readValue(Integer.class.getClassLoader());
    }

    public static final Parcelable.Creator<Image> CREATOR = new Parcelable.Creator<Image>() {
        @Override
        public Image createFromParcel(Parcel source) {
            return new Image(source);
        }

        @Override
        public Image[] newArray(int size) {
            return new Image[size];
        }
    };
}
