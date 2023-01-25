package sdn.piano.ibs.dd.domain;

import lombok.*;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Tramite {

public String nroTramite;
public EstadoTramite estado;


public static Tramite aprobado(String nroTramite) {
 return new Tramite(nroTramite, EstadoTramite.APROBADO);
}

public static Tramite rechazado(String nroTramite) {
 return new Tramite(nroTramite, EstadoTramite.RECHAZADO);
}

public static Tramite of(String nroTramite, String estadoTramite) {
  return new Tramite(nroTramite, EstadoTramite.startWith(estadoTramite));
}

}
