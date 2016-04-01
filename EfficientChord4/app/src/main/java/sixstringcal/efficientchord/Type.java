package sixstringcal.efficientchord;

/**
 * This is a subclass of chord and decides the Type of chord.
 */
public class Type extends Chord{

    private int[] notesInChord;

    /**
     * This modulates the existing outline of a chord that is passed in and modifies it given the requirements.
     * @param existingChord is the rough outline of the existing chord.
     * @return notesInChord.
     */
    public int[] findNotes(int[] existingChord){
        notesInChord = existingChord;
        // This checks if it is major.
        if (super.getType() == "major"){
            notesInChord = existingChord;
        }

        // this checks if it is minor.
        else if(super.getType() == "minor"){
            notesInChord[3] = notesInChord[3] - 1;
        }

        else if(super.getType() == "diminished"){
            notesInChord[1] = notesInChord[1]-1;
            notesInChord[3] = notesInChord[3]-1;
            notesInChord[4] = notesInChord[4]+2;
        }

        else if(super.getType() == "augmented"){
            notesInChord[1] = notesInChord[1]+1;
            notesInChord[4] = notesInChord[4]+1;
        }
        return notesInChord;
    }
}
