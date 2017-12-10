package beans;

public class SimpleObject {

    public String desc;
    public int val;
    
    public SimpleObject(String s, int i) {
        desc = s;
        val = i;
    }
    
    public String getDesc() {
        return desc;
    }
    
    public int getVal() {
        return val;
    }
    
    public void setDesc(String s) {
        desc = s;
    }
    
    public void setVal(int i) {
        val = i;
    }
    
    @Override
    public String toString() {
        return getDesc(); //To change body of generated methods, choose Tools | Templates.
    }
}
