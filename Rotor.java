public class Rotor {

    // Assignment of variables
    private String rotorValues;
    private char startChar;
    public int length;
    // The constructor  
    public Rotor(String v, char c){
        this.rotorValues = new String(v);
        this.startChar = c;
        
        while(!this.rotate()); 
            
    }
    //This method would rotate a rotor one click clockwise
    //@return this would return true if current char matches with starting
    //char and false otherwise
    public boolean rotate(){
        // This would create a new variable with a char[] of the rotor
        char[] rotorTemp = this.rotorValues.toCharArray();
        // Store the last char in order to put it at the top of the rotor
        char lastChar = rotorTemp[rotorTemp.length - 1];
        // An itteration loop in order to shift all elements in the array right one spot
        for(int i = rotorTemp.length - 1; i > 0; i--){
            rotorTemp[i] = rotorTemp[i - 1];
        }
        // Assign the first element in the array to the lastchar previously because 
        // each last char in the rotor belongs up top
        rotorTemp[0] = lastChar;
        // Turn the temp variable from a char[] to a string an assign it back to our constructor thus
        // completeing a rotate
        this.rotorValues = new String(rotorTemp);
        // The rotate method would return true if the current char matches it's starting char
        if(this.rotorValues.charAt(0) == startChar){
            return true;
        }
        //false otherwise
        return false;
    }
    
    // This method would find the index of a specific char in the rotor
    //@param The parameter is the char we are looking for
    //@return returns the index of a the char we are looking for
    public int indexOf(char c){
        //Create a new variable of the rotor into a char[]
        char[] rotorTemp = rotorValues.toCharArray();
        //itterate through each element in the char array
        for(int i = 0 ; i < rotorTemp.length; i++){
            //If the char matches with the char called in the param return the i
            if(rotorTemp[i] == c){
                return i;
            }
        }
        //returns -1 if not found, however it should never return this
        return -1;
    }
    //Thi method would find the char at a specific index we are looking for
    //@param the index where the char we want to get
    public char charAt(int idx){
        //This would turn the rotor into a char[]
        char[] rotorTemp = rotorValues.toCharArray();
        //This would return the single char from the char[] where the index/position lies
        return rotorTemp[idx];
    }
}
    
