package io.swagger.api.sneaker.model;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import io.swagger.api.wishlist.model.Wishlist;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Sneaker
 */
@Validated
@Entity
@Table(name = "sneaker")
@Getter
@Setter
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-06-03T10:33:57.949Z")


public class Sneaker   {
  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(
          name = "UUID",
          strategy = "org.hibernate.id.UUIDGenerator"
  )
  @Column(name = "id", updatable = false, nullable = false)
  @JsonProperty("id")
  private String id = null;

  @Column(name = "sneakerWebId")
  @JsonProperty("sneakerWebId")
  private String sneakerWebId;

  @Column(name = "name")
  @JsonProperty("name")
  private String name;

  @Column(name = "photoUrls")
  @JsonProperty("photoUrls")
  @Valid
  private String[] photoUrls;

  @Column(name = "brand")
  @JsonProperty("brand")
  private String brand;

  @Column(name = "gender")
  @JsonProperty("gender")
  private String gender;

  @Column(name = "retailPrice")
  @JsonProperty("retailPrice")
  private int retailPrice;

  @Column(name = "releaseYear")
  @JsonProperty("releaseYear")
  private int releaseYear;

  @ManyToMany(fetch = FetchType.LAZY, mappedBy = "sneakers")
  @JsonIgnore
  private Set<Wishlist> wishlists = new HashSet<>();

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "created_on")
  @CreationTimestamp
  private Date createdOn;

  @Column(name = "updated_on")
  @UpdateTimestamp
  private Date updatedOn;

  /* ----------- id ----------- */
  public Sneaker id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(example = "UUID String", value = "")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  /* ----------- sneakerId ----------- */

  public Sneaker sneakerId(String sneakerId) {
    this.sneakerWebId = sneakerId;
    return this;
  }

  /**
   * Get sneakerId
   * @return sneakerId
   **/
  @ApiModelProperty(example = "3a44fa13-bbae-4c54-a5ea-ea5a3dbbe90f", required = true, value = "")


  public String getSneakerWebId() {
    return sneakerWebId;
  }

  public void setSneakerWebId(String sneakerId) {
    this.sneakerWebId = sneakerId;
  }

  /* ----------- name ----------- */

  public Sneaker name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(example = "Tie-Dye (W)", required = true, value = "")
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  /* ----------- photoUrls ----------- */

  public Sneaker photoUrls(List<String> photoUrls) {
    this.photoUrls = photoUrls.toArray(new String[0]);
    return this;
  }

  public Sneaker addPhotoUrlsItem(String photoUrlsItem) {
    List<String> ar = Arrays.asList(this.photoUrls);
    ar.add(photoUrlsItem);
    this.photoUrls = ar.toArray(new String[0]);
    return this;
  }

  /**
   * Get photoUrls
   * @return photoUrls
  **/
  @ApiModelProperty(example = "https://images.stockx.com/images/Nike-Air-Zoom-Pegasus-37-Tie-Dye-W.jpg?fit=fill&bg=FFFFFF&w=700&h=500&fm=webp&auto=compress&trim=color&q=90&dpr=2&updated_at=1642460060", required = true, value = "")


  public String[] getPhotoUrls() {
    return photoUrls;
  }

  public void setPhotoUrls(List<String> photoUrls) {
    this.photoUrls = photoUrls.toArray(new String[0]);
  }


  /* ----------- brand ----------- */

  public Sneaker brand(String brand) {
    this.brand = brand;
    return this;
  }

  /**
   * Get brand
   * @return brand
   **/
  @ApiModelProperty(example = "Nike", required = true, value = "")
  @NotNull


  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  /* ----------- gender ----------- */

  public Sneaker gender(String gender) {
    this.gender = gender;
    return this;
  }

  /**
   * Get gender
   * @return gender
   **/
  @ApiModelProperty(example = "women", required = true, value = "")
  @NotNull


  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  /* ----------- retailPrice ----------- */

  public Sneaker retailPrice(int retailPrice) {
    this.retailPrice = retailPrice;
    return this;
  }

  /**
   * Get retailPrice
   * @return retailPrice
   **/
  @ApiModelProperty(example = "125", required = true, value = "")
  @NotNull


  public int getRetailPrice() {
    return retailPrice;
  }

  public void setRetailPrice(int retailPrice) {
    this.retailPrice = retailPrice;
  }

  /* ----------- releaseYear ----------- */

  public Sneaker releaseYear(int releaseYear) {
    this.releaseYear = releaseYear;
    return this;
  }

  /**
   * Get retailPrice
   * @return retailPrice
   **/
  @ApiModelProperty(example = "2020", required = true, value = "")
  @NotNull


  public int getReleaseYear() {
    return releaseYear;
  }

  public void setReleaseYear(int releaseYear) {
    this.releaseYear = releaseYear;
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Sneaker sneaker = (Sneaker) o;
    return Objects.equals(this.id, sneaker.id) &&
        Objects.equals(this.sneakerWebId, sneaker.sneakerWebId) &&
        Objects.equals(this.name, sneaker.name) &&
        Objects.equals(this.photoUrls, sneaker.photoUrls) &&
        Objects.equals(this.brand, sneaker.brand) &&
        Objects.equals(this.gender, sneaker.gender) &&
        Objects.equals(this.retailPrice, sneaker.retailPrice) &&
        Objects.equals(this.releaseYear, sneaker.releaseYear);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, sneakerWebId, name, photoUrls, brand, gender, retailPrice, releaseYear);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Sneaker {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    sneakerId: ").append(toIndentedString(sneakerWebId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    photoUrls: ").append(toIndentedString(photoUrls)).append("\n");
    sb.append("    brand: ").append(toIndentedString(brand)).append("\n");
    sb.append("    gender: ").append(toIndentedString(gender)).append("\n");
    sb.append("    retailPrice: ").append(toIndentedString(retailPrice)).append("\n");
    sb.append("    releaseYear: ").append(toIndentedString(releaseYear)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  @JsonProperty("releaseYear")
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

