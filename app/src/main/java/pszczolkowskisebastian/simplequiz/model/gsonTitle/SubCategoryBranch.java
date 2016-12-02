package pszczolkowskisebastian.simplequiz.model.gsonTitle;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Sebastian on 01.12.2016.
 */
public class SubCategoryBranch implements Parcelable {

    @SerializedName("id")
    @Expose
    public Long id;
    @SerializedName("name")
    @Expose
    public String name;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.id);
        dest.writeString(this.name);
    }

    public SubCategoryBranch() {
    }

    protected SubCategoryBranch(Parcel in) {
        this.id = (Long) in.readValue(Long.class.getClassLoader());
        this.name = in.readString();
    }

    public static final Creator<SubCategoryBranch> CREATOR = new Creator<SubCategoryBranch>() {
        @Override
        public SubCategoryBranch createFromParcel(Parcel source) {
            return new SubCategoryBranch(source);
        }

        @Override
        public SubCategoryBranch[] newArray(int size) {
            return new SubCategoryBranch[size];
        }
    };
}
