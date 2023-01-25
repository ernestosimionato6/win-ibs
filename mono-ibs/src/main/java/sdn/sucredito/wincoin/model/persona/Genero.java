package sdn.sucredito.wincoin.model.persona;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@ToString
@Builder
@Data
public class Genero {

    String value;

   public static Genero of(String raw) {
       return new Genero(raw);
   }

}
