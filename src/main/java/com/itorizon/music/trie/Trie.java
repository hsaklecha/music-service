package com.itorizon.music.trie;

import java.util.Map;

import com.itorizon.music.domain.MusicData;

public class Trie {
  private TrieNode root;

  public Trie() {
    root = new TrieNode();
  }

  public void addToTrie(MusicData data) {
    String[] tokens = data.getName().split(" ");

    for (int y = 0; y < tokens.length; y++) {

      Map<Character, TrieNode> children = root.getChildren();

      for (int i = 0; i < tokens[y].length(); i++) {
        char c = tokens[y].charAt(i);

        TrieNode newNode;

        if (children.containsKey(c)) {
          newNode = children.get(c);
        }
        else {
          newNode = new TrieNode(c);
          children.put(c, newNode);
        }

        children = newNode.getChildren();

        if (i == (tokens[y].length() - 1))
          newNode.getIds().add(data.getId());
      }
    }
  }

  public TrieNode searchNode(String query) {
    TrieNode node = root;

    for (int i = 0; i < query.length(); i++) {
      char c = query.charAt(i);

      if (node.getChildren().containsKey(c)) {
        node = node.getChildren().get(c);
      }
      else {
        return null;
      }
    }

    if (node == root)
      return null;

    return node;
  }
}
