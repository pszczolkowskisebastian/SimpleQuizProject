package pszczolkowskisebastian.simplequiz.model.gsonQuestion;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Sebastian on 02.12.2016.
 */

public class Answer implements Parcelable {

    @SerializedName("image")
    @Expose
    private SubImageBranch image;
    @SerializedName("order")
    @Expose
    private Integer order;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("isCorrect")
    @Expose
    private Integer isCorrect;

    /**
     * @return The image
     */
    public SubImageBranch getImage() {
        return image;
    }

    /**
     * @param image The image
     */
    public void setImage(SubImageBranch image) {
        this.image = image;
    }

    /**
     * @return The order
     */
    public Integer getOrder() {
        return order;
    }

    /**
     * @param order The order
     */
    public void setOrder(Integer order) {
        this.order = order;
    }

    /**
     * @return The text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text The text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return The isCorrect
     */
    public Integer getIsCorrect() {
        return isCorrect;
    }

    /**
     * @param isCorrect The isCorrect
     */
    public void setIsCorrect(Integer isCorrect) {
        this.isCorrect = isCorrect;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.image, flags);
        dest.writeValue(this.order);
        dest.writeString(this.text);
        dest.writeValue(this.isCorrect);
    }

    public Answer() {
    }

    protected Answer(Parcel in) {
        this.image = in.readParcelable(SubImageBranch.class.getClassLoader());
        this.order = (Integer) in.readValue(Integer.class.getClassLoader());
        this.text = in.readString();
        this.isCorrect = (Integer) in.readValue(Integer.class.getClassLoader());
    }

    public static final Parcelable.Creator<Answer> CREATOR = new Parcelable.Creator<Answer>() {
        @Override
        public Answer createFromParcel(Parcel source) {
            return new Answer(source);
        }

        @Override
        public Answer[] newArray(int size) {
            return new Answer[size];
        }
    };
}
