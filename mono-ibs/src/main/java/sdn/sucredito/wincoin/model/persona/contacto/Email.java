package sdn.sucredito.wincoin.model.persona.contacto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class Email {

    String email;

    public static Email of(
            String raw
    ) {
        return new Email(raw);
    }
}
