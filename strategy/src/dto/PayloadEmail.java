package strategy.src.dto;

public class PayloadEmail {
    private String title;
    private String content;

    public PayloadEmail(String title, String content){
        this.title = title;
        this.content  = content;
    }

    public String getTitle(){
        return this.title;
    }

    public String getContent(){
        return this.content;
    }
}
