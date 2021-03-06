package ro.proiect.licenta.rau.lbu.engine;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import ro.proiect.licenta.rau.lbu.engine.logic.CdrProcessor;
import ro.proiect.licenta.rau.lbu.engine.logic.CdrProcessorImpl;
import ro.proiect.licenta.rau.lbu.engine.service.db.DbService;
import ro.proiect.licenta.rau.lbu.engine.service.db.DbServiceImpl;
import ro.proiect.licenta.rau.lbu.engine.service.jms.JmsService;
import ro.proiect.licenta.rau.lbu.engine.service.jms.JmsServiceImpl;
import ro.proiect.licenta.rau.lbu.engine.service.sms.SmsService;
import ro.proiect.licenta.rau.lbu.engine.service.sms.SmsServiceImpl;

@Component
public class Dispatcher
{

  private final LbuEngineConfig config;

  public Dispatcher(LbuEngineConfig config)
  {
    this.config = config;
  }

  @Bean
  @Primary
  public DbService getCustomDbService()
  {
    switch (config.getApplicationUser())
    {
      case "userName":
        return new DbServiceImpl();
      default:
        throw new IllegalArgumentException();
    }
  }

  @Bean
  @Primary
  public JmsService getCustomJmsService()
  {
    switch (config.getApplicationUser())
    {
      case "userName":
        return new JmsServiceImpl();
      default:
        throw new IllegalArgumentException();
    }
  }

  @Bean
  @Primary
  public CdrProcessor getCustomCdrProcessor()
  {
    switch (config.getApplicationUser())
    {
      case "userName":
        return new CdrProcessorImpl();
      default:
        throw new IllegalArgumentException();
    }
  }

  @Bean
  @Primary
  public SmsService getCustomSmsService()
  {
    switch (config.getApplicationUser())
    {
      case "userName":
        return new SmsServiceImpl();
      default:
        throw new IllegalArgumentException();
    }
  }

}
