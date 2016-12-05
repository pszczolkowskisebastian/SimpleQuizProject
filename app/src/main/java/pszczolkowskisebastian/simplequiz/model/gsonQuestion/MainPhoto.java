package pszczolkowskisebastian.simplequiz.model.gsonQuestion;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MainPhoto {

  @SerializedName("author") @Expose private String author;
  @SerializedName("height") @Expose private String height;
  @SerializedName("source") @Expose private String source;
  @SerializedName("title") @Expose private String title;
  @SerializedName("url") @Expose private String url;
  @SerializedName("width") @Expose private String width;

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getHeight() {
    return height;
  }

  public void setHeight(String height) {
    this.height = height;
  }

  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getWidth() {
    return width;
  }

  public void setWidth(String width) {
    this.width = width;
  }
}
