package ui.core.driver;

public interface Driver {

    <T> T getDriverInstance(String driverName) throws Exception;
}
