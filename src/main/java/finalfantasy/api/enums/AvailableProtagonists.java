package finalfantasy.api.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum AvailableProtagonists {

    EMPTY(new ArrayList<String>(Arrays.asList("", ""))),
    FF7(new ArrayList<String>(Arrays.asList("Cloud", "Tifa"))),
    FF8(new ArrayList<String>(Arrays.asList("Squall", "Rinoa", "Zell", "Irvine", "Edea", "Selphie", "Quistis", "Seifer", "Laguna", "Kiros", "Ward", "Adel", "Ultimecia"))),
    ;

    private ArrayList<String> availableProtagonistList;

    AvailableProtagonists(ArrayList<String> availableProtagonistList) {
        this.availableProtagonistList = availableProtagonistList;
    }

    public ArrayList<String> getAvailableProtagonistList() {
        return availableProtagonistList;
    }
}
