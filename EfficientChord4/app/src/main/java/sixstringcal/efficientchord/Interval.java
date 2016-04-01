package sixstringcal.efficientchord;

/**
 * This is a subclass of the Chord class and uses informatin about the interval to help form the chord.
 */
public class Interval extends Chord{

    private int[] chordWithInterval;

    /**
     * This will decide what effect the interval has on the chord
     * @param rootString is what string the root note is on.
     * @param type is what type of chord it is.
     * @return chordWithInterval.
     */
    public int[] decideIntervalEffect(int[] oldChord, int type, int rootString){
        chordWithInterval = oldChord;
        if(super.getInterval().equals(" 7")){
            if((type == 0)||(type == 1)){
                chordWithInterval[2] = chordWithInterval[2] - 2;
            }
            else if(type == 3){
                if(rootString == 6){
                    chordWithInterval[1] = chordWithInterval[1] - 2;
                }
                else if(rootString == 5){
                    chordWithInterval[4] = chordWithInterval[4] + 2;
                }
            }
        }
        else if(super.getInterval().equals(" major 7")){
            if(type == 0){
                chordWithInterval[2] = chordWithInterval[2] - 1;
            }
            else if(type ==1){
                chordWithInterval[2] = chordWithInterval[2] - 2;
                setInterval(" 7");
            }
            else if(type == 3){
                if(rootString == 6){
                    chordWithInterval[1] = chordWithInterval[1] - 2;
                }
                else if(rootString == 5){
                    chordWithInterval[4] = chordWithInterval[4] + 2;
                }
                setInterval(" 7");
            }
        }

        return chordWithInterval;
    }
}
