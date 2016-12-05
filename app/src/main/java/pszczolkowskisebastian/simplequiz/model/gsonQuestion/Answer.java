package pszczolkowskisebastian.simplequiz.model.gsonQuestion;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Answer {

  @SerializedName("image") @Expose private Image image;
  @SerializedName("order") @Expose private String order;
  @SerializedName("text") @Expose private String text;
  @SerializedName("isCorrect") @Expose private Integer isCorrect;

  public Image getImage() {
    return image;
  }

  public void setImage(Image image) {
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

  public Integer getIsCorrect() {
    return isCorrect;
  }

  public void setIsCorrect(Integer isCorrect) {
    this.isCorrect = isCorrect;
  }
}
