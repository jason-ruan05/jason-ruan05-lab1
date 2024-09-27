public class Enigma{

    private String rotorInit[] = {"#GNUAHOVBIPWCJQXDKRYELSZFMT",
        "#EJOTYCHMRWAFKPUZDINSXBGLQV",
        "#BDFHJLNPRTVXZACEGIKMOQSUWY",
        "#NWDKHGXZVRIFJBLMAOPSCYUTQE",
        "#TGOWHLIFMCSZYRVXQABUPEJKND"};


    private Rotor rotors[];
        
    public Enigma(int id1, int id2, int id3, String start){

        rotors = new Rotor[3];
        rotors[0] = new Rotor(rotorInit[id1-1], start.charAt(0));
        rotors[1] = new Rotor(rotorInit[id2-1], start.charAt(1));
        rotors[2] = new Rotor(rotorInit[id3-1], start.charAt(2));
        
    }


    public String decrypt(String message){        
        char[] messageTemp = message.toCharArray();
        char[] messageFinal = new char[message.length()];
        Rotor inner = rotors[0];
        Rotor middle = rotors[1];
        Rotor outer = rotors[2];
        for(int i = 0; i < message.length(); i++){
            int step1 = outer.indexOf(messageTemp[i]);
            char step2 = middle.charAt(step1);
            int step3 = outer.indexOf(step2);
            char step4 = inner.charAt(step3);
            messageFinal[i] = step4;
            rotate();            
        }
        // for(int i = 0; i <= 27; i++){
        //     int step1 = outer.indexOf(messageTemp[i]);
        //     char step2 = middle.charAt(step1);
        //     int step3 = outer.indexOf(step2);
        //     char step4 = inner.charAt(step3);
        //     messageFinal[j] = step4;
        //     rotate();
        //     break;
        // }
        String output = new String(messageFinal);
        return output;
    }


    
    public String encrypt(String message){
        char[] messageTemp = message.toCharArray();
        char[] messageFinal = new char[message.length()];
        Rotor inner = rotors[0];
        Rotor middle = rotors[1];
        Rotor outer = rotors[2];
        for(int i = 0; i < message.length() ; i++){
            int step1 = inner.indexOf(messageTemp[i]);
            char step2 = outer.charAt(step1);
            int step3 = middle.indexOf(step2);
            char step4 = outer.charAt(step3);
            messageFinal[i] = step4;
            rotate();
        }
        String output = new String(messageFinal);
        return output;
        }
    

    
    private void rotate(){
        if(rotors[0].rotate()){
            if(rotors[1].rotate()){
                rotors[2].rotate();
            }
        }
    }
    
}

