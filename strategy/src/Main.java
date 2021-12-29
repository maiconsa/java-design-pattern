package strategy.src;

import java.util.List;
import strategy.src.ArgsProcessor.ArgPair;
import strategy.src.dto.EmailHeader;
import strategy.src.dto.PayloadEmail;

public class Main {

    public static void main(final String... args) throws Exception {
        ArgsProcessor argsProcessor = new ArgsProcessor();

        List<ArgPair> pairs = argsProcessor.validateArgs(args);
        
        String providerName  = pairs.stream().filter(p -> p.shortName == ArgsProcessor.PROVIDER_SHORT_NAME_ARG).findFirst().get().value;

        EmailHeader header = new EmailHeader("from@from.com", List.of("to01@to.com"));
        PayloadEmail payload = new PayloadEmail("Test", "Content Test");
        EmailProvider.valueOf(providerName).getEmailService().execute(header, payload);
    }



    

}