package aoizora.model;

import aoizora.domain.MailingStatus;
import aoizora.domain.MailingType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MailingDTO
{
    private long id;

    private String recipient;

    private MailingType type;

    private int postcode;

    private String address;

    private MailingStatus status;
}
