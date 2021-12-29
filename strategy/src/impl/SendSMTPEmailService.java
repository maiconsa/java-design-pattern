package strategy.src.impl;

import strategy.src.ISendEmailService;
import strategy.src.dto.EmailHeader;
import strategy.src.dto.PayloadEmail;

public class SendSMTPEmailService implements ISendEmailService {
    private final String MESSAGE_LOG = "[%s] - title :  %s - content : %s - from : %s - to : %s";
    @Override
    public void execute(EmailHeader header, PayloadEmail payload) {
        String message =  String.format(MESSAGE_LOG, this.getClass().getSimpleName(), payload.getTitle() , payload.getContent() , header.getFrom() , header.getToAsString());
        System.out.println(message); 
    }
    
}
