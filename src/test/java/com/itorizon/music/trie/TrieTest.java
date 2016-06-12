package com.itorizon.music.trie;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.itorizon.music.domain.MusicData;

/**
 * Trie test class
 * 
 * @author H. Saklecha
 */
@RunWith(MockitoJUnitRunner.class)
public class TrieTest {

  private Trie trie;

  @Before
  public void setup() {
    TestObjects.initTestObjects();

    trie = new Trie();
    // created trie with dummy test
    for (MusicData data : TestObjects.dataList) {
      trie.addToTrie(data);
    }
  }

  /*
   * Testing search call
   */
  @Test
  public void searchForSubString() {
    Set<String> expectedList1 = new HashSet<>();
    expectedList1.add("9xta");
    expectedList1.add("8xta");
    expectedList1.add("3xta");
    expectedList1.add("2xta");
    Set<String> resultList1 = trie.search("Ro");
    Assert.assertTrue(resultList1.size() == 4);
    Assert.assertEquals(expectedList1, resultList1);
  }

  @Test
  public void searchForSubPart() {
    Set<String> expectedList2 = new HashSet<>();
    expectedList2.add("3xta");
    expectedList2.add("4xta");
    expectedList2.add("5xta");
    Set<String> resultList2 = trie.search("Binny");

    Assert.assertTrue(resultList2.size() == 3);
    Assert.assertEquals(expectedList2, resultList2);
  }

  @Test
  public void searchForSpecialCharacter() {
    Set<String> expectedList3 = new HashSet<>();
    expectedList3.add("10xta");
    expectedList3.add("0fqwx_c");
    Set<String> resultList3 = trie.search("救星");

    Assert.assertTrue(resultList3.size() == 2);
    Assert.assertEquals(expectedList3, resultList3);
  }
}
