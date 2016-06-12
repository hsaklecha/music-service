package com.itorizon.music.service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.itorizon.music.domain.MusicData;

/**
 * File parser class to read file and generate trie.
 *
 * @author H. Saklecha
 */
@Component
class FileParser {

  /**
   * Method to parse musical_group.tsv and create a trie for the music data.
   * 
   * @return The root node of that trie.
   */
  public List<List<MusicData>> readFile(Integer threadPoolSize) {

    // initializing list as per threadpoolsize
    List<List<MusicData>> dataList = new ArrayList<>();
    for (int i = 0; i < threadPoolSize; i++) {
      dataList.add(new ArrayList<MusicData>());
    }

    String line;
    BufferedReader br = null;
    InputStreamReader ir = null;
    FileInputStream fis = null;
    try {
      ClassPathResource classPathResource = new ClassPathResource("static\\musical_group.tsv");
      fis = new FileInputStream(classPathResource.getFile());
      ir = new InputStreamReader(fis, "UTF-8");
      br = new BufferedReader(ir);
      br.readLine(); // ignore first line

      int idx = 0;
      String[] tokens;
      while ((line = br.readLine()) != null) {
        tokens = line.split("/m/");
        dataList.get(idx % threadPoolSize).add(new MusicData(tokens[0].trim(), tokens[1]));
        idx++;
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
        if (ir != null)
          ir.close();
      }
      catch (IOException ex) {
        // do nothing
      }
      try {
        if (fis != null)
          fis.close();
      }
      catch (IOException ex) {
        // do nothing
      }
    }

    return dataList;
  }

}
