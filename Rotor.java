public class Rotor {

    
    private String rotorValues;
    private char startChar;
        
    public Rotor(String v, char c){
        this.rotorValues = new String(v);
        this.startChar = c;
        
        while(!this.rotate());
            
    }
    
    public boolean rotate(){
        char[] rotorTemp = rotorValues.toCharArray();
        for(int i = 0; i < rotorTemp.length; i++){
            rotorTemp[i] = rotorTemp[i - 1];
        }
        return true;
        
               
    }
    

    public int indexOf(char c){
        //TODO
    }

    public char charAt(int idx){
        //TODO
    }
}
    
