package io.swagger.api.wishlist.model;

import java.util.Date;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.api.sneaker.model.Sneaker;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.Valid;

/**
 * Wishlist
 */
@Validated
@Entity
@Table(name = "wishlist")
@Getter
@Setter
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-06-03T10:33:57.949Z")


public class Wishlist   {
  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(
          name = "UUID",
          strategy = "org.hibernate.id.UUIDGenerator"
  )
  @JsonProperty("id")
  @Column(name = "id", updatable = false, nullable = false)
  private String id;

  @Column(name = "userId")
  @JsonProperty("userId")
  private String userId;

  @JsonProperty("isPurchased")
  private Boolean isPurchased;

  @ManyToMany(cascade = { CascadeType.ALL })
  @JoinTable(
          name = "wishlist_sneaker",
          joinColumns = { @JoinColumn(name = "wishlist_id") },
          inverseJoinColumns = { @JoinColumn(name = "sneaker_id") }
  )
  private Set<Sneaker> sneakers;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "created_on")
  @CreationTimestamp
  private Date createdOn;

  @Column(name = "updated_on")
  @UpdateTimestamp
  private Date updatedOn;

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

  public Wishlist sneaker(Set<Sneaker> sneaker) {
    this.sneakers = sneaker;
    return this;
  }

  /**
   * Get sneaker
   * @return sneaker
   **/
  @ApiModelProperty(value = "")

  public Set<Sneaker> getSneakers() {
    return sneakers;
  }

  public void setSneakers(Set<Sneaker> sneaker) {
    this.sneakers = sneaker;
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
            Objects.equals(this.sneakers, wishlist.sneakers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, userId, sneakers);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Wishlist {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    sneaker: ").append(toIndentedString(sneakers)).append("\n");
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

