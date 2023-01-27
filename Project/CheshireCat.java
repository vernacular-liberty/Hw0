public class CheshireCat{

    String hint;

    public CheshireCat(){
        hint = "The CHESHIRE CAT appears to give you a HINT: ";
    }

    public String hint(String key){
        //figures out specific hint for current location
        if(key == "caterpillar"){
            hint+="The CATERPILLAR is indeed very knowledgeable, but the longer you stay here, the blacker your lungs will get. Try not to talk about yourself too much; it really gets him going. And don't forget--you can't leave without a proper \"goodbye\"! For some reason, the CATERPILLAR is very particular about this sort of thing.";
        }

        //It is possible to add whatever hint you want: just call System.out.println(cat.hint(key_word)) in the appropriate place in your code and add a corresponding if-statement here
        //FOR EXAMPLE:
            // if(key == "gabled"){
            //     hint+="This is MARCH MANOR., etc.";
            // }

        //returns appropriate hint given key
        return hint;
    }
}
