package s4.B171848; // Please modify to s4.Bnnnnnn, where nnnnnn is your student ID. 
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

	/*Frequencyのブラックボックステスト*/
	/*
	
	
	*/
	System.out.println("Frequencyのブラックボックステスト");
	/*Targetのlengthが0のとき*/
	try {
	    System.out.println();
	    FrequencerInterface  myObject;
	    int freq;
	    System.out.println("Targetのlengthが0のとき");
	    System.out.println("-1が返ってこればOK,そうでなければWRONGまたはSTOP");
	    System.out.println("checking s4.B171848.Frequencer");
	    myObject = new s4.B171848.Frequencer();
	    myObject.setSpace("Hi Ho Hi Ho".getBytes());
	    myObject.setTarget("".getBytes());//Targetのlength == 0
	    freq = myObject.frequency();
	    System.out.print("\"H\" in \"Hi Ho Hi Ho\" appears "+freq+" times. ");
	    if(-1 == freq) { System.out.println("OK"); } else {System.out.println("WRONG"); }
	}
	catch(Exception e) {
	    System.out.println("Exception occurred: STOP");
	}
	/*setTargetをしていないとき*/
	try {
	    System.out.println();
	    FrequencerInterface  myObject;
	    int freq;
	    System.out.println("setTargetをしていないとき");
	    System.out.println("-1が返ってこればOK,そうでなければWRONGまたはSTOP");
	    System.out.println("checking s4.B171848.Frequencer");
	    myObject = new s4.B171848.Frequencer();
	    myObject.setSpace("Hi Ho Hi Ho".getBytes());
	    //myObject.setTarget("H".getBytes());
	    freq = myObject.frequency();
	    System.out.print("\"H\" in \"Hi Ho Hi Ho\" appears "+freq+" times. ");
	    if(-1 == freq) { System.out.println("OK"); } else {System.out.println("WRONG"); }
	}
	catch(Exception e) {
	    System.out.println("Exception occurred: STOP");
	}
	/*setSpaceのlengthが0のとき*/
	try {
	    System.out.println();
	    FrequencerInterface  myObject;
	    int freq;
	    System.out.println("setSpaceのlengthが0のとき");
	    System.out.println("0が返ってこればOK,そうでなければWRONGまたはSTOP");
	    System.out.println("checking s4.B171848.Frequencer");
	    myObject = new s4.B171848.Frequencer();
	    myObject.setSpace("".getBytes());//Spaceのlength == 0
	    myObject.setTarget("H".getBytes());
	    freq = myObject.frequency();
	    System.out.print("\"H\" in \"Hi Ho Hi Ho\" appears "+freq+" times. ");
	    if(0 == freq) { System.out.println("OK"); } else {System.out.println("WRONG"); }
	}
	catch(Exception e) {
	    System.out.println("Exception occurred: STOP");
	}
	/*setSpaceをしていないとき*/
	try {
	    System.out.println();
	    FrequencerInterface  myObject;
	    int freq;
	    System.out.println("setSpaceをしていないとき");
	    System.out.println("0が返ってこればOK,そうでなければWRONGまたはSTOP");
	    System.out.println("checking s4.B171848.Frequencer");
	    myObject = new s4.B171848.Frequencer();
	    //myObject.setSpace("Hi Ho Hi Ho".getBytes());
	    myObject.setTarget("H".getBytes());
	    freq = myObject.frequency();
	    System.out.print("\"H\" in \"Hi Ho Hi Ho\" appears "+freq+" times. ");
	    if(0 == freq) { System.out.println("OK"); } else {System.out.println("WRONG"); }
	}
	catch(Exception e) {
	    System.out.println("Exception occurred: STOP");
	}
	/*SpaceとTargetを正しくセットしているとき*/
	try {
	    System.out.println();
	    FrequencerInterface  myObject;
	    int freq;
	    System.out.println("SpaceとTargetを両方しているとき");
	    System.out.println("checking s4.B171848.Frequencer");
	    myObject = new s4.B171848.Frequencer();
	    myObject.setSpace("Hi Ho Hi Ho".getBytes());
	    myObject.setTarget("H".getBytes());
	    freq = myObject.frequency();
	    System.out.print("\"H\" in \"Hi Ho Hi Ho\" appears "+freq+" times. ");
	    if(4 == freq) { System.out.println("OK"); } else {System.out.println("WRONG"); }
	}
	catch(Exception e) {
	    System.out.println("Exception occurred: STOP");
	}
	/*subByteFrequencyの動作テスト*/
	try {
	    System.out.println();
	    System.out.println("subBytesFrequencyの動作テスト");
	    System.out.println("4が返ってこればOK,そうでなければWRONGまたはSTOP");
	    FrequencerInterface  myObject;
	    int freq;
	    int start,end; 
	    int subByteFreq;
	    System.out.println("start == 0, end == 1");
	    System.out.println("checking s4.B171848.Frequencer");
	    myObject = new s4.B171848.Frequencer();
	    myObject.setSpace("Hi Ho Hi Ho".getBytes());
	    myObject.setTarget("Hi".getBytes());
	    freq = myObject.frequency();
	    start = 0;
	    end = 1;
	    subByteFreq = myObject.subByteFrequency(start, end);

	    System.out.print("\"i\" in \"Hi Ho Hi Ho\" :appears "+subByteFreq+" times. ");
	    if(4 == subByteFreq) { System.out.println("OK"); } else {System.out.println("WRONG"); }
	}
	catch(Exception e) {
	    System.out.println("Exception occurred: STOP");
	}
	System.out.println("-------------------------------------------------------------------------");
	/*Frequencyのホワイトボックステスト*/
	/*
	
	*/
	System.out.println("Frequencyのホワイトボックステスト");


	

	try {
	    System.out.println("subByteFrequencyが正しく実装されているかのテスト");
	    FrequencerInterface  myObject;
	    int freq;
	    int start,end; 
	    int subByteFreq;
	    System.out.println("checking s4.B171848.Frequencer");
	    myObject = new s4.B171848.Frequencer();
	    myObject.setSpace("Hi Ho Hi Ho".getBytes());
	    myObject.setTarget("Hi".getBytes());
	    freq = myObject.frequency();
	    start = 0;
	    end = 1;
	    subByteFreq = myObject.subByteFrequency(start, end);
	    System.out.print("\"H\" in \"Hi Ho Hi Ho\" appears "+freq+" times. ");
	    if(4 == freq) { System.out.println("OK"); } else {System.out.println("WRONG"); }
	}
	catch(NullPointerException e) {
	    System.out.println("NullPointerException occurred: STOP");
	}





	try {
	    System.out.println();
	    System.out.println("文字列の探索においてArrayIndexOutOfBoundsExceptionが発生するかのテスト");
	    FrequencerInterface  myObject;
	    int freq;
	    System.out.println("checking s4.B171848.Frequencer");
	    myObject = new s4.B171848.Frequencer();
	    myObject.setSpace("HHHHHHHHHHH".getBytes());
	    myObject.setTarget("HHH".getBytes());
	    freq = myObject.frequency();
	    System.out.print("\"H\" in \"Hi Ho Hi Ho\" appears "+freq+" times. ");
	    if(9 == freq) { System.out.println("OK"); } else {System.out.println("WRONG"); }
	}
	catch(ArrayIndexOutOfBoundsException e) {
	    System.out.println("ArrayIndexOutOfBoundsException occurred: STOP");
	}




	try {
	    System.out.println();
	    System.out.println("Targetのlength==0のとき、正しい値が返ってこない可能性のテスト");
	    FrequencerInterface  myObject;
	    int freq;
	    System.out.println("checking s4.B171848.Frequencer");
	    myObject = new s4.B171848.Frequencer();
	    myObject.setSpace("Hi Ho Hi Ho".getBytes());
	    myObject.setTarget("".getBytes());
	    freq = myObject.frequency();
	    System.out.print("\"H\" in \"Hi Ho Hi Ho\" appears "+freq+" times. ");
	    if(0 == freq) { System.out.println("OK"); } else {System.out.println("WRONG"); }
	}
	catch(Exception e) {
	    System.out.println("Exception occurred: STOP");
	}




	try {
	    System.out.println();
	    System.out.println("setSpaceをしていないときにNullPointerExceptionが発生するかのテスト");
	    FrequencerInterface  myObject;
	    int freq;
	    System.out.println("checking s4.B171848.Frequencer");
	    myObject = new s4.B171848.Frequencer();
	    //myObject.setSpace("Hi Ho Hi Ho".getBytes());
	    myObject.setTarget("H".getBytes());
	    freq = myObject.frequency();
	    System.out.print("\"H\" in \"Hi Ho Hi Ho\" appears "+freq+" times. ");
	    if(4 == freq) { System.out.println("OK"); } else {System.out.println("WRONG"); }
	}
	catch(NullPointerException e) {
	    System.out.println("NullPointerException occurred: STOP");
	}




	try {
	    System.out.println();
	    System.out.println("setTargetをしていないときにNullPointerExceptionが発生するかのテスト");
	    FrequencerInterface  myObject;
	    int freq;
	    System.out.println("checking s4.B171848.Frequencer");
	    myObject = new s4.B171848.Frequencer();
	    myObject.setSpace("Hi Ho Hi Ho".getBytes());
	    //myObject.setTarget("H".getBytes());
	    freq = myObject.frequency();
	    System.out.print("\"H\" in \"Hi Ho Hi Ho\" appears "+freq+" times. ");
	    if(4 == freq) { System.out.println("OK"); } else {System.out.println("WRONG"); }
	}
	catch(NullPointerException e) {
	    System.out.println("NullPointerException occurred: STOP");
	}

	System.out.println("-------------------------------------------------------------------------");
	/*InformationEstimatorのテスト*/
	/*
	
	
	*/
	System.out.println("InformationEstimatorのブラックボックステスト");


	/*setTargetをしていないときに0.0が返ってくるかのテスト*/
	try {
	    System.out.println();
	    InformationEstimatorInterface myObject;
	    double value;
	    System.out.println("setTargetをしていないときに0.0が返ってくるかのテスト");
	    System.out.println("checking s4.B171848.InformationEstimator");
	    myObject = new s4.B171848.InformationEstimator();
	    myObject.setSpace("3210321001230123".getBytes());
	    //myObject.setTarget("0".getBytes());
	    value = myObject.estimation();
	    System.out.println("> "+value);
	    if(value == 0.0){System.out.println("OK");}else{System.out.println("WRONG");} 
	}
	catch(NullPointerException e) {
	    System.out.println("NullPointerException occurred: STOP");
	}


	/*Targetのlengthが0のときに0.0が返ってくるかのテスト*/
	try {
	    System.out.println();
	    InformationEstimatorInterface myObject;
	    double value;
	    System.out.println("Targetのlengthが0のときに0.0が返ってくるかのテスト");
	    System.out.println("checking s4.B171848.InformationEstimator");
	    myObject = new s4.B171848.InformationEstimator();
	    myObject.setSpace("3210321001230123".getBytes());
	    myObject.setTarget("".getBytes());
	    value = myObject.estimation();
	    System.out.println("> "+value);
	    if(value == 0.0){System.out.println("OK");}else{System.out.println("WRONG");} 
	}
	catch(Exception e) {
	    System.out.println("Exception occurred: STOP");
	}


	/*Spaceが大きすぎるときにDouble.MAX_VALUEが返ってくるかのテスト*/
	try {
	    System.out.println();
	    InformationEstimatorInterface myObject;
	    double value;
	    System.out.println("Spaceが大きすぎるときにDouble.MAX_VALUEが返ってくるかのテスト");
	    System.out.println("checking s4.B171848.InformationEstimator");
	    myObject = new s4.B171848.InformationEstimator();
	    byte[] space = new byte[1073741820];
	    for(int i = 0; i < 1073741820; i++){
		    if(i % 2 == 0) space[i] = 0;
		    else space[i] = 1;
	    }
	    myObject.setSpace(space);
	    myObject.setTarget("0".getBytes());
	    value = myObject.estimation();
	    System.out.println(">0 "+value);
	    if(value == Double.MAX_VALUE){System.out.println("OK");}else{System.out.println("WRONG");}
	}
	catch(Exception e) {
	    System.out.println("Exception occurred: STOP");
	}


	/*setSpaceをしていないときにDouble.MAX_VALUEが返ってくるかのテスト*/
	try {
	    System.out.println();
	    InformationEstimatorInterface myObject;
	    double value;
	    System.out.println("setSpaceをしていないときにDouble.MAX_VALUEが返ってくるかのテスト");
	    System.out.println("checking s4.B171848.InformationEstimator");
	    myObject = new s4.B171848.InformationEstimator();
	    //myObject.setSpace("3210321001230123".getBytes());
	    myObject.setTarget("0".getBytes());
	    value = myObject.estimation();
	    System.out.println(">0 "+value);
	    if(value == Double.MAX_VALUE){System.out.println("OK");}else{System.out.println("WRONG");}
	}
	catch(NullPointerException e) {
	    System.out.println("NullPointerException occurred: STOP");
	}
	/*SpaceもTargetも正しくセットされているとき*/
	try {
	    System.out.println();
	    InformationEstimatorInterface myObject;
	    double value;
	    System.out.println("SpaceもTargetも正しくセットされているとき");
	    System.out.println("checking s4.B171848.InformationEstimator");
	    myObject = new s4.B171848.InformationEstimator();
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
	    
