package pszczolkowskisebastian.simplequiz.model.gsonQuestion;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Sebastian on 02.12.2016.
 */

public class Celebrity implements Parcelable {

    @SerializedName("result")
    @Expose
    private String result;
    @SerializedName("imageAuthor")
    @Expose
    private String imageAuthor;
    @SerializedName("imageHeight")
    @Expose
    private String imageHeight;
    @SerializedName("imageUrl")
    @Expose
    private String imageUrl;
    @SerializedName("show")
    @Expose
    private Integer show;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("imageTitle")
    @Expose
    private String imageTitle;
    @SerializedName("imageWidth")
    @Expose
    private String imageWidth;
    @SerializedName("content")
    @Expose
    private String content;
    @SerializedName("imageSource")
    @Expose
    private String imageSource;

    /**
     * @return The result
     */
    public String getResult() {
        return result;
    }

    /**
     * @param result The result
     */
    public void setResult(String result) {
        this.result = result;
    }

    /**
     * @return The imageAuthor
     */
    public String getImageAuthor() {
        return imageAuthor;
    }

    /**
     * @param imageAuthor The imageAuthor
     */
    public void setImageAuthor(String imageAuthor) {
        this.imageAuthor = imageAuthor;
    }

    /**
     * @return The imageHeight
     */
    public String getImageHeight() {
        return imageHeight;
    }

    /**
     * @param imageHeight The imageHeight
     */
    public void setImageHeight(String imageHeight) {
        this.imageHeight = imageHeight;
    }

    /**
     * @return The imageUrl
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * @param imageUrl The imageUrl
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * @return The show
     */
    public Integer getShow() {
        return show;
    }

    /**
     * @param show The show
     */
    public void setShow(Integer show) {
        this.show = show;
    }

    /**
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return The imageTitle
     */
    public String getImageTitle() {
        return imageTitle;
    }

    /**
     * @param imageTitle The imageTitle
     */
    public void setImageTitle(String imageTitle) {
        this.imageTitle = imageTitle;
    }

    /**
     * @return The imageWidth
     */
    public String getImageWidth() {
        return imageWidth;
    }

    /**
     * @param imageWidth The imageWidth
     */
    public void setImageWidth(String imageWidth) {
        this.imageWidth = imageWidth;
    }

    /**
     * @return The content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content The content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return The imageSource
     */
    public String getImageSource() {
        return imageSource;
    }

    /**
     * @param imageSource The imageSource
     */
    public void setImageSource(String imageSource) {
        this.imageSource = imageSource;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.result);
        dest.writeString(this.imageAuthor);
        dest.writeString(this.imageHeight);
        dest.writeString(this.imageUrl);
        dest.writeValue(this.show);
        dest.writeString(this.name);
        dest.writeString(this.imageTitle);
        dest.writeString(this.imageWidth);
        dest.writeString(this.content);
        dest.writeString(this.imageSource);
    }

    public Celebrity() {
    }

    protected Celebrity(Parcel in) {
        this.result = in.readString();
        this.imageAuthor = in.readString();
        this.imageHeight = in.readString();
        this.imageUrl = in.readString();
        this.show = (Integer) in.readValue(Integer.class.getClassLoader());
        this.name = in.readString();
        this.imageTitle = in.readString();
        this.imageWidth = in.readString();
        this.content = in.readString();
        this.imageSource = in.readString();
    }

    public static final Parcelable.Creator<Celebrity> CREATOR = new Parcelable.Creator<Celebrity>() {
        @Override
        public Celebrity createFromParcel(Parcel source) {
            return new Celebrity(source);
        }

        @Override
        public Celebrity[] newArray(int size) {
            return new Celebrity[size];
        }
    };
}
