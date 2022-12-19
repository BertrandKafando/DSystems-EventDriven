package ma.enset.kafkaspringcloudstreamsinitiation.entities;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PageEvent implements Serializable {
    public String name;
    public String user;
    public long duration;
    public Date date;
}
