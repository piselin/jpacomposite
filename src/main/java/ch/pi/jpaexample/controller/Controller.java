package ch.pi.jpaexample.controller;

import ch.pi.jpaexample.model.Region;
import ch.pi.jpaexample.service.CsvHelper;
import ch.pi.jpaexample.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@org.springframework.stereotype.Controller
@RequestMapping(path = "/demo")
public class Controller {

  @Autowired
  private FileService fileService;

  @GetMapping(path = "/regions")
  public @ResponseBody
  Iterable<Region> getAllRegions() {
    return fileService.getAllRegions();
  }

  @PostMapping("/upload_counties")
  public ResponseEntity<String> uploadCounties(@RequestParam("file") MultipartFile file) {
    String message;
    if (CsvHelper.hasCSVFormat(file)) {
      try {
        fileService.saveCounties(file);

        message = "Uploaded the file successfully: " + file.getOriginalFilename();
        return ResponseEntity.status(HttpStatus.OK).body(message);
      } catch (Exception e) {
        message = "Could not upload the file: " + file.getOriginalFilename() + "!";
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
      }
    }

    message = "Please upload a csv file!";
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
  }

  @PostMapping("/upload_states")
  public ResponseEntity<String> uploadStates(@RequestParam("file") MultipartFile file) {
    String message;

    if (CsvHelper.hasCSVFormat(file)) {
      try {
        fileService.saveStates(file);

        message = "Uploaded the file successfully: " + file.getOriginalFilename();
        return ResponseEntity.status(HttpStatus.OK).body(message);
      } catch (Exception e) {
        message = "Could not upload the file: " + file.getOriginalFilename() + "!";
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
      }
    }

    message = "Please upload a csv file!";
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
  }
}