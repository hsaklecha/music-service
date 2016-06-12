package com.itorizon.music.service;

import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

import com.itorizon.music.domain.MusicData;
import com.itorizon.music.trie.Trie;

/**
 * Search handler class which will pass list to create its trie.
 * 
 * @author H. Saklecha
 */
class SearchHandler implements Callable<Set<String>> {

  private List<MusicData> dataList;
  private String query;
  private Trie trie;

  public SearchHandler(List<MusicData> dataList, String query) {
    this.dataList = dataList;
    this.query = query;
  }

  @Override
  public Set<String> call() throws Exception {

    // lazily loaded
    if (trie == null) {
      trie = new Trie();
    }
    for (MusicData musicData : dataList) {
      trie.addToTrie(musicData);
    }

    return trie.search(query);
  }

}
