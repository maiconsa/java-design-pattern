package strategy.src;

import strategy.src.dto.EmailHeader;
import strategy.src.dto.PayloadEmail;

public interface ISendEmailService {
        public void execute(EmailHeader header , PayloadEmail payload);
}
