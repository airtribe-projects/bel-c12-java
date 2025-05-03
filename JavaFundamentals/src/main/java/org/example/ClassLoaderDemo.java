import java.net.URL;
import java.net.URLClassLoader;

public class ClassLoaderDemo {

    public static void main(String[] args) {
        System.out.println("=== Class Loader Hierarchy ===\n");

        // Check which class loader loads each class
        printClassLoader("java.lang.String");             // Bootstrap
        printClassLoader("javax.crypto.Cipher");          // Extension
        printClassLoader("ClassLoaderDemo");              // Application

        System.out.println("\n=== Class Loader Paths ===\n");

        // Print Bootstrap ClassLoader classpath
        printBootstrapClasspath();

        // Print Extension ClassLoader classpath
        printExtensionClasspath();

        // Print Application ClassLoader classpath
        printApplicationClasspath();

        System.out.println("\n=== Class Loader Hierarchy ===\n");

        // Print class loader hierarchy
        printClassLoaderHierarchy();
    }

    private static void printClassLoader(String className) {
        try {
            Class<?> clazz = Class.forName(className);
            ClassLoader loader = clazz.getClassLoader();

            System.out.println("Class: " + className);
            if (loader == null) {
                System.out.println("  ➤ Loaded by: Bootstrap ClassLoader");
            } else {
                System.out.println("  ➤ Loaded by: " + loader.getClass().getName());
            }
            System.out.println();
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load class: " + className);
        }
    }

    private static void printBootstrapClasspath() {
        System.out.println("Bootstrap ClassLoader loads from:");
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (URL url : urls) {
            System.out.println("  - " + url);
        }
        System.out.println();
    }

    private static void printExtensionClasspath() {
        System.out.println("Extension ClassLoader loads from:");
        String extDirs = System.getProperty("java.ext.dirs");
        if (extDirs != null) {
            for (String path : extDirs.split(":")) {
                System.out.println("  - " + path);
            }
        } else {
            System.out.println("  - Not available");
        }
        System.out.println();
    }

    private static void printApplicationClasspath() {
        System.out.println("Application ClassLoader loads from:");
        String classpath = System.getProperty("java.class.path");
        if (classpath != null) {
            for (String path : classpath.split(":")) {
                System.out.println("  - " + path);
            }
        } else {
            System.out.println("  - Not available");
        }
        System.out.println();
    }

    private static void printClassLoaderHierarchy() {
        ClassLoader cl = ClassLoader.getSystemClassLoader(); // AppClassLoader
        while (cl != null) {
            System.out.println("ClassLoader: " + cl.getClass().getName());
            cl = cl.getParent();
        }
        System.out.println("Reached Bootstrap ClassLoader (null)");
    }
}
