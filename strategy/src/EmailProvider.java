package strategy.src;

import strategy.src.impl.FakeEmailService;
import strategy.src.impl.SendSMTPEmailService;

public enum EmailProvider {
    SMTP {
        public ISendEmailService getEmailService() {
            return new SendSMTPEmailService();
        }
    },
    FAKE {
        public ISendEmailService getEmailService() {
            return new FakeEmailService();
        }

    };

    public abstract ISendEmailService getEmailService();

}
