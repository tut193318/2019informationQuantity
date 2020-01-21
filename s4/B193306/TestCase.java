package s4.B193306; // Please modify to s4.Bnnnnnn, where nnnnnn is your student ID. 
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
	    System.out.println("checking s4.B193306.Frequencer");
	    myObject = new s4.B193306.Frequencer();
	    myObject.setSpace("Hi Ho Hi Ho".getBytes());
	    myObject.setTarget("H".getBytes());
	    freq = myObject.frequency();
	    System.out.print("\"H\" in \"Hi Ho Hi Ho\" appears "+freq+" times. ");
	    if(4 == freq) { System.out.println("OK"); } else {System.out.println("WRONG"); }

		/* 追加したテストケース1 */
		myObject.setSpace("".getBytes());
	    myObject.setTarget("B".getBytes());
	    freq = myObject.frequency();
	    System.out.print("When length of Space is 0, result should be 0. actual:"+freq+" ");
	    if(0 == freq) { System.out.println("OK"); } else {System.out.println("WRONG"); }

		/* 追加したテストケース2 */
		myObject.setSpace("".getBytes());
	    myObject.setTarget("".getBytes());
	    freq = myObject.frequency();
	    System.out.print("When length of Target and Space is -1, result should be -1. actual:"+freq+" ");
	    if(-1 == freq) { System.out.println("OK"); } else {System.out.println("WRONG"); }

		/* 追加したテストケース3 */
		myObject.setSpace("Bike Ball Boss Baby".getBytes());
	    myObject.setTarget("".getBytes());
	    freq = myObject.frequency();
	    System.out.print("When length of Target is 0, result should be -1. actual:"+freq+" ");
	    if(-1 == freq) { System.out.println("OK"); } else {System.out.println("WRONG"); }

		/* 追加したテストケース4 */
		myObject = new s4.B193306.Frequencer();
		freq = myObject.frequency();
	    System.out.print("Space and Target isn't set. Result should be -1. actual:"+freq+" ");
	    if(-1 == freq) { System.out.println("OK"); } else {System.out.println("WRONG"); }

		/* 追加したテストケース5 */
		myObject = new s4.B193306.Frequencer();
		myObject.setSpace("Bike Ball Boss Baby".getBytes());
		freq = myObject.frequency();
	    System.out.print("Target isn't set. Result should be -1. actual:"+freq+" ");
	    if(-1 == freq) { System.out.println("OK"); } else {System.out.println("WRONG"); }

		/* 追加したテストケース6 */
		myObject = new s4.B193306.Frequencer();
		myObject.setTarget("B".getBytes());
		freq = myObject.frequency();
	    System.out.print("Space isn't set. Result should be 0. actual:"+freq+" ");
	    if(0 == freq) { System.out.println("OK"); } else {System.out.println("WRONG"); }

		/* 追加したテストケース7 */
		myObject = new s4.B193306.Frequencer();
		myObject.setSpace("".getBytes());
		freq = myObject.frequency();
	    System.out.print("Target isn't set and length of Space is 0. Result should be -1. actual:"+freq+" ");
	    if(-1 == freq) { System.out.println("OK"); } else {System.out.println("WRONG"); }

		/* 追加したテストケース8 */
		myObject = new s4.B193306.Frequencer();
		myObject.setTarget("".getBytes());
		freq = myObject.frequency();
	    System.out.print("Space isn't set and length of Target is 0. Result should be -1. actual:"+freq+" ");
	    if(-1 == freq) { System.out.println("OK"); } else {System.out.println("WRONG"); }

		/* ターゲットが存在しなかったり、長さが0であるときは-1を返すようにするべきである。*/

	}
	catch(Exception e) {
	    System.out.println("Exception occurred: STOP");
	}

	try {
	    InformationEstimatorInterface myObject;
	    double value;
	    System.out.println("checking s4.B193306.InformationEstimator");
	    myObject = new s4.B193306.InformationEstimator();
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
		myObject.setTarget("001".getBytes());
	    value = myObject.estimation();
	    System.out.println(">001 "+value);
	}
	catch(Exception e) {
	    System.out.println("Exception occurred: STOP");
	}

    }
}	    
	    
