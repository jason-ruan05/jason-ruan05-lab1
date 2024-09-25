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
        String rotorFinal = rotorTemp.toString();
        rotorValues = rotorFinal;
        return true;
        
    }
    

    public int indexOf(char c){
        char[] rotorTemp = rotorValues.toCharArray();
        for(int i = 0 ; i < rotorTemp.length; i++){
            if(c == rotorTemp[i]){
                return i;
            }
        }
        return -1;
    }

    public char charAt(int idx){
        char[] rotorTemp = rotorValues.toCharArray();
        return rotorTemp[idx];
    }
}
    
