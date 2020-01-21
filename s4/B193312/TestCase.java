package s4.B193312; // Please modify to s4.Bnnnnnn, where nnnnnn is your student ID. 

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
    System.out.println("checking s4.B193312.Frequencer");

    try {
      FrequencerInterface myObject;
      int freq;
      myObject = new s4.B193312.Frequencer();
      myObject.setSpace("Hi Ho Hi Ho".getBytes());
      myObject.setTarget("H".getBytes());
      freq = myObject.frequency();
      System.out.print("\"H\" in \"Hi Ho Hi Ho\" appears " + freq + " times. ");
      if (4 == freq) {
        System.out.println("OK");
      } else {
        System.out.println("WRONG");
      }
    } catch (Exception e) {
      System.out.println("Exception occurred: STOP");
    }

    // add following testcase

    try {
      FrequencerInterface test1 = new s4.B193312.Frequencer();
      test1.setSpace("Hi Ho Hi Ho".getBytes());
      System.out.println("\nif target is not set...");
      // exception occured in the following statements!! (target is not set)
      int freq = test1.frequency();  
      System.out.print("freq = " + freq);
      if (freq == -1) System.out.println(" ...OK");
      else System.out.println(" ...WRONG");
    } catch (Exception e) {
      System.out.println("Exception occurred: STOP");
    }

    try {
      FrequencerInterface test2 = new s4.B193312.Frequencer();
      test2.setSpace("Hi Ho Hi Ho".getBytes());
      test2.setTarget("".getBytes());
      System.out.println("\nif length of target is zero...");
      int freq = test2.frequency();
      System.out.print("freq = " + freq); // freq == 11?
      if (freq == -1) System.out.println(" ...OK");
      else System.out.println(" ...WRONG");
    } catch (Exception e) {
      System.out.println("Exception occurred: STOP");
    }

    try {
      FrequencerInterface test3 = new s4.B193312.Frequencer();
      test3.setTarget("H".getBytes());
      System.out.println("\nif space is not set...");
      int freq = test3.frequency();
      System.out.print("freq = " + freq);
      if (freq == 0) System.out.println(" ...OK");
      else System.out.println(" ...WRONG");
    } catch (Exception e) {
      System.out.println("Exception occurred: STOP");
    }
    
    try {
      FrequencerInterface test4 = new s4.B193312.Frequencer();
      test4.setTarget("H".getBytes());
      test4.setSpace("".getBytes());
      System.out.println("\nif length of space is zero...");
      int freq = test4.frequency();
      System.out.print("freq = " + freq); // OK
      if (freq == 0) System.out.println(" ...OK"); 
      else System.out.println(" ...WRONG");
    } catch (Exception e) {
      System.out.println("Exception occurred: STOP");
    }

    System.out.print("\n\n");

    try {
      InformationEstimatorInterface myObject;
      double value;
      System.out.println("checking s4.B193312.InformationEstimator");
      myObject = new s4.B193312.InformationEstimator();
      myObject.setSpace("3210321001230123".getBytes());
      myObject.setTarget("0".getBytes());
      value = myObject.estimation();
      System.out.println(">0 " + value);
      myObject.setTarget("01".getBytes());
      value = myObject.estimation();
      System.out.println(">01 " + value);
      myObject.setTarget("0123".getBytes());
      value = myObject.estimation();
      System.out.println(">0123 " + value);
      myObject.setTarget("00".getBytes());
      value = myObject.estimation();
      System.out.println(">00 " + value);
    } catch (Exception e) {
      System.out.println("Exception occurred: STOP");
    }
     
    // add following testcase 
    
    try {
      InformationEstimatorInterface test1 = new s4.B193312.InformationEstimator();
      test1.setSpace("3210321001230123".getBytes());
      System.out.println("\nif target is not set...");
      double value = test1.estimation();
      System.out.print("value = " + value);
      if (value == 0.0) System.out.println(" ...OK");
      else System.out.println(" ...WRONG");
    } catch (Exception e) {
      System.out.println("Exception occurred: STOP");
    }

    try {
      InformationEstimatorInterface test2 = new s4.B193312.InformationEstimator();
      test2.setSpace("3210321001230123".getBytes());
      test2.setTarget("".getBytes());
      System.out.println("\nif length of target is zero...");
      double value = test2.estimation();
      System.out.print("value = " + value); // not 0
      if (value == 0.0) System.out.println(" ...OK");
      else System.out.println(" ...WRONG");
    } catch (Exception e) {
      System.out.println("Exception occurred: STOP");
    }

    try {
      InformationEstimatorInterface test3 = new s4.B193312.InformationEstimator();
      test3.setTarget("01".getBytes());
      System.out.println("\nif space is not set...");
      double value = test3.estimation();
      System.out.print("value = " + value);
      if (value == Double.MAX_VALUE) System.out.println(" ...OK");
      else System.out.println(" ...WRONG");
    } catch (Exception e) {
      System.out.println("Exception occurred: STOP");
    }

    try {
      InformationEstimatorInterface test4 = new s4.B193312.InformationEstimator();
      test4.setTarget("01".getBytes());
      test4.setSpace("".getBytes());
      System.out.println("\nif length of space is zero...");
      double value = test4.estimation();
      System.out.print("value = " + value);
      if (value == Double.MAX_VALUE) System.out.println(" ...OK");
      else System.out.println(" ...WRONG");
    } catch (Exception e) {
      System.out.println("Exception occurred: STOP");
    }

    System.out.println("all tests are done!");
  }
}
