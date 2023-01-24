package sdn.sucredito.wincoin.ibs.jdbc.checker;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@Builder
public class ChechResult {

    boolean success;
    String errorMessage;

}
