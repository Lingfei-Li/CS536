public class VarSym extends SemSym {
    private String type;
    
    public VarSym (String type) {
        super();
        this.type = type;
    }

    public String getType() {
        return type;
    }
    
    public String toString() {
        return type;
    }
}
