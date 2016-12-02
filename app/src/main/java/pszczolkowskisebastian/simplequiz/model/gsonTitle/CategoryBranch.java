package pszczolkowskisebastian.simplequiz.model.gsonTitle;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Sebastian on 01.12.2016.
 */
public class CategoryBranch implements Parcelable {

    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("type")
    @Expose
    public String type;
    @SerializedName("uid")
    @Expose
    public Long uid;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.type);
        dest.writeValue(this.uid);
    }

    public CategoryBranch() {
    }

    protected CategoryBranch(Parcel in) {
        this.name = in.readString();
        this.type = in.readString();
        this.uid = (Long) in.readValue(Long.class.getClassLoader());
    }

    public static final Creator<CategoryBranch> CREATOR = new Creator<CategoryBranch>() {
        @Override
        public CategoryBranch createFromParcel(Parcel source) {
            return new CategoryBranch(source);
        }

        @Override
        public CategoryBranch[] newArray(int size) {
            return new CategoryBranch[size];
        }
    };
}
