package pszczolkowskisebastian.simplequiz.model.gsonTitle;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sebastian on 01.12.2016.
 */


public class MainQuizBranch {

    @SerializedName("count")
    @Expose
    public Integer count;
    @SerializedName("items")
    @Expose
    public List<QuizTitleBranch> items = new ArrayList<QuizTitleBranch>();

}