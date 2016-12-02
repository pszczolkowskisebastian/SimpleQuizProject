package pszczolkowskisebastian.simplequiz.model.gsonTitle;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sebastian on 01.12.2016.
 */
public class QuizTitleBranch implements Parcelable {

    @SerializedName("buttonStart")
    @Expose
    public String buttonStart;
    @SerializedName("categories")
    @Expose
    public List<CategoryBranch> categories = new ArrayList<CategoryBranch>();
    @SerializedName("category")
    @Expose
    public SubCategoryBranch category;
    @SerializedName("content")
    @Expose
    public String content;
    @SerializedName("createdAt")
    @Expose
    public String createdAt;
    @SerializedName("id")
    @Expose
    public Long id;
    @SerializedName("mainPhoto")
    @Expose
    public MainPhoto mainPhoto;
    @SerializedName("questions")
    @Expose
    public Integer questions;
    @SerializedName("shareTitle")
    @Expose
    public String shareTitle;
    @SerializedName("sponsored")
    @Expose
    public Boolean sponsored;
    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("type")
    @Expose
    public String type;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.buttonStart);
        dest.writeList(this.categories);
        dest.writeParcelable(this.category, flags);
        dest.writeString(this.content);
        dest.writeString(this.createdAt);
        dest.writeValue(this.id);
        dest.writeParcelable(this.mainPhoto, flags);
        dest.writeValue(this.questions);
        dest.writeString(this.shareTitle);
        dest.writeValue(this.sponsored);
        dest.writeString(this.title);
        dest.writeString(this.type);
    }

    public QuizTitleBranch() {
    }

    protected QuizTitleBranch(Parcel in) {
        this.buttonStart = in.readString();
        this.categories = new ArrayList<CategoryBranch>();
        in.readList(this.categories, CategoryBranch.class.getClassLoader());
        this.category = in.readParcelable(SubCategoryBranch.class.getClassLoader());
        this.content = in.readString();
        this.createdAt = in.readString();
        this.id = (Long) in.readValue(Long.class.getClassLoader());
        this.mainPhoto = in.readParcelable(MainPhoto.class.getClassLoader());
        this.questions = (Integer) in.readValue(Integer.class.getClassLoader());
        this.shareTitle = in.readString();
        this.sponsored = (Boolean) in.readValue(Boolean.class.getClassLoader());
        this.title = in.readString();
        this.type = in.readString();
    }

    public static final Creator<QuizTitleBranch> CREATOR = new Creator<QuizTitleBranch>() {
        @Override
        public QuizTitleBranch createFromParcel(Parcel source) {
            return new QuizTitleBranch(source);
        }

        @Override
        public QuizTitleBranch[] newArray(int size) {
            return new QuizTitleBranch[size];
        }
    };
}
