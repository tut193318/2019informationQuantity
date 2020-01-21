package s4.B193313; // Please modify to s4.Bnnnnnn, where nnnnnn is your student ID. 
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
	try{
		FrequencerInterface  myObject1;
	    int freq;
	    System.out.println("checking s4.B193313.Frequencer");
		myObject1 = new s4.B193313.Frequencer();
		//Hを探し、4つであるか
	    myObject1.setSpace("Hi Ho Hi Ho".getBytes());
		myObject1.setTarget("H".getBytes());		
	    freq = myObject1.frequency();
	    System.out.print("1:\"H\" in \"Hi Ho Hi Ho\" appears "+freq+" times. ");
		if(4 == freq) { 
			System.out.println("OK"); 
		} else {
			System.out.println("WRONG"); 
		}
	}	
	catch(Exception e) {
		System.out.println("1:Exception occurred : STOP");
	}

	try{
		//iを探し、2つであるか
		FrequencerInterface  myObject2;
		int freq;
		myObject2 = new s4.B193313.Frequencer();
		myObject2.setSpace("Hi Ho Hi Ho".getBytes());
	    myObject2.setTarget("i".getBytes());
	    freq = myObject2.frequency();
	    System.out.print("2:\"i\" in \"Hi Ho Hi Ho\" appears "+freq+" times. ");
		if(2 == freq) { 
			System.out.println("OK"); 
		} else {
			System.out.println("WRONG"); 
		}
	}
	catch(Exception e) {
		System.out.println("2:Exception occurred : STOP");
	}

	try{
		//oを探し、2つであるか
		FrequencerInterface  myObject3;
		int freq;
		myObject3 = new s4.B193313.Frequencer();
		myObject3.setSpace("Hi Ho Hi Ho".getBytes());
	    myObject3.setTarget("o".getBytes());
	    freq = myObject3.frequency();
	    System.out.print("3:\"o\" in \"Hi Ho Hi Ho\" appears "+freq+" times. ");
		if(2 == freq) { 
			System.out.println("OK"); 
		} else {
			System.out.println("WRONG"); 
		}
	}
	catch(Exception e) {
		System.out.println("3:Exception occurred : STOP");
	}
	try{
		// を探し、3つであるか
		FrequencerInterface  myObject4;
		int freq;
		myObject4 = new s4.B193313.Frequencer();
		myObject4.setSpace("Hi Ho Hi Ho".getBytes());
	    myObject4.setTarget("".getBytes());
	    freq = myObject4.frequency();
	    System.out.print("4:\"(null)\" in \"Hi Ho Hi Ho\" appears "+freq+" times. ");
		if(-1 == freq) { 
			System.out.println("OK"); 
		} else {
			System.out.println("WRONG"); 
		}
	}
	catch(Exception e) {
		System.out.println("4:Exception occurred : STOP");
	}
	try{
		//	無からHを探す
		FrequencerInterface  myObject5;
		int freq;
		myObject5 = new s4.B193313.Frequencer();
		myObject5.setSpace("".getBytes());
		myObject5.setTarget("H".getBytes());
		freq = myObject5.frequency();
		System.out.print("5:\"H\" in \"(null)\" appears "+freq+" times. ");
		if(0 == freq) { 
			System.out.println("OK"); 
		} else {
			System.out.println("WRONG"); 
		}
	}
	catch(Exception e) {
		System.out.println("5:Exception occurred : STOP");
	}
	try{
		//	無から無を探す
		FrequencerInterface  myObject6;
		int freq;
		myObject6 = new s4.B193313.Frequencer();
		myObject6.setSpace("".getBytes());
		myObject6.setTarget("".getBytes());
		freq = myObject6.frequency();
		System.out.print("6:\"(null)\" in \"(null)\" appears "+freq+" times. ");
		if(0 == freq) { 
			System.out.println("OK"); 
		} else {
			System.out.println("WRONG"); 
		}
	}
	catch(Exception e) {
	    System.out.println("6:Exception occurred : STOP");
	}
	try{
		//そもそもSPACEをセットしない :7
		FrequencerInterface  myObject7;
	    int freq;
		myObject7 = new s4.B193313.Frequencer();
	    //NO!! setSpace("Hi Ho Hi Ho".getBytes());
		myObject7.setTarget("H".getBytes());		
	    freq = myObject7.frequency();
	    System.out.print("7:\"H\" in \"Hi Ho Hi Ho\" appears "+freq+" times. ");
		if(4 == freq) { 
			System.out.println("OK"); 
		} else {
			System.out.println("WRONG"); 
		}
	}	
	catch(Exception e) {
		System.out.println("7:Exception occurred : STOP");
	}
	
	try{
		//そもそもTARGETをセットしない :8
		FrequencerInterface  myObject8;
	    int freq;
		myObject8 = new s4.B193313.Frequencer();
	    myObject8.setSpace("Hi Ho Hi Ho".getBytes());
		//NO!!! setTarget("H".getBytes());		
	    freq = myObject8.frequency();
	    System.out.print("8:\"H\" in \"Hi Ho Hi Ho\" appears "+freq+" times. ");
		if(4 == freq) { 
			System.out.println("OK"); 
		} else {
			System.out.println("WRONG"); 
		}
	}	
	catch(Exception e) {
		System.out.println("8:Exception occurred : STOP");
	}

	try {
	    InformationEstimatorInterface myObject;
	    double value;
	    System.out.println("checking s4.B193313.InformationEstimator");
	    myObject = new s4.B193313.InformationEstimator();
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
	}
	catch(Exception e) {
	    System.out.println("Exception occurred: STOP");
	}

    }
}	    
	    
