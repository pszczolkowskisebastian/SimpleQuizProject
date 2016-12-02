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

public class Example implements Parcelable {

    @SerializedName("celebrity")
    @Expose
    private Celebrity celebrity;
    @SerializedName("rates")
    @Expose
    private List<Rate> rates = new ArrayList<Rate>();
    @SerializedName("questions")
    @Expose
    private List<Question> questions = new ArrayList<Question>();

    /**
     * @return The celebrity
     */
    public Celebrity getCelebrity() {
        return celebrity;
    }

    /**
     * @param celebrity The celebrity
     */
    public void setCelebrity(Celebrity celebrity) {
        this.celebrity = celebrity;
    }

    /**
     * @return The rates
     */
    public List<Rate> getRates() {
        return rates;
    }

    /**
     * @param rates The rates
     */
    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }

    /**
     * @return The questions
     */
    public List<Question> getQuestions() {
        return questions;
    }

    /**
     * @param questions The questions
     */
    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.celebrity, flags);
        dest.writeList(this.rates);
        dest.writeTypedList(this.questions);
    }

    public Example() {
    }

    protected Example(Parcel in) {
        this.celebrity = in.readParcelable(Celebrity.class.getClassLoader());
        this.rates = new ArrayList<Rate>();
        in.readList(this.rates, Rate.class.getClassLoader());
        this.questions = in.createTypedArrayList(Question.CREATOR);
    }

    public static final Parcelable.Creator<Example> CREATOR = new Parcelable.Creator<Example>() {
        @Override
        public Example createFromParcel(Parcel source) {
            return new Example(source);
        }

        @Override
        public Example[] newArray(int size) {
            return new Example[size];
        }
    };
}
