package ch.pi.jpaexample.service;

import ch.pi.jpaexample.model.Area;
import ch.pi.jpaexample.model.Region;
import ch.pi.jpaexample.repositories.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FileService {

  @Autowired
  RegionRepository regionRepository;

  public void saveCounties(MultipartFile file) {
    try {

      Iterable<Region> states = regionRepository.findAll();

      List<Area> counties = CsvHelper.csvToCounties(file.getInputStream());

      for (Region state : states) {
        String stateId = state.getStateId();

        List<Area> countiesOfState = counties.stream()
                                             .filter(r -> r.getStateId().equals(stateId))
                                             .collect(Collectors.toList());

        System.out.println(state.getName() + " has " + countiesOfState.size() + " counties");

        state.setAreas(countiesOfState);
      }

      regionRepository.saveAll(states);
      System.out.println("saved all states");

    } catch (IOException e) {
      throw new RuntimeException("fail to store csv data: " + e.getMessage());
    }
  }

  public void saveStates(MultipartFile file) {
    try {
      List<Region> regions = CsvHelper.csvToRegions(file.getInputStream());
      regionRepository.saveAll(regions);
    } catch (IOException e) {
      throw new RuntimeException("fail to store csv data: " + e.getMessage());
    }
  }

  public Iterable<Region> getAllRegions() {
    return regionRepository.findAll();
  }
}
