package com.itorizon.music.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itorizon.music.service.SearchService;

/**
 * Music controller class
 *
 * @author H. Saklecha
 */
@RestController
@RequestMapping(value = "/music")
public class MusicController {

  @Autowired
  private SearchService searchService;

  /**
   * Get list of id's for input query
   *
   * @param query
   * 
   * @return Set of id's
   */
  @RequestMapping(method = RequestMethod.GET, value = "/search")
  public List<String> search(@RequestParam(name = "query") String query) {
    return searchService.search(query);
  }
}
