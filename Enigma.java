public class Enigma{
    //The Rotor Strings
    private String rotorInit[] = {"#GNUAHOVBIPWCJQXDKRYELSZFMT",
        "#EJOTYCHMRWAFKPUZDINSXBGLQV",
        "#BDFHJLNPRTVXZACEGIKMOQSUWY",
        "#NWDKHGXZVRIFJBLMAOPSCYUTQE",
        "#TGOWHLIFMCSZYRVXQABUPEJKND"};

    //Assignment of an array with rotors
    private Rotor rotors[];
    //Engima constructor
    public Enigma(int id1, int id2, int id3, String start){

        rotors = new Rotor[3];
        rotors[0] = new Rotor(rotorInit[id1-1], start.charAt(0));
        rotors[1] = new Rotor(rotorInit[id2-1], start.charAt(1));
        rotors[2] = new Rotor(rotorInit[id3-1], start.charAt(2));
        
    }

    //This methow would decrypt a message on a engima machine
    //@param an already encrypted message
    //@return the method would return the original message before it was encrypted
    public String decrypt(String message){   
        //Assign a new variable which is the message we want to decrypt but in char[]     
        char[] messageTemp = message.toCharArray();
        //Creates a new char[] in which we would store each decrypted letter to get
        //pur message
        char[] messageFinal = new char[message.length()];
        //Assign the three rotors 
        Rotor inner = rotors[0];
        Rotor middle = rotors[1];
        Rotor outer = rotors[2];
        //This would itterate through each char in the message we want to decrypt
        for(int i = 0; i < message.length(); i++){
            //The decryption Algo which goes from
            //outer->middle->outer->inner
            int step1 = outer.indexOf(messageTemp[i]);
            char step2 = middle.charAt(step1);
            int step3 = outer.indexOf(step2);
            char step4 = inner.charAt(step3);
            //assign the decrypted char into the final char[] which would be the output
            messageFinal[i] = step4;
            //rotate the rotors
            rotate();            
        }
        //Turn our final decrypted char[] into a string and return it
        String output = new String(messageFinal);
        return output;
    }


    //This method would encrypt a message in our engima machine
    //@param the paramteres is the message we want to encrypt
    //@return this methof would return the ecrypted message
    public String encrypt(String message){
        //Assign a new variable which is the message we want to encrypt but in char[]     
        char[] messageTemp = message.toCharArray();
        // Creates an empty char[] which we would sotre each enrytped char
        char[] messageFinal = new char[message.length()];
        //Assign all the rotors 
        Rotor inner = rotors[0];
        Rotor middle = rotors[1];
        Rotor outer = rotors[2];
        //itterate through each char in the message to encrypt
        for(int i = 0; i < message.length() ; i++){
            //The encryption algo
            //inner->outer->middle->outer
            int step1 = inner.indexOf(messageTemp[i]);
            char step2 = outer.charAt(step1);
            int step3 = middle.indexOf(step2);
            char step4 = outer.charAt(step3);
            //Assign the encrypted char into the final char[]
            messageFinal[i] = step4;
            //rotate the rotors
            rotate();
        }
        // Turn the final encrypted char[] into a string and return it
        String output = new String(messageFinal);
        return output;
        }
    

    // This method is used to rotate the rotors from inner to middle to outer
    private void rotate(){
        if(rotors[0].rotate()){
            if(rotors[1].rotate()){
                rotors[2].rotate();
            }
        }
    }
    
}

