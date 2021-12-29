package strategy.src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;


public class ArgsProcessor {
    public  static final String PROVIDER_LONG_NAME_ARG = "-email_provider";
    public static final String PROVIDER_SHORT_NAME_ARG = "-ep";

    private List<ComandArg> ARGS_AVALIABLE=List.of(new ComandArg(PROVIDER_LONG_NAME_ARG,PROVIDER_SHORT_NAME_ARG,value->{
        try{EmailProvider.valueOf(value);return true;}
        catch(Exception e){return false;}
    }));

    public List<ArgPair> validateArgs(String... args) throws Exception {
        List<String> arguments = args.length == 0 ? List.of("-ep", "FAKE") : Arrays.asList(args);
        List<ArgPair> pairs = new ArrayList<>();
        Iterator<String> iterator = arguments.iterator();
        while (iterator.hasNext()) {
            String argName = iterator.next();
            Optional<ComandArg> comandFinded = ARGS_AVALIABLE.stream()
                    .filter(predicate -> predicate.isArgNameValid(argName)).findFirst();
            if (!comandFinded.isPresent()) {
                throw new Exception("Comand " + argName + " is invalid");
            }
            String argValue = iterator.hasNext() ?  iterator.next() : null;
            if (!comandFinded.get().isValueValid(argValue)) {
                throw new Exception("Invalid value argment " + argValue + " for argument " + argName);
            }
            pairs.add(new ArgPair(comandFinded.get().getShortName(), argValue));
        }
        return pairs;
    }

    public static class ArgPair {
        public String shortName;
        public String value;

        public ArgPair(String shortName, String value) {
            this.shortName = shortName;
            this.value = value;
        }
    }

    public static class ComandArg {
        public String longName;
        public String shortName;
        private ComandArgValueValidator validator;

        public ComandArg(String longName, String shortName, ComandArgValueValidator validator) {
            this.longName = longName;
            this.shortName = shortName;

            this.validator = validator;
        }

        public boolean isArgNameValid(String argName) {
            return argName.equals(this.shortName) || argName.equals(this.longName);
        }

        public boolean isValueValid(String value) {
            return this.validator.validate(value);
        }

        public String getShortName() {
            return this.shortName;
        }

    }

    public static interface ComandArgValueValidator {
        boolean validate(String argValue);
    }
}
