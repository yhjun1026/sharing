package cn.sharing.platform.utils;

import java.util.UUID;

/**
 * 生成UUID
 * Created by guotao on 2018.01.20.
 */
public class UUIDGenerator {
  public UUIDGenerator() {
  }

  public static String getUUID() {
    String s = UUID.randomUUID().toString();
    return s.replaceAll("-", "");
  }
}
