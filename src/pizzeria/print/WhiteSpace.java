package pizzeria.print;

public class WhiteSpace {
    public StringBuffer print(String name) {
        StringBuffer space = new StringBuffer(name);
        int spacesDistance = 20;
        for (int i = 0; i < spacesDistance - name.length(); i++) {
            space = space.append(" ");
        }
        return space;
    }
}
