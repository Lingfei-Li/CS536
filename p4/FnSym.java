import java.util.List;

public class FnSym extends SemSym{
    private String type;
    private List<String> params;    //for unparser
    
    public FnSym(String type, List<String> params) {
        super();
        this.type = type;
        this.params = params;
    }
    
    public String getType() {
        return type;
    }
    
    public String toString() {
        String str = "";
        for(String p : params){
            if(!str.equals("")) str += ",";
            str += p;
        }
        str += "->" + this.type;
        return str;
    }
}
