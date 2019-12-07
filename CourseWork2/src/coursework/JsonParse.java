package coursework;

public class JsonParse {
    
    private String json;

    public JsonParse(String json) {
        this.json = json;
    }
    public String getJsonInsideString(String need) {
        String array[] = this.json.split(need + "\":\"");

        String inside[] = array[1].split("\"");

        return inside[0];
    }
}
