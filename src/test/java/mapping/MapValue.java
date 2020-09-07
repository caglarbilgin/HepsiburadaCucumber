package mapping;

public enum MapValue {
    ID("id"), CSSSELECTOR("cssSelector");

    private final String text;

    public String getText(){
        return text;
    }
    MapValue(String text){
        this.text= text;
    }

}
