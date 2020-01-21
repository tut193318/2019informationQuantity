package s4.B193311; // Please modify to s4.Bnnnnnn, where nnnnnn is your student ID. 
import java.lang.*;
import s4.specification.*;

/*
interface FrequencerInterface {     // This interface provides the design for frequency counter.
    void setTarget(byte[]  target); // set the data to search.
    void setSpace(byte[]  space);  // set the data to be searched target from.
    int frequency(); //It return -1, when TARGET is not set or TARGET's length is zero
                    //Otherwise, it return 0, when SPACE is not set or Space's length is zero
                    //Otherwise, get the frequency of TAGET in SPACE
    int subByteFrequency(int start, int end);
    // get the frequency of subByte of taget, i.e target[start], taget[start+1], ... , target[end-1].
    // For the incorrect value of START or END, the behavior is undefined.
}
*/

/*
package s4.specification;
public interface InformationEstimatorInterface{
    void setTarget(byte target[]); // set the data for computing the information quantities
    void setSpace(byte space[]); // set data for sample space to computer probability
    double estimation(); // It returns 0.0 when the target is not set or Target's length is zero;
// It returns Double.MAX_VALUE, when the true value is infinite, or space is not set.
// The behavior is undefined, if the true value is finete but larger than Double.MAX_VALUE.
// Note that this happens only when the space is unreasonably large. We will encounter other problem anyway.
// Otherwise, estimation of information quantity, 
}                        
*/


public class TestCase {
    public static void main(String[] args) {
	try {
	    FrequencerInterface  myObject;
	    int freq;
	    System.out.println("checking s4.B193311.Frequencer");
	    myObject = new s4.B193311.Frequencer();
	    myObject.setSpace("Hi Ho Hi Ho".getBytes());
	    myObject.setTarget("H".getBytes());
	    freq = myObject.frequency();
	    System.out.print("\"H\" in \"Hi Ho Hi Ho\" appears "+freq+" times. ");
	    if(4 == freq) { System.out.println("OK"); } else {System.out.println("WRONG"); }
        
        //Tests that Ogaki Masashi added. I tested on frequencer.
        //Length of TARGET is zero.
        FrequencerInterface myObject4 = new s4.B193311.Frequencer();
        myObject4.setSpace("I my me mine".getBytes());
        myObject4.setTarget("".getBytes());
        freq = myObject4.frequency();
        System.out.print("Length of TARGET is zero. ");
        if(-1 == freq) { System.out.println("OK"); } else { System.out.println("WRONG"); }
        
        //Length of SPACE is zero.
        FrequencerInterface myObject5 = new s4.B193311.Frequencer();
        myObject5.setTarget("I my me mine".getBytes());
        myObject5.setSpace("".getBytes());
        freq = myObject5.frequency();
        System.out.print("Length of SPACE is zero. ");
        if(-1 == freq) { System.out.println("OK"); } else { System.out.println("WRONG"); }

        //Correct condition
        myObject5.setSpace("Hop Step Jumpppppp!!".getBytes());
	    myObject5.setTarget("p".getBytes());
	    freq = myObject5.frequency();
	    System.out.print("\"p\" in \"Hop Step Jumpppppp!!\" appears "+freq+" times. ");
	    if(8 == freq) { System.out.println("OK"); } else {System.out.println("WRONG"); }
       
        /*
        myObject.setSpace("prpr".getBytes());
	    myObject.setTarget("prprprpr".getBytes());
	    freq = myObject.frequency();
	    System.out.print("\"prprprpr\" in \"prpr\" appears "+freq+" times. ");
	    if(0 == freq) { System.out.println("OK"); } else {System.out.println("WRONG"); }
        */
        
        /*
        freq = myObject.subByteFrequency(0, 1);
        System.out.print("\"p\" in \"prpr\" appears"+freq+" times. ");
        if(0 == freq) { System.out.println("OK");} else {System.out.println("WRONG"); }
        */

	}
	catch(Exception e) {
	    System.out.println("Exception occurred: STOP");
	}

    try {
        //SPACE and TARGET is not setted.
        FrequencerInterface myObject1 = new s4.B193311.Frequencer();
        int freq = myObject1.frequency();
        System.out.print("SPACE and TARGET is not setted. ");
        if(-1 == freq) { System.out.println("OK"); } else { System.out.println("WRONG"); }

    } catch(Exception e) {
       System.out.println("Exception occurred: STOP");
    }

    try {
        //TARGET is not setted.
        FrequencerInterface myObject2 = new s4.B193311.Frequencer();
        myObject2.setSpace("I my me mine".getBytes());
        int freq = myObject2.frequency();
        System.out.print("TARGET is not setted. ");
        if(-1 == freq) { System.out.println("OK"); } else { System.out.println("WRONG"); }

    } catch(Exception e) {
       System.out.println("Exception occurred: STOP");
    }

    try {
        //SPACE is not setted.
        FrequencerInterface myObject3 = new s4.B193311.Frequencer();
        myObject3.setTarget("m".getBytes());
        int freq = myObject3.frequency();
        System.out.print("SPACE is not setted. ");
        if(-1 == freq) { System.out.println("OK"); } else { System.out.println("WRONG"); }

    } catch(Exception e) {
       System.out.println("Exception occurred: STOP");
    }

    //I added test programs for Frequency.subBytesFrequency()
    try {
        //Correct condition
        FrequencerInterface frqObj = new s4.B193311.Frequencer();
        frqObj.setSpace("ppap".getBytes());
        frqObj.setTarget("pp".getBytes());
        int frq = frqObj.subByteFrequency(0, 2);
        System.out.print("\"pp\" in \"ppap\" appears "+frq+"times!. ");
        if(1 == frq){ System.out.println("OK"); } else { System.out.println("WRONG"); }
    }catch(Exception e){
        System.out.println("Exception occured: STOP");
    }


	try {
	    InformationEstimatorInterface myObject;
	    double value;
	    System.out.println("checking s4.B193311.InformationEstimator");
	    myObject = new s4.B193311.InformationEstimator();
	    myObject.setSpace("3210321001230123".getBytes());
	    myObject.setTarget("0".getBytes());
	    value = myObject.estimation();
	    System.out.println(">0 "+value);
	    myObject.setTarget("01".getBytes());
	    value = myObject.estimation();
	    System.out.println(">01 "+value);
	    myObject.setTarget("0123".getBytes());
	    value = myObject.estimation();
	    System.out.println(">0123 "+value);
	    myObject.setTarget("00".getBytes());
	    value = myObject.estimation();
	    System.out.println(">00 "+value);

        //Tests that Ogaki Masashi added.
        System.out.println("I check '000000000001'");
        myObject.setSpace("000000000001".getBytes());
        myObject.setTarget("0".getBytes());
        value = myObject.estimation();
        System.out.println(">0 "+value);
        myObject.setSpace("000000000001".getBytes());
        myObject.setTarget("1".getBytes());
        value = myObject.estimation();
        System.out.println(">1 "+value);


	}
	catch(Exception e) {
	    System.out.println("Exception occurred: STOP");
	}

    }
}	    
	    
