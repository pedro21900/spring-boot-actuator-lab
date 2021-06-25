
package springbootactuatorlab.core;

import org.springframework.boot.actuate.audit.InMemoryAuditEventRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@Component
public class AuditLogin {

    //private static final Logger LOG = LoggerFactory.getLogger(AuditLogin.class);
    
   /* @EventListener evendo para disparar no terminal resposta
    public void onAuditEvent(AuditApplicationEvent event) {
        AuditEvent actualAuditEvent = event.getAuditEvent();

        LOG.info("On audit application event: timestamp: {}, principal: {}, type: {}, data: {}",
                actualAuditEvent.getTimestamp(),
                actualAuditEvent.getPrincipal(),
                actualAuditEvent.getType(),
                actualAuditEvent.getData()
        );

    }*/
   @Bean //evento para colocar em memoria os resultados de auditoria
   public InMemoryAuditEventRepository repository() {
       return new InMemoryAuditEventRepository();
   }
}
