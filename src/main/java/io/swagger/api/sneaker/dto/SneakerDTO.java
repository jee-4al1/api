package io.swagger.api.sneaker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SneakerDTO {

    /*
      UUID
     */
    public String id;
    public String brand;;
    public String colorway;
    public String gender;
    public MediaDTO media;
    public String releaseDate;
    public int retailPrice;
    public String styleId;
    public String shoe;
    public String name;
    public String title;
    public int year;
}
