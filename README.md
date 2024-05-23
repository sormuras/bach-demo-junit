# bach-demo-junit
✅ Bach + JUnit

Running
```shell
java @junit engines
```
on Java 22+ yields:
```
| org.junit.platform.console/junit@1.11.0-M2 engines

💚 Thanks for using JUnit! Support its development at https://junit.org/sponsoring

junit-jupiter (org.junit.jupiter:junit-jupiter-engine:5.11.0-M2)
```

## Mind Submodules

Clone with `--recurse-submodules`!
```shell
git clone --recurse-submodules https://github.com/sormuras/bach-demo-junit
```

If you already cloned the project and forgot `--recurse-submodules` you can initialize, fetch and checkout any nested submodules via:
```shell
git submodule update --init --recursive
```

## Command History

The following commands were used to configure this project.

```shell
sdk install java 22-open
git submodule add --name run.bach https://github.com/sormuras/run.bach .bach/src/run/bach
git submodule add --name junit https://github.com/junit-team/bach-info .bach/src/run/info/org/junit
edit .bach/src/JUnitRunner.java
java .bach/src/JUnitRunner.java
echo ".bach/src/JUnitRunner.java" > junit
java @junit engines
```
