public class Rotor {

    
    private String rotorValues;
    private char startChar;
    public int length;
        
    public Rotor(String v, char c){
        this.rotorValues = new String(v);
        this.startChar = c;
        
        while(!this.rotate()); 
            
    }
    
    public boolean rotate(){
        char[] rotorTemp = rotorValues.toCharArray();
        startChar = rotorTemp[0];
        for(int i = 0; i < rotorTemp.length - 1; i++){
            rotorTemp[i] = rotorTemp[i + 1];
        }
        rotorTemp[rotorTemp.length - 1] = startChar;
        String rotorFinal = new String(rotorTemp);
        rotorValues = rotorFinal;
        return true;
        
    }
    

    public int indexOf(char c){
        char[] rotorTemp = rotorValues.toCharArray();
        for(int i = 0 ; i < rotorTemp.length; i++){
            if(rotorTemp[i] == c){
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
    
