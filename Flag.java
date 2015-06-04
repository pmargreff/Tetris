/**
 *
 * @author pmargreff
 */
public class Flag {
    private boolean value_;
    
    public Flag(boolean b){
        this.value_ = b;
    }
    
    public void setValue(boolean b){
        this.value_ = b;
    }
    
    public boolean getValue(){
        return this.value_;
    }
}
