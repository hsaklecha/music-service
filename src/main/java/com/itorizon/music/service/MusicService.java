package com.itorizon.music.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itorizon.music.config.PropertyUtil;
import com.itorizon.music.domain.MusicData;

/**
 * Service class
 * 
 * @author H. Saklecha
 * 
 */
@Service
public class MusicService implements SearchService {

  @Autowired
  private FileParser fileParser;

  @Autowired
  private PropertyUtil propertyUtil;

  /**
   * Method to search the given query and return corresponding id's.
   * 
   * @return The root node of that trie.
   */
  public List<String> search(String query) {

    List<String> resultList = new ArrayList<>();
    Integer threadPoolSize = propertyUtil.getThreadPoolSize();
    ExecutorService executorService = Executors.newFixedThreadPool(threadPoolSize);

    Collection<Future<Set<String>>> futures = new ArrayList<>(threadPoolSize);
    Set<String> resultSet = new HashSet<>();

    for (List<MusicData> list : fileParser.readFile(threadPoolSize)) {
      futures.add(executorService.submit(new SearchHandler(list, query)));
    }

    for (Future<Set<String>> future : futures) {
      try {
        resultSet.addAll(future.get());
      }
      catch (InterruptedException | ExecutionException e) {
        e.printStackTrace();
      }

    }
    resultList.addAll(resultSet);

    return resultList;

  }

}
