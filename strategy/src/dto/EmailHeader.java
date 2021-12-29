package strategy.src.dto;

import java.util.List;
import java.util.stream.Collectors;

public class EmailHeader {
    private String from;
    private List<String> to;

    public EmailHeader(final String from,final  List<String> to){
        this.from = from;
        this.to = to;
    }

    public String getFrom(){
        return from;
    }

    public String getToAsString(){
        return this.to.stream().collect(Collectors.joining(","));
    }
}
