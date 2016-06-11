package com.itorizon.music.trie;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Class to represent a Trie node. Each node will have character, the node is representing. The node will have a reference of all the child nodes. Music titles will be split into String tokens. Each
 * of those tokens may be present in more than one music title. In that case, each token should have a reference of the id of each music title, in which they belonged. Eg. If we have two titles:
 * "Indigo  /m/01wj3vq" and "Indigo Girls & Ani DiFranco /m/01v5dc3". The token "Indigo" is present in both titles. So the node representing this token should have the reference of both ids.
 *
 * @author H. Saklecha
 */
public class TrieNode {
  private Map<Character, TrieNode> children;
  private List<String> ids;
  private Character unicode;

  public TrieNode() {
    this(null);
  }

  public TrieNode(Character c) {
    unicode = c;
    children = new TreeMap<>((char1, char2) -> {
      return char1 - char2;
    });
    ids = new ArrayList<>();
  }

  public Map<Character, TrieNode> getChildren() {
    return children;
  }

  public void setChildren(Map<Character, TrieNode> children) {
    this.children = children;
  }

  public List<String> getIds() {
    return ids;
  }

  public void setIds(List<String> ids) {
    this.ids = ids;
  }

  public Character getUnicode() {
    return unicode;
  }

  public void setUnicode(Character unicode) {
    this.unicode = unicode;
  }

}
