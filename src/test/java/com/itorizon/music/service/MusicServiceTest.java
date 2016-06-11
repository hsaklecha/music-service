package com.itorizon.music.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.itorizon.music.domain.MusicData;
import com.itorizon.music.trie.Trie;
import com.itorizon.music.trie.TrieGenerator;

/**
 * MusicService test class
 * 
 * @author H. Saklecha
 */
@RunWith(MockitoJUnitRunner.class)
public class MusicServiceTest {

  @InjectMocks
  MusicService musicService;

  @Mock
  TrieGenerator trieGenerator;

  private Trie trie;

  @Before
  public void setup() {
    TestObjects.initTestObjects();

    trie = new Trie();
    for (MusicData data : TestObjects.dataList) {
      trie.addToTrie(data);
    }
  }

  /*
   * Testing search call
   */
  @Test
  public void search() {
    // created trie with dummy testobjects
    when(trieGenerator.createTrie()).thenReturn(trie);

    Set<String> expectedList1 = new HashSet<>();
    expectedList1.add("9xta");
    expectedList1.add("8xta");
    expectedList1.add("3xta");
    Set<String> resultList1 = musicService.search("Ro");
    Assert.assertTrue(resultList1.size() == 3);
    Assert.assertEquals(expectedList1, resultList1);

    Set<String> expectedList2 = new HashSet<>();
    expectedList2.add("3xta");
    expectedList2.add("4xta");
    expectedList2.add("5xta");
    Set<String> resultList2 = musicService.search("Binny");

    Assert.assertTrue(resultList2.size() == 3);
    Assert.assertEquals(expectedList2, resultList2);

    Set<String> expectedList3 = new HashSet<>();
    expectedList3.add("10xta");
    expectedList3.add("0fqwx_c");
    Set<String> resultList3 = musicService.search("救星");

    Assert.assertTrue(resultList3.size() == 2);
    Assert.assertEquals(expectedList3, resultList3);

  }
}
