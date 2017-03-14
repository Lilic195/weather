package klase;

import java.util.ArrayList;

/**
 * Created by Aleksa on 13-Jan-17.
 */
public class Drzava {
    private String Name;
    private String Code;

    public Drzava(String name, String code) {
        Name = name;
        Code = code;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    @Override
    public String toString() {
        return Name + ", " + Code;
    }
}
