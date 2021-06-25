
package springbootactuatorlab.core;

import org.springframework.boot.actuate.audit.InMemoryAuditEventRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AuditLogin {

   @Bean //evento para colocar em memoria os resultados de auditoria
   public InMemoryAuditEventRepository repository() {
       return new InMemoryAuditEventRepository();
   }
}
