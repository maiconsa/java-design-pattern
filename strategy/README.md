
## Whats is Strategy Pattern

Basicaly Strategy pattern has an abstract class or interface that is implemented by the concrete classes. Also a Context Classe is required for manage or switch between the concrete classes based on a strategy related with the business problem.
![Alt text](https://i2.wp.com/www.e4developer.com/wp-content/uploads/2018/10/strategy-pattern.png?w=669&ssl=1 "Reference image : https://www.e4developer.com/2018/10/14/my-favourite-design-pattern-strategy/")

Image get from:https://www.e4developer.com/2018/10/14/my-favourite-design-pattern-strategy/ 


## Goal of this example
To show  the Strategy pattern in action we will follow an example of email service. In this example we have a interface called ISendEmailService.java and two concrete classe named by FakeEmailService.java and SendSMTPEmailService.java.The Main.java is our Context Classe that will receive the name (provider name) of e-mail service that should be used to send e-mail. Based on the provider name the strategy for e-mail service  will be mounted and executed

To improve  and filter the arguments that user provide was implemented a Argument Processor that has responsability to validated the arguments name and value for this example.


## Requirements

- Java 11

## Executing 

Args Available on this example are:


| Long  Name    |   Short  Name |   Values    |
| ------------- | ------------- |-------------|
|-email_provider|       -ep     |FAKE , SMTP|

if an invalid argument or value was provider an exception is throw.

### Linux
```bash 
    javac -d  target/  -sourcepath /src $(find src -name "*.java") --release 11 
    java -cp target/ strategy.src.Main [ARG_NAME] [ARG_VALUE]

```

## Example
### SMTP
Calling :
```bash 
   java -cp target/ strategy.src.Main -email_provider SMTP
```
Response:
```bash 
[SendSMTPEmailService] - title :  Test - content : Content Test - from : from@from.com - to : to01@to.com
```

### FAKE
Calling :
```bash 
   java -cp target/ strategy.src.Main -email_provider SMTP
```
Response:
```bash 
[strategy.src.impl.FakeEmailService] - title :  Test - content : Content Test - from : from@from.com - to : to01@to.com
```
### Invalid Arg Value Provider
Calling :
```bash
  java -cp target/ strategy.src.Main -email_provider NON_EXIST
```
Exception:
```bash
 Exception in thread "main" java.lang.Exception: Invalid value argment NON_EXIST for argument -email_provider
        at strategy.src.ArgsProcessor.validateArgs(ArgsProcessor.java:32)
        at strategy.src.Main.main(Main.java:13)
```
### Invalid Arg Name 
Calling :
```bash
 java -cp target/ strategy.src.Main -emailprovider SMTP
```
Exception:
```bash
Exception in thread "main" java.lang.Exception: Comand -emailprovider is invalid
        at strategy.src.ArgsProcessor.validateArgs(ArgsProcessor.java:28)
        at strategy.src.Main.main(Main.java:13)
```
