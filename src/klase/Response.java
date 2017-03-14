package klase;

/**
 * Created by Aleksa on 13-Jan-17.
 */
public class Response {
    private Temp main;
    private String name;

    public Response(Temp main, String name) {
        this.main = main;
        this.name = name;
    }

    public Temp getMain() {
        return main;
    }

    public void setMain(Temp main) {
        this.main = main;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
