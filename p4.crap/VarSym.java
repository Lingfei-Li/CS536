public class VarSym extends SemSym {
    private String type;
    
    public VarSym (String type) {
        super();
        this.type = type;
    }

    public boolean isStruct() {
        return false;
    }
    
    public String getType() {
        return type;
    }
    
    public String toString() {
        return type;
    }
}
