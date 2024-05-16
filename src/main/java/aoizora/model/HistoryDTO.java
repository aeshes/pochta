package aoizora.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HistoryDTO
{
    private long mailingId;

    private int fromPostcode;

    private int toPostcode;
}
