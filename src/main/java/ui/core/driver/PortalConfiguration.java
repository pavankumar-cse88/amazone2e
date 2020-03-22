package ui.core.driver;

import lombok.Getter;

import java.util.List;

@Getter
public class PortalConfiguration {
    private Long implicitTimeOutInSeconds;
    private Long pageLoadTimeOutInSeconds;
    private List<String> flags;
    private Boolean headless;
}