package com.itorizon.music.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import com.itorizon.music.domain.MusicData;

/**
 * Trie to hold music data.
 * 
 * @author H. Saklecha
 */
public class Trie {
  private TrieNode root;

  public Trie() {
    root = new TrieNode();
  }

  /**
   * This method creates a trie of music data passed.
   */
  public void addToTrie(MusicData data) {
    String[] tokens = data.getName().split(" ");
    String[] words = Arrays.copyOf(tokens, tokens.length + 1);
    words[words.length - 1] = data.getName();

    for (int y = 0; y < words.length; y++) {

      Map<Character, TrieNode> children = root.getChildren();

      for (int i = 0; i < words[y].length(); i++) {
        char c = words[y].charAt(i);

        TrieNode newNode;

        if (children.containsKey(c)) {
          newNode = children.get(c);
        }
        else {
          newNode = new TrieNode(c);
          children.put(c, newNode);
        }

        children = newNode.getChildren();

        if (i == (words[y].length() - 1))
          newNode.getIds().add(data.getId());
      }
    }
  }

  /**
   * This method returns node of the query string passed. for ex- if Indigo is passed it will return node of o, parsing through i,n,d,i,g nodes in tree.
   */
  private TrieNode searchNode(String query) {
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

  /**
   * This method will get node of the query and search via dfs to get all ids in the nodes below it.
   */
  public Set<String> search(String query) {
    Set<String> resultSet = new HashSet<>();

    TrieNode node = searchNode(query);
    // initially used stack, changed it to linkedlist
    Deque<TrieNode> stack = new LinkedList<>();
    stack.push(node);

    // using dfs to get all possible ids below the node for which the query is passed.
    while (!stack.isEmpty()) {
      TrieNode curr = stack.pop();

      if (curr != null) {
        if (!curr.getIds().isEmpty())
          resultSet.addAll(curr.getIds());

        for (Character c : curr.getChildren().keySet()) {
          stack.push(curr.getChildren().get(c));
        }
      }

    }
    return resultSet;
  }
}
