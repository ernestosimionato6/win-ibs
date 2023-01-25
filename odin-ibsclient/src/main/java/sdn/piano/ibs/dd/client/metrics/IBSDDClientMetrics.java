package sdn.piano.ibs.dd.client.metrics;


import lombok.*;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IBSDDClientMetrics {

public Integer consultasRecibidas = 0;
public Integer badRequests = 0;
public Integer internalErrors = 0;

public IBSDDClientMetrics hit() { 
  consultasRecibidas = consultasRecibidas + 1; 
  return this; 
} 

public IBSDDClientMetrics badRequest() {
badRequests = badRequests + 1;
return this;
};

public IBSDDClientMetrics internalError() {
internalErrors = internalErrors + 1;
return this;
} 

}
