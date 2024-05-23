// unnamed package

import java.lang.module.ModuleFinder;
import java.nio.file.Path;
import run.bach.ModuleResolver;
import run.bach.ToolFinder;
import run.info.org.junit.JUnit;

/**
 * An application installing and running JUnit via its modular tool provider.
 */
class JUnitRunner {

    public static void main(String... args) {
        var lib = Path.of("lib");

        System.out.println("\nResolving JUnit modules into " + lib.toUri() + " ...");
        var resolver = ModuleResolver.ofSingleDirectory(lib, JUnit.MODULES);
        resolver.resolveModule("org.junit.jupiter"); // to write and discover tests
        resolver.resolveModule("org.junit.platform.console"); // to run tests
        resolver.resolveMissingModules();

        var modules = ModuleFinder.of(lib);
        System.out.println("\nModules found in " + lib + " directory:");
        modules.findAll().stream()
                .map(mr -> "\t" + mr.descriptor().toNameAndVersion())
                .sorted()
                .forEach(System.out::println);

        var tools = ToolFinder.of(modules);
        System.out.println("\nAbout to run JUnit...");
        tools.get("junit").run(args.length == 0 ? new String[]{"--version"} : args);
    }
}
