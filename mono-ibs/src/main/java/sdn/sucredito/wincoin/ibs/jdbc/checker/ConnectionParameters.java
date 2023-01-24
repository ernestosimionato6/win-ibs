package sdn.sucredito.wincoin.ibs.jdbc.checker;

import lombok.*;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ConnectionParameters {

    String user;
    String password;
    String connectionString;
    String connectionUrl;
    String className;
}
