package ro.proiect.licenta.rau.lbu.core;

import java.time.ZonedDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import ro.proiect.licenta.rau.lbu.core.utils.ZonedDateTimeCustomDeserializer;
import ro.proiect.licenta.rau.lbu.core.utils.ZonedDateTimeCustomSerializer;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({ "created", "modified" })
public class LbuTimestampBean
{

  @JsonSerialize(using = ZonedDateTimeCustomSerializer.class)
  @JsonDeserialize(using = ZonedDateTimeCustomDeserializer.class)
  private ZonedDateTime created;

  @JsonSerialize(using = ZonedDateTimeCustomSerializer.class)
  @JsonDeserialize(using = ZonedDateTimeCustomDeserializer.class)
  @JsonProperty("modified")
  @JsonInclude(Include.NON_NULL)
  private ZonedDateTime lastModified;

  public LbuTimestampBean()
  {
    setCreatedNow();
    setLastModifiedNow();
  }

  public void setCreatedNow()
  {
    created = ZonedDateTime.now();
  }

  private void setLastModifiedNow()
  {
    setLastModified(ZonedDateTime.now());
  }

  public ZonedDateTime getCreated()
  {
    return created;
  }

  public void setCreated(ZonedDateTime time)
  {
    created = time;
  }

  public ZonedDateTime getLastModified()
  {
    return lastModified;
  }

  public void setLastModified(ZonedDateTime modified)
  {
    lastModified = modified;
  }
}
