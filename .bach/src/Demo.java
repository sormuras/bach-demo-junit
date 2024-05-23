
import bach.info.org.junit.JUnit;
import java.lang.module.ModuleFinder;
import java.nio.file.Path;
import run.bach.ModuleResolver;
import run.bach.ToolFinder;

class Demo {
    public static void main(String... args) {
        var lib = Path.of("lib");
        var resolver = ModuleResolver.ofSingleDirectory(lib, JUnit.MODULES);
        resolver.resolveModule("org.junit.jupiter"); // to write and discover tests
        resolver.resolveModule("org.junit.platform.console"); // to run tests
        resolver.resolveMissingModules();

        var tools = ToolFinder.of(ModuleFinder.of(lib));
        tools.get("junit").run(args.length == 0 ? new String[]{"--version"} : args);
    }
}
