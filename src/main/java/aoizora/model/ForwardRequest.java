package aoizora.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ForwardRequest
{
    private long mailingId;

    private long from;

    private long to;
}
