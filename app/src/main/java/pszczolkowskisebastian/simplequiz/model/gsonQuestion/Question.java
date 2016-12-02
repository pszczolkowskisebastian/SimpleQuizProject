package pszczolkowskisebastian.simplequiz.model.gsonQuestion;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sebastian on 02.12.2016.
 */

public class Question implements Parcelable {

    @SerializedName("image")
    @Expose
    private Image image;
    @SerializedName("answers")
    @Expose
    private List<Answer> answersList = new ArrayList<Answer>();
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("answer")
    @Expose
    private String answer;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("order")
    @Expose
    private Integer order;

    /**
     * @return The image
     */
    public Image getImage() {
        return image;
    }

    /**
     * @param image The image
     */
    public void setImage(Image image) {
        this.image = image;
    }

    /**
     * @return The answers
     */
    public List<Answer> getAnswers() {
        return answersList;
    }

    /**
     * @param answers The answers
     */
    public void setAnswers(List<Answer> answers) {
        this.answersList = answers;
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
     * @return The answer
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * @param answer The answer
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    /**
     * @return The type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type The type
     */
    public void setType(String type) {
        this.type = type;
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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.image, flags);
        dest.writeList(this.answersList);
        dest.writeString(this.text);
        dest.writeString(this.answer);
        dest.writeString(this.type);
        dest.writeValue(this.order);
    }

    public Question() {
    }

    protected Question(Parcel in) {
        this.image = in.readParcelable(Image.class.getClassLoader());
        this.answersList = new ArrayList<Answer>();
        in.readList(this.answersList, Question.class.getClassLoader());
        this.text = in.readString();
        this.answer = in.readString();
        this.type = in.readString();
        this.order = (Integer) in.readValue(Integer.class.getClassLoader());
    }

    public static final Parcelable.Creator<Question> CREATOR = new Parcelable.Creator<Question>() {
        @Override
        public Question createFromParcel(Parcel source) {
            return new Question(source);
        }

        @Override
        public Question[] newArray(int size) {
            return new Question[size];
        }
    };
}