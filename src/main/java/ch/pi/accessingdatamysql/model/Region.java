package ch.pi.accessingdatamysql.model;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("region")
public class Region extends Area {

  @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
  @JoinTable(name = "lnk_area_region",
             joinColumns = @JoinColumn(name = "area_id", referencedColumnName = "area_id"),
             inverseJoinColumns = @JoinColumn(name = "sub_area_id",
                                              referencedColumnName = "area_id"))
  @OrderBy("name")
  private List<Area> areas;

  public List<Area> getAreas() {
    return areas;
  }

  public void setAreas(List<Area> areas) {
    this.areas = areas;
  }
}



