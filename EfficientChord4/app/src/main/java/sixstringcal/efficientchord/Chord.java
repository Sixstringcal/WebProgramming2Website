package sixstringcal.efficientchord;

/**
 * This is the superclass of the application.
 * This is where all of the gets and sets are for all the other subclasses as well as some others.
 */
public class Chord{

    /*
    *     Creates the variables needed.
    */
    private String type, interval;

    //keeps track of length.
    private int length = 0;

    /**
     * This sets the length to the variable aL that is passed in.
     * @param aL is used to set the length to it.
     */
    public void setLength(int aL){

        //sets length.
        length=aL;
    }

    /**
     * This returns the length.  It is mainly used for the logic of the application.
     * @return length is used for computations for the chord and the application as a whole.
     */
    public int getLength(){

        // gets length
        return length;
    }

    // stores the root.
    private int root;

    /*
    *    This tells the relations between notes for type.
    */
    private int[] typeRel = new int[999];

    /*
    *     Creates an integer array called notes that has space for 6 integers.
    *     There is only space for 6 integers because there are only 6 strings on a standard guitar and this application only works for a 6 string guitar.
    *     It is an integer because the note can be read as an integer.
    */
    private int[] notes = new int[6];



    /**
     * This is used to return the type to help with the logic and for the type of chord to be displayed to the user.
     * @return type to the user and also to help with the logic of the application.
     */
    public String getType(){

       // This returns the value of type.
        return type;
    }

    /**
     * This sets the chord type to the tempType passed in.
     * @param tempType is what the type of the chord is set to.
     */
    public void setType(String tempType){

       // This sets the type by the value passed in.
        type= tempType;
    }


    /**
     * Returns the value of the root.
     * @return root.
     */
    public int getRoot(){
        return root;
    }

    /**
     * Sets the root of the chord to what is passed in.
     * @param tempRoot is what root is set to.
     */
    public void setRoot(int tempRoot){
        root = tempRoot;
    }

    /**
     * This gets the interval for the chord and returns it.
     * @return interval to be shown to the user and for some logic in the application.
     */
    public String getInterval(){

       // This returns the value of interval.
        return interval;
    }


    /**
     * This sets the interval of the chord to the value of aInterval
     * @param aInterval is what the interval is set to.
     */
    public void setInterval(String aInterval){

       // This sets the interval to the value passed in.
        interval = aInterval;
    }





    /**
     * This will make the chord based on what information has been passed in by the user about the chord.
     */
    public void makeCord(){

    }



    /**
     * This will read the chords from a stored and saved file from the device.
     */
    public void readChord(){

    }



    /**
     * this will return the notes so the logic of the application can happen.
     * @return notes so the program will work.
     */
    public int[] getNotes(){

        return notes;
    }



    /**
     * This returns the relationship of the chord in integer notation.
     * @return typeRel for the logic of the application.
     */
    public int[] getTypeRel(){

        return typeRel;
    }



    /**
     * This sets the typeRel to aTypeRel for logic purposes of the application.
     * @param aTypeRel is used to set the type relationship.
     */
    public void setTypeRel(int[] aTypeRel){

       // sets the type relationship.
        typeRel = aTypeRel;
    }
}
