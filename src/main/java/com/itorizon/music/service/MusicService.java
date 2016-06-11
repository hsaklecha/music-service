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
import com.itorizon.music.service.FileParser;

/**
 * Service class
 * 
 * @author H. Saklecha
 * 
 */
@Service
public class MusicService {

  @Autowired
  private FileParser fileParser;

  @Autowired
  private PropertyUtil propertyUtil;

  // Returns if there is any word in the trie
  // that starts with the given prefix.
  public Set<String> search(String query) {
    Integer threadPoolSize = propertyUtil.getThreadPoolSize();
    ExecutorService executorService = Executors.newFixedThreadPool(threadPoolSize);
    Collection<Future<Set<String>>> futures = new ArrayList<Future<Set<String>>>();
    Set<String> resultSet = new HashSet<String>();
    for (List<MusicData> list : fileParser.readFile(threadPoolSize)) {
      futures.add(executorService.submit(new SearchHandler(list, query)));
    }

    for (Future<?> future : futures) {
      Set<String> s;
      try {
        resultSet.addAll((Set<String>) future.get());

      }
      catch (InterruptedException | ExecutionException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

    }

    return resultSet;

  }

}
