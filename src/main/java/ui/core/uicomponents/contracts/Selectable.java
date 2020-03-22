package ui.core.uicomponents.contracts;

import java.util.List;

public interface Selectable {
    void select(String value);
    List<String> getValues(String keyword);
}
