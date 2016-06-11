package com.itorizon.music.trie;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.itorizon.music.domain.MusicData;

@Component
public class TrieGenerator {

  /**
   * Method to parse musical_group.tsv and create a trie for the music data.
   * 
   * @return The root node of that trie.
   */
  public Trie createTrie() {

    Trie trie = new Trie();
    String line;
    BufferedReader br = null;
    FileReader fr = null;
    InputStreamReader ir = null;
    FileInputStream fis = null;
    try {
      ClassPathResource classPathResource = new ClassPathResource("static\\musical_group.tsv");
      fis = new FileInputStream(classPathResource.getFile());
      ir = new InputStreamReader(fis, "UTF-8");
      br = new BufferedReader(ir);
      br.readLine(); // ignore first line

      String[] tokens;
      while ((line = br.readLine()) != null) {
        tokens = line.split("/m/");
        trie.addToTrie(new MusicData(tokens[0].trim(), tokens[1]));
      }

    }
    catch (IOException e) {
      e.printStackTrace();
    }
    finally {
      try {
        if (br != null)
          br.close();
      }
      catch (IOException ex) {
        // do nothing
      }
      try {
        if (fr != null)
          fr.close();
      }
      catch (IOException ex) {
        // do nothing
      }
    }

    return trie;
  }

}
