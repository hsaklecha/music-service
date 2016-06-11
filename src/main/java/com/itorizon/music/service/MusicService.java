package com.itorizon.music.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itorizon.music.trie.Trie;
import com.itorizon.music.trie.TrieGenerator;
import com.itorizon.music.trie.TrieNode;

/**
 * Service class
 * 
 * @author H. Saklecha
 * 
 */
@Service
public class MusicService {

  @Autowired
  private TrieGenerator trieGenerator;

  private Trie trie;

  // Returns if there is any word in the trie
  // that starts with the given prefix.
  public List<String> search(String query) {
    if (trie == null) {
      trie = trieGenerator.createTrie();
    }

    List<String> resultList = new ArrayList<>();

    TrieNode node = trie.searchNode(query);
    Stack<TrieNode> stack = new Stack<>();
    stack.push(node);

    while (!stack.isEmpty()) {
      TrieNode curr = stack.pop();

      if (curr != null) {
        if (!curr.getIds().isEmpty())
          resultList.addAll(curr.getIds());

        for (Character c : curr.getChildren().keySet()) {
          stack.push(curr.getChildren().get(c));
        }
      }

    }
    return resultList;
  }

}
