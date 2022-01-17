package ch.pi.accessingdatamysql.controller;

import ch.pi.accessingdatamysql.model.Area;
import ch.pi.accessingdatamysql.model.City;
import ch.pi.accessingdatamysql.model.Region;
import ch.pi.accessingdatamysql.repositories.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.stereotype.Controller
@RequestMapping(path = "/demo")
public class Controller {
  @Autowired
  private RegionRepository regionRepository;

  @GetMapping(path = "/all")
  public @ResponseBody
  Iterable<Region> getAllRegions() {
    return regionRepository.findAll();
  }

  @PostMapping(path = "/area")
  public @ResponseBody
  String addAreas(@RequestParam String name) {
    Area a = new Area();
    a.setName(name);

    City nyc = new City();
    nyc.setZipCode("ZH-8712");

    Region r = new Region();
    r.setName("Region 1");
    r.setAreas(List.of(a, nyc));

    regionRepository.save(r);

    return "Done";
  }

}