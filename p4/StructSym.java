import java.util.*;

public class StructSym extends SemSym{
    private String type;
    private HashMap<String, SemSym> decl;

    public StructSym(String type) {
        super();
        this.type = type;
    }
    
    public StructSym(String type, HashMap<String,SemSym> decl) {
        super();
        this.type = type;
        this.decl = decl;
    }

    public boolean hasField(String f) {
        return decl.containsKey(f);
    }

    public SemSym getFieldSym(String f) {
        return decl.get(f);
    }
    
    public String getType() {
        return type;
    }
    
    public String toString() {
        return type;
    }
}
