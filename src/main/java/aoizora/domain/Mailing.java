package aoizora.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Mailing
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String recipient;

    @Column
    @Enumerated(EnumType.STRING)
    private MailingType type;

    @Column
    private int postcode;

    @Column
    private String address;

    @Column
    @Enumerated(EnumType.STRING)
    private MailingStatus status;
}
