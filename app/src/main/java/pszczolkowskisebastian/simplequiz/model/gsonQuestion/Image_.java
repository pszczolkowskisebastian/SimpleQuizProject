package pszczolkowskisebastian.simplequiz.model.gsonQuestion;

import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Image_ {

  @SerializedName("author") @Expose private String author;
  @SerializedName("mediaId") @Expose private String mediaId;
  @SerializedName("source") @Expose private String source;
  @SerializedName("url") @Expose private String url;
}
