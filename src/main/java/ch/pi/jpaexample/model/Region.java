package ch.pi.jpaexample.model;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("state")
public class Region extends Area {

  @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
  @JoinTable(name = "lnk_area_region",
             joinColumns = @JoinColumn(name = "area_id", referencedColumnName = "area_id"),
             inverseJoinColumns = @JoinColumn(name = "sub_area_id",
                                              referencedColumnName = "area_id"))
  @OrderBy("name")

  private List<Area> areas;

  public Region() {
    setName("");
  }

  public Region(String name, String stateId) {
    this.name = name;
    this.stateId = stateId;
  }

  public List<Area> getAreas() {
    return areas;
  }

  public void setAreas(List<Area> areas) {
    this.areas = areas;
  }
}



