package s4.B193301; // Please modify to s4.Bnnnnnn, where nnnnnn is your student ID. 
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
	
	FrequencerInterface  myObject,testA,testB,testC,testD,testE;
	int freq;
	System.out.println("checking s4.B193301.Frequencer");
	//myObject = new s4.B193301.Frequencer();
	//myObject.setSpace("A".getBytes());
	//myObject.setTarget("AAAAAAA".getBytes());
	//freq = myObject.frequency();
	try {
	    //TARGET ga set sarete inai baai
	    testA=new s4.B193301.Frequencer();
	    testA.setSpace("A".getBytes());
	    //testA.setTarget("".getBytes());
	    freq=testA.frequency();
	    System.out.println("testA TARGET is not set :"+freq);
	} catch(Exception e) {
	    System.out.println("Exception occurred: STOP");
	}
	
	try{
	    //TARGET no nagasa ga 0 no baai
	    testB=new s4.B193301.Frequencer();
	    testB.setSpace("A".getBytes());
	    testB.setTarget(null);
	    freq=testB.frequency();
	    System.out.println("testB TARGET's length is zero:"+freq);
	} catch(Exception e) {
	    System.out.println("Exception occurred: STOP");
	}

	try{
	    //SPACE ga set sarete inai baai
	    testC=new s4.B193301.Frequencer();
	    //testC.setSpace("".getBytes());
	    testC.setTarget("A".getBytes());
	    freq=testC.frequency();
	    System.out.println("testC SPACE is not set:"+freq);
	} catch(Exception e) {
	    System.out.println("Exception occurred: STOP");
	}

	
	    //if(4 == freq) { System.out.println("OK"); } else {System.out.println("WRONG"); }

	try{
	    //SPACE no nagasa ga 0
	    testD=new s4.B193301.Frequencer();
	    testD.setSpace(null);
	    testD.setTarget("A".getBytes());
	    freq=testD.frequency();
	    System.out.println("testD SPACE's length is zero:"+freq);
	} catch(Exception e) {
	    System.out.println("Exception occurred: STOP");
	}

	try{
	    //test case
	    testE=new s4.B193301.Frequencer();
	    testE.setSpace("AAAAAA".getBytes());
	    testE.setTarget("AA".getBytes());
	    freq=testE.frequency();
	    System.out.println("testE :"+freq);
	} catch(Exception e) {
	    System.out.println("Exception occurred: STOP");
	}
	/*
	try {
	    InformationEstimatorInterface myObject;
	    double value;
	    System.out.println("checking s4.B193301.InformationEstimator");
	    myObject = new s4.B193301.InformationEstimator();
	    myObject.setSpace("0".getBytes());
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
	*/
    }
}	    
	    
	    
