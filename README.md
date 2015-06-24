# remote-machine

Remotely executes code expressions represented as an JSON AST

## Usage

### Run the application locally

`lein ring server`

### Packaging and running as standalone jar

```
lein do clean, ring uberjar
java -jar target/remote-machine.jar
```

### Packaging as war

`lein ring uberwar`

## License

Copyright ©  Jose Gomez 2015
