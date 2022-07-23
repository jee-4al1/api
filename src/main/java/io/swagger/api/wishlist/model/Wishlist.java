package io.swagger.api.wishlist.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.api.sneaker.model.Sneaker;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * Wishlist
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-06-03T10:33:57.949Z")


public class Wishlist   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("userId")
  private String userId = null;

  @JsonProperty("sneaker")
  private Sneaker sneaker = null;

  public Wishlist id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Wishlist userId(String userId) {
    this.userId = userId;
    return this;
  }

  /**
   * Get userId
   * @return userId
  **/
  @ApiModelProperty(value = "")


  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public Wishlist sneaker(Sneaker sneaker) {
    this.sneaker = sneaker;
    return this;
  }

  /**
   * Get sneaker
   * @return sneaker
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Sneaker getSneaker() {
    return sneaker;
  }

  public void setSneaker(Sneaker sneaker) {
    this.sneaker = sneaker;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Wishlist wishlist = (Wishlist) o;
    return Objects.equals(this.id, wishlist.id) &&
        Objects.equals(this.userId, wishlist.userId) &&
        Objects.equals(this.sneaker, wishlist.sneaker);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, userId, sneaker);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Wishlist {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    sneaker: ").append(toIndentedString(sneaker)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

