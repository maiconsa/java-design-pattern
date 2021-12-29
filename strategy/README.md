

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
