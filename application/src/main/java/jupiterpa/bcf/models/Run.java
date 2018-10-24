package jupiterpa.bcf.models;

import javax.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Accessors(chain = true)
public class Run {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fromYear;
    private String toYear;
    private boolean testMode;
    private boolean reset;
    private boolean resetAA;
    private boolean persistOriginalAccount;
    private String log;
}

