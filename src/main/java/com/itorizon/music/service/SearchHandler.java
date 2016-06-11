package com.itorizon.music.service;

import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

import com.itorizon.music.domain.MusicData;
import com.itorizon.music.trie.Trie;

public class SearchHandler implements Callable<Set<String>> {

  private List<MusicData> dataList;
  private String query;
  private Trie trie;

  public SearchHandler(List<MusicData> dataList, String query) {
    this.dataList = dataList;
    this.query = query;
  }

  @Override
  public Set<String> call() throws Exception {
    System.out.println("tree: " + trie);
    if (trie == null) {
      trie = new Trie();
    }
    for (MusicData musicData : dataList) {
      trie.addToTrie(musicData);
    }

    return trie.search(query);
  }

}
