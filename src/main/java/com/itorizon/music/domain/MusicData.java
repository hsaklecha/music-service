package com.itorizon.music.domain;

/**
 * Music data class
 *
 * @author H. Saklecha
 */
public class MusicData {
  private String name;
  private String id;

  public MusicData(String name, String id) {
    this.name = name;
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

}
