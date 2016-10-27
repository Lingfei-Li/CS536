import java.util.List;

public class FnSym extends SemSym{
    private String type;
    private List<String> params;
    
    public FnSym(String type, List<String> params) {
        super();
        this.type = type;
        this.params = params;
    }

    public boolean isStruct() {
        return false;
    }
    
    public String getType() {
        return type;
    }
    
    public String toString() {
        String str = "";
        for(String p : params){
            str += p + " ";
        }
        str += " -> " + this.type;
        return str;
    }
}
