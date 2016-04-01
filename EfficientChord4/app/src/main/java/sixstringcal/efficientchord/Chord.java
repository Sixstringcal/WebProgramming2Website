package sixstringcal.efficientchord;

/**
 * This is the superclass of the application.
 * This is where all of the gets and sets are for all the other subclasses as well as some others.
 */
public class Chord {

    /*
    *     Creates the variables needed.
    */
    private String type, interval;





    // stores the root.
    private int root;



    /**
     * This is used to return the type to help with the logic and for the type of chord to be displayed to the user.
     *
     * @return type to the user and also to help with the logic of the application.
     */
    public String getType() {

        // This returns the value of type.
        return type;
    }

    /**
     * This sets the chord type to the tempType passed in.
     *
     * @param tempType is what the type of the chord is set to.
     */
    public void setType(String tempType) {

        // This sets the type by the value passed in.
        type = tempType;
    }


    /**
     * Returns the value of the root.
     *
     * @return root.
     */
    public int getRoot() {
        return root;
    }

    /**
     * Sets the root of the chord to what is passed in.
     *
     * @param tempRoot is what root is set to.
     */
    public void setRoot(int tempRoot) {
        root = tempRoot;
    }

    /**
     * This gets the interval for the chord and returns it.
     *
     * @return interval to be shown to the user and for some logic in the application.
     */
    public String getInterval() {

        // This returns the value of interval.
        return interval;
    }


    /**
     * This sets the interval of the chord to the value of aInterval
     *
     * @param aInterval is what the interval is set to.
     */
    public void setInterval(String aInterval) {

        // This sets the interval to the value passed in.
        interval = aInterval;
    }


}