package com.itorizon.music.service;

import java.util.ArrayList;
import java.util.List;

import com.itorizon.music.domain.MusicData;

public class TestObjects {

  public static MusicData musicData1;
  public static MusicData musicData2;
  public static MusicData musicData3;
  public static MusicData musicData4;
  public static MusicData musicData5;
  public static MusicData musicData6;
  public static MusicData musicData7;
  public static MusicData musicData8;
  public static MusicData musicData9;
  public static MusicData musicData10;
  public static MusicData musicData11;
  public static MusicData musicData12;

  public static List<MusicData> dataList = new ArrayList<>();

  public static void initTestObjects() {
    musicData1 = new MusicData("Harsh Khandelwal", "1xta");
    dataList.add(musicData1);

    musicData2 = new MusicData("Harish Mandale", "2xta");
    dataList.add(musicData2);

    musicData3 = new MusicData("Roger Binny", "3xta");
    dataList.add(musicData3);

    musicData4 = new MusicData("Rahul Binny Jr", "4xta");
    dataList.add(musicData4);

    musicData5 = new MusicData("Binny Mandale", "5xta");
    dataList.add(musicData5);

    musicData6 = new MusicData("Harish Saheb Bapat", "6xta");
    dataList.add(musicData6);

    musicData7 = new MusicData("Kartikey Bapat", "7xta");
    dataList.add(musicData7);

    musicData8 = new MusicData("Rohit Mohod", "8xta");
    dataList.add(musicData8);

    musicData9 = new MusicData("Ronit Dhawan", "9xta");
    dataList.add(musicData9);

    musicData9 = new MusicData("草莓 救星", "10xta");
    dataList.add(musicData9);

    musicData9 = new MusicData("スマイル☆シューター", "0frlbf3");
    dataList.add(musicData9);

    musicData9 = new MusicData("Anonomous 救星", "0fqwx_c");
    dataList.add(musicData9);
  }

}
