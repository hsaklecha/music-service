package com.itorizon.music.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
public class PropertyUtil {

  @Value("${thread.pool.size}")
  private Integer threadPoolSize;

  public Integer getThreadPoolSize() {
    return threadPoolSize;
  }

}
