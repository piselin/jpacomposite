package ch.pi.jpaexample.controller;

import ch.pi.jpaexample.model.City;
import ch.pi.jpaexample.model.Region;
import ch.pi.jpaexample.repositories.RegionRepository;
import ch.pi.jpaexample.model.Area;
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

    Area a2 = new Area();
    a2.setName("another a of r1");

    City nyc = new City();
    nyc.setZipCode("ZH-8712");

    Region r = new Region();
    r.setName("Region 1");
    r.setAreas(List.of(a, nyc, a2));

    Region r2 = new Region();
    r2.setName("R2");

    Area a3 = new Area();
    a3.setName("a3");
    r2.setAreas(List.of(a3));

    Region r3 = new Region();
    r3.setName("r3");

    Area a4 = new Area();
    a4.setName("A4");

    r3.setAreas(List.of(a4, new City()));

    regionRepository.save(r);
    regionRepository.save(r2);
    regionRepository.save(r3);

    return "Done";
  }

}