package ch.pi.accessingdatamysql.model;

import javax.persistence.*;

@Entity
@Table(name = "area")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("area")
public class Area {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "area_id", nullable = false)
  private Integer areaId;
  private String name;

  public Integer getAreaId() {
    return areaId;
  }

  public void setAreaId(Integer areaId) {
    this.areaId = areaId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}

