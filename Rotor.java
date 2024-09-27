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
        for(int i = 1; i < rotorTemp.length; i++){
            rotorTemp[i] = rotorTemp[i - 1];
        }
        String rotorFinal = rotorTemp.toString();
        rotorValues = rotorFinal;
        startChar = rotorTemp[0];
        return true;
        
    }
    

    public int indexOf(char c){
        char[] rotorTemp = rotorValues.toCharArray();
        for(int i = 0 ; i < rotorTemp.length; i++){
            if(rotorTemp[i] == c){
                System.err.println("Hi");
                return i;
            }
        }
        System.err.println("Hello");
        return 0;
    }

    public char charAt(int idx){
        char[] rotorTemp = rotorValues.toCharArray();
        return rotorTemp[idx];
    }
}
    
