

## Requirements

- Java 11

## Executing 

### Linux
```bash 
    javac -d  target/  -sourcepath /src $(find src -name "*.java") --release 11 
    java -cp target/ strategy.src.Main -ep SMTP

```