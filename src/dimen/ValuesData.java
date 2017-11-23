package dimen;

public class ValuesData {
    public String dirName;
    public float value;
    public StringBuilder result = new StringBuilder();

    public ValuesData(String dirName, String value) {
        this.dirName = dirName;
        this.value = Integer.parseInt(value);
    }
}
