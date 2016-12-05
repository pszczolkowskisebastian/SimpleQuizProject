package pszczolkowskisebastian.simplequiz.model.gsonQuestion;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Question {

  @SerializedName("answer") @Expose private String answer;
  @SerializedName("answers") @Expose private List<Answer> answers = null;
  @SerializedName("image") @Expose private Image_ image;
  @SerializedName("order") @Expose private String order;
  @SerializedName("text") @Expose private String text;
  @SerializedName("type") @Expose private String type;

  public String getAnswer() {
    return answer;
  }

  public void setAnswer(String answer) {
    this.answer = answer;
  }

  public List<Answer> getAnswers() {
    return answers;
  }

  public void setAnswers(List<Answer> answers) {
    this.answers = answers;
  }

  public Image_ getImage() {
    return image;
  }

  public void setImage(Image_ image) {
    this.image = image;
  }

  public String getOrder() {
    return order;
  }

  public void setOrder(String order) {
    this.order = order;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }
}
