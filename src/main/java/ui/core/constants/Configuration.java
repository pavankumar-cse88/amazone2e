package ui.core.constants;

import java.nio.file.Paths;

public class Configuration {

    private static String rootDirectory = System.getProperty("user.dir");

    public static  String PortalConfigurationJsonPath =
            Paths.get(rootDirectory, "src", "main", "resources", "PortalConfiguration.json").toString();
}
