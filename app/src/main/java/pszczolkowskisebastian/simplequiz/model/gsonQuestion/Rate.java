package pszczolkowskisebastian.simplequiz.model.gsonQuestion;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Sebastian on 02.12.2016.
 */

public class Rate implements Parcelable {

    @SerializedName("from")
    @Expose
    private Integer from;
    @SerializedName("to")
    @Expose
    private Integer to;
    @SerializedName("content")
    @Expose
    private String content;

    /**
     * @return The from
     */
    public Integer getFrom() {
        return from;
    }

    /**
     * @param from The from
     */
    public void setFrom(Integer from) {
        this.from = from;
    }

    /**
     * @return The to
     */
    public Integer getTo() {
        return to;
    }

    /**
     * @param to The to
     */
    public void setTo(Integer to) {
        this.to = to;
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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.from);
        dest.writeValue(this.to);
        dest.writeString(this.content);
    }

    public Rate() {
    }

    protected Rate(Parcel in) {
        this.from = (Integer) in.readValue(Integer.class.getClassLoader());
        this.to = (Integer) in.readValue(Integer.class.getClassLoader());
        this.content = in.readString();
    }

    public static final Parcelable.Creator<Rate> CREATOR = new Parcelable.Creator<Rate>() {
        @Override
        public Rate createFromParcel(Parcel source) {
            return new Rate(source);
        }

        @Override
        public Rate[] newArray(int size) {
            return new Rate[size];
        }
    };
}
