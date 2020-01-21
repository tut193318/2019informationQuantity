package s4.B193317; // Please modify to s4.Bnnnnnn, where nnnnnn is your student ID. 
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

	FrequencerInterface  myObject;
	int freq;
	/*Week1:FrequencerInterface*/
	System.out.println("checking s4.B193317.Frequencer");
	
	//Week1:test Case1:Target dose not set.
	//B:Exception occurred: STOP
	//W:freq: -1 times.
	try {
	    myObject = new s4.B193317.Frequencer();

	    myObject.setSpace("ABCD".getBytes());
	    freq = myObject.frequency(); //expected value:-1
	    System.out.println("freq: "+freq+" times.");
	    	}
	catch(Exception e) {
	    System.out.println("Exception occurred: STOP");
	}
	    
	//Week1:test Case2:Target length is zero.
	//B:freq: 4 times.
	//W:freq: -1 times.
	try{
	    myObject = new s4.B193317.Frequencer();
	    myObject.setSpace("ABCD".getBytes());
	    myObject.setTarget("".getBytes());
	    freq = myObject.frequency();//expected value:-1
	    System.out.println("freq: "+freq+" times.");
	}
	catch(Exception e) {
	    System.out.println("Exception occurred: STOP");
	}

	//Week1:test Case3:SPACE is not set
	//B:freq: 0 times.
	//W:freq: 0 times.
	try{	    
	  myObject = new s4.B193317.Frequencer();
	  myObject.setSpace("ABCD".getBytes());
	  myObject.setTarget("Z".getBytes());
	  freq = myObject.frequency();//expected value:0
	  System.out.println("freq: "+freq+" times.");
	}
	catch(Exception e) {
	    System.out.println("Exception occurred: STOP");
	}

	 //Week1:test Case4:SPACE's length is zero
	//B:freq: 0 times.
	//W:freq: 0 times.
	try{
	    myObject = new s4.B193317.Frequencer();
	    myObject.setSpace("ABCD".getBytes());
	    myObject.setTarget("Z".getBytes());
	    freq = myObject.frequency();//expected value:0
	    System.out.println("freq: "+freq+" times.");
	}
	catch(Exception e) {
	    System.out.println("Exception occurred: STOP");
	}

	 //Week1:test Case5: the frequency of TAGET in SPACE
	//B:freq: 4 times.
	//W:freq: 4 times.
	try{
	   myObject = new s4.B193317.Frequencer();
	    myObject.setSpace("AAAA".getBytes());
	    myObject.setTarget("A".getBytes());
	    freq = myObject.frequency();//expected value:4
	    System.out.println("freq: "+freq+" times.");
	}
	catch(Exception e) {
	    System.out.println("Exception occurred: STOP");
	}

	//Week1:test Case6:either target[] or space[] is modified after setTaget, or setSpace
	//B:Exception occurred: STOP
	//W:freq: -1 times.
	try{
	   myObject = new s4.B193317.Frequencer();
	    //myObject.myTarget = "".getBytes();// Cant compile
	    freq = myObject.frequency();//expected value:undefind
	    System.out.println("freq: "+freq+" times.");
	}
	catch(Exception e) {
	    System.out.println("Exception occurred: STOP");
	}

	//Week1:test Case7:count of subBytes of TARGET in SPACE
	//B:freq: -1 times.
	//W:freq: 2 times.
	try{
	    myObject = new s4.B193317.Frequencer();
	    myObject.setSpace("AABC".getBytes());
	    myObject.setTarget("ABC".getBytes());
	    freq = myObject.subByteFrequency(0,1);//expected value:2
	    System.out.println("freq: "+freq+" times.");
	}
	catch(Exception e) {
	    System.out.println("Exception occurred: STOP");
	}

	//Week1:test Case8:the incorrect value of START or END
	//B:freq: -1 times.
	//W:freq: -1 times.
	try{
	     myObject = new s4.B193317.Frequencer();
	    //myObject.myTarget = "".getBytes();
	    freq = freq = myObject.subByteFrequency(0,4);//expected value:undefind
	    System.out.println("freq: "+freq+" times.");
	}
	catch(Exception e) {
	    System.out.println("Exception occurred: STOP");
	}

	//Week1:test Case9:target[] or space[] is modified after setTaget, or setSpace,
	//B:freq: -1 times.
	//W:freq: -1 times.
	try{
	     myObject = new s4.B193317.Frequencer();
	    //myObject.myTarget = "".getBytes();
	    freq = myObject.frequency();//expected value:undefind
	    System.out.println("freq: "+freq+" times.");
	    }
	catch(Exception e) {
	    System.out.println("Exception occurred: STOP");
	}

	//Case10：Target.length>Space.lengthの場合
	//B:freq: -1 times.
	//W:"ABC" in "A" appears -1 times. 
	try{
	     myObject = new s4.B193317.Frequencer();
	  
	    myObject.setSpace("A".getBytes());
	    myObject.setTarget("ABC".getBytes());
	    freq = myObject.frequency();
	    System.out.println("\"ABC\" in \"A\" appears "+freq+" times. ");
	    if(4 == freq) { System.out.println("OK"); } else {System.out.println("WRONG"); }
	    

	}
	catch(Exception e) {
	    System.out.println("Exception occurred: STOP");
	}
	

	/*
checking s4.B193317.Frequencer
Exception occurred: STOP
freq: 4 times.
freq: 0 times.
freq: 0 times.
freq: 4 times.
Exception occurred: STOP
freq: -1 times.
freq: -1 times.
Exception occurred: STOP
Exception occurred: STOP
	 */

	/*
	try {
	    InformationEstimatorInterface myObject2;
	    double value;
	    System.out.println("checking s4.B193317.InformationEstimator");
	    myObject = new s4.B193317.InformationEstimator();
	    myObject.setSpace("3210".getBytes());
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
	    //課題による追記：Target.length>Space.lengthの場合
	    myObject.setTarget("01234".getBytes());
	    value = myObject.estimation();
	    System.out.println(">01234 "+value);
	}
	catch(Exception e) {
	    System.out.println("Exception occurred: STOP");
	}
	*/

    }
}	    
	    
