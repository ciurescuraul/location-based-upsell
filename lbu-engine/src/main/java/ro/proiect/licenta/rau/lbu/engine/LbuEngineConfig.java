package ro.proiect.licenta.rau.lbu.engine;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LbuEngineConfig
{

  @Value("${lbu.user_name}")
  private String userName;

  @Value("${lbu.engine.sleep_time_no_file_found}")
  private int sleepTimeIfFileNotFound;

  public String getApplicationUser()
  {
    return userName;
  }

  public int getSleepTimeIfFileNotFound()
  {
    return sleepTimeIfFileNotFound;
  }
}