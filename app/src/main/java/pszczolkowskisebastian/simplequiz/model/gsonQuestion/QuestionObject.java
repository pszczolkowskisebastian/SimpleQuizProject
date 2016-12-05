package pszczolkowskisebastian.simplequiz.model.gsonQuestion;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class QuestionObject {

  @SerializedName("avgResult") @Expose private String avgResult;
  @SerializedName("buttonStart") @Expose private String buttonStart;
  @SerializedName("categories") @Expose private List<Object> categories = null;

  @SerializedName("cityAvg") @Expose private Object cityAvg;
  @SerializedName("cityCount") @Expose private Object cityCount;
  @SerializedName("cityTime") @Expose private Object cityTime;
  @SerializedName("content") @Expose private String content;
  @SerializedName("created") @Expose private String created;
  @SerializedName("createdAt") @Expose private String createdAt;
  @SerializedName("id") @Expose private String id;
  @SerializedName("isBattle") @Expose private Boolean isBattle;
  @SerializedName("mainPhoto") @Expose private MainPhoto mainPhoto;
  @SerializedName("questions") @Expose private List<Question> questions = null;

  @SerializedName("resultCount") @Expose private String resultCount;
  @SerializedName("scripts") @Expose private String scripts;
  @SerializedName("shareTitle") @Expose private String shareTitle;
  @SerializedName("sponsored") @Expose private Boolean sponsored;
  @SerializedName("title") @Expose private String title;
  @SerializedName("type") @Expose private String type;
  @SerializedName("userBattleDone") @Expose private Boolean userBattleDone;

  public String getAvgResult() {
    return avgResult;
  }

  public void setAvgResult(String avgResult) {
    this.avgResult = avgResult;
  }

  public String getButtonStart() {
    return buttonStart;
  }

  public void setButtonStart(String buttonStart) {
    this.buttonStart = buttonStart;
  }

  public List<Object> getCategories() {
    return categories;
  }

  public void setCategories(List<Object> categories) {
    this.categories = categories;
  }

  public Object getCityAvg() {
    return cityAvg;
  }

  public void setCityAvg(Object cityAvg) {
    this.cityAvg = cityAvg;
  }

  public Object getCityCount() {
    return cityCount;
  }

  public void setCityCount(Object cityCount) {
    this.cityCount = cityCount;
  }

  public Object getCityTime() {
    return cityTime;
  }

  public void setCityTime(Object cityTime) {
    this.cityTime = cityTime;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getCreated() {
    return created;
  }

  public void setCreated(String created) {
    this.created = created;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Boolean getBattle() {
    return isBattle;
  }

  public void setBattle(Boolean battle) {
    isBattle = battle;
  }

  public MainPhoto getMainPhoto() {
    return mainPhoto;
  }

  public void setMainPhoto(MainPhoto mainPhoto) {
    this.mainPhoto = mainPhoto;
  }

  public List<Question> getQuestions() {
    return questions;
  }

  public void setQuestions(List<Question> questions) {
    this.questions = questions;
  }

  public String getResultCount() {
    return resultCount;
  }

  public void setResultCount(String resultCount) {
    this.resultCount = resultCount;
  }

  public String getScripts() {
    return scripts;
  }

  public void setScripts(String scripts) {
    this.scripts = scripts;
  }

  public String getShareTitle() {
    return shareTitle;
  }

  public void setShareTitle(String shareTitle) {
    this.shareTitle = shareTitle;
  }

  public Boolean getSponsored() {
    return sponsored;
  }

  public void setSponsored(Boolean sponsored) {
    this.sponsored = sponsored;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Boolean getUserBattleDone() {
    return userBattleDone;
  }

  public void setUserBattleDone(Boolean userBattleDone) {
    this.userBattleDone = userBattleDone;
  }
}
