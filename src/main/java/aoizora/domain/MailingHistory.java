package aoizora.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class MailingHistory
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private long mailingId;

    @Column
    private int fromPostcode;

    @Column
    private int toPostcode;
}
