package sixstringcal.efficientchord;

/**
 * Subclass of Chord.
 */
public class Root  extends Chord{

    private int[] eMajorChordNotes = {0,2,2,1,0,0};
    private int[] aMajorChordNotes = {0,2,2,2,0};
    private int[] returnedNotes;
    private int whichString;
    private int currentRoot;


    /**
     * This decides where each chord will be played.
     * @param rootBefore is what was the root for the last chord.
     * @param stringBefore is what string the last note was played on.
     * @return returnedNotes.
     */
    public int[] majorPosition(int rootBefore, int stringBefore){
        currentRoot = rootBefore;
        if(rootBefore == -1){
            returnedNotes = new int[6];
            whichString = 6;
            if(super.getRoot() <7){
                for(int i = 0; i < 6; i++){
                    returnedNotes[i] = eMajorChordNotes[i] + super.getRoot() - 7 + 12;
                }
            }
            else{
                for(int i = 0; i < 6; i++){
                    returnedNotes[i] = eMajorChordNotes[i]+super.getRoot() - 7;
                }
            }

        }
        else if(rootBefore == super.getRoot()){
            if(stringBefore == 5){
                returnedNotes = new int[5];
                whichString = 5;
                for(int i = 0; i<5; i++){
                    returnedNotes[i] = aMajorChordNotes[i]+super.getRoot();
                }
            }
            else if(stringBefore == 6){
                returnedNotes = new int[6];
                whichString = 6;
                if(super.getRoot() < 8){

                    for(int i = 0; i<6;i++){
                        returnedNotes[i] = eMajorChordNotes[i]+super.getRoot()-7+12;
                    }
                }
                else{
                    for(int i = 0; i< 6; i++){
                        returnedNotes[i] = eMajorChordNotes[i]+super.getRoot() - 7;
                    }
                }
            }
        }
        else if((stringBefore == 6)&&(super.getRoot() == rootBefore + 5)){
            returnedNotes = new int[5];
            whichString = 5;
            for(int i = 0; i < 5; i++){
                returnedNotes[i] = aMajorChordNotes[i] + super.getRoot();
            }
        }
        else if((stringBefore == 5)&&(rootBefore == super.getRoot() + 5)){
            whichString = 6;
            returnedNotes = new int[6];
            for(int i = 0; i < 6; i++){
                returnedNotes[i] = eMajorChordNotes[i] - 7 + super.getRoot();
            }
        }
        else if((rootBefore < super.getRoot())&&((super.getRoot() - 4) < 0)){
            whichString = stringBefore;
            returnedNotes = new int[stringBefore];
            for(int i = 0; i< stringBefore; i++){
                if(whichString == 5) {
                    returnedNotes[i] = aMajorChordNotes[i] + super.getRoot();
                }
                else if(whichString == 6){
                    returnedNotes[i] = eMajorChordNotes[i]+super.getRoot();
                }
            }
        }
        else if((rootBefore < super.getRoot())&&(super.getRoot()-4) > -1){
            if(stringBefore == 5){
                whichString = 5;
                returnedNotes = new int[5];
                for(int i = 0; i< 5; i++) {
                    returnedNotes[i] = aMajorChordNotes[i] + super.getRoot();
                }
            }
            else if((stringBefore == 6)&&((super.getRoot() - 5) > -1)){
                whichString = 6;
                returnedNotes = new int[6];
                for(int i = 0; i < 6; i++){
                    returnedNotes[i] = eMajorChordNotes[i] + super.getRoot();
                }
            }
            else if((stringBefore == 6)&&((super.getRoot() - 5) < 0)){
                for(int i =0; i < 6; i++){
                    returnedNotes[i] = eMajorChordNotes[i] + super.getRoot() - 7;
                }
            }
        }
        else{
            for(int i = 0; i<6; i++){
                returnedNotes[i] = eMajorChordNotes[i] + super.getRoot() - 7;
            }
        }
        return returnedNotes;
    }

    /**
     * This returns the string of which the root is on.
     * @return whichString.
     */
    public int getWhichString(){
        return whichString;
    }
    public int getCurrentRoot(){
        return currentRoot;
    }
}
