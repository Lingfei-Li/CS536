import java.util.*;

public class StructSym extends SemSym{
    private String type;
    private HashMap<String, String> decl;

    public StructSym(String type) {
        super();
        this.type = type;
    }
    
    public StructSym(String type, HashMap<String,String> decl) {
        super();
        this.type = type;
        this.decl = decl;
    }

    public boolean hasField(String f) {
        return decl.containsKey(f);
    }

    public String getFieldType(String f) {
        return decl.get(f);
    }

    public boolean isStruct() {
        return true;
    }
    
    public String getType() {
        return type;
    }
    
    public String toString() {
        return type;
    }
}
