import java.util.*;

public class StructSym extends SemSym{
    private String type;
    private HashMap<String, String> decl;

    public StructSym(String type) {
        super();
        this.type = type;
    }
    
    public StructSym(String type, DeclListNode node) {
        super();
        this.type = type;
        this.decl = node.getDeclMap();
    }

    public boolean isStruct() {
        return true;
    }
    
    public String getType() {
        return type;
    }
    
    public String toString() {
        return "struct.toString()";
    }
}
