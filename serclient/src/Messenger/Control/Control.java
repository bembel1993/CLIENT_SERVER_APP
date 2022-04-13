package Messenger.Control;

import java.io.IOException;

public interface Control {

    void demoCaseMenuInfo(int push) throws IOException, ClassNotFoundException;

    boolean isValid(int ch);

}
