package s4.B171811; // Please modify to s4.Bnnnnnn, where nnnnnn is your student ID.  import java.lang.*;
import s4.specification.*; 
/* interface FrequencerInterface {     // This interface provides the design for frequency counter.
   void setTarget(byte[]  target); // set the data to search.
   void setSpace(byte[]  space);  // set the data to be searched target from.
   int frequency(); //It return -1, when TARGET is not set or TARGET's length is zero
//Otherwise, it return 0, when SPACE is not set or Space's length is zero
//Otherwise, get the frequency of TAGET in SPACE
int subByteFrequency(int start, int end); // get the frequency of subByte of taget, i.e target[start], taget[start+1], ... , target[end-1].  // For the incorrect value of START or END, the behavior is undefined.  } */

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
  private void printException(Exception e) {
    System.out.println("Exception occurred: " + e.toString());
  }
  public static void main(String[] args) {
    var test = new TestCase();
    System.out.println("checking s4.B171811.Frequencer");
    try {
      FrequencerInterface  myObject;
      int freq;
      myObject = new s4.B171811.Frequencer();
      myObject.setSpace("Hi Ho Hi Ho".getBytes());
      myObject.setTarget("H".getBytes());
      freq = myObject.frequency();
      System.out.print("\"H\" in \"Hi Ho Hi Ho\" appears "+freq+" times. ");
      if(4 == freq) { System.out.println("OK"); } else {System.out.println("WRONG"); }
    }
    catch(Exception e) {
      System.out.println("Exception occurred: STOP");
      e.printStackTrace();
    }

    try {
      var myObject = new s4.B171811.Frequencer();
      System.out.println("[check] Do not set TARGET: frequency() expect to return -1");
      System.out.println(myObject.frequency());
    }
    catch(Exception e) {
      test.printException(e);
    }

    try {
      var myObject = new s4.B171811.Frequencer();
      System.out.println("[check] Set zero-length TARGET: frequency() expect to return -1");
      myObject.setTarget(new byte[0]);
      System.out.println(myObject.frequency());
    }
    catch(Exception e) {
      test.printException(e);
    }

    try {
      var myObject = new s4.B171811.Frequencer();
      System.out.println("[check] Set Target and do not set Space: frequency() expect to return 0");
      myObject.setTarget("test".getBytes());
      System.out.println(myObject.frequency());
    }
    catch(Exception e) {
      test.printException(e);
    }

    try {
      var myObject = new s4.B171811.Frequencer();
      System.out.println("[check] Set Target and set zero-length Space: frequency() expect to return 0");
      myObject.setTarget("test".getBytes());
      myObject.setSpace(new byte[0]);
      System.out.println(myObject.frequency());
    }
    catch(Exception e) {
      test.printException(e);
    }

    // PROBLEM: int subByteFrequency(int start, int length)
    // This method undefined.
    // 2nd input value's name "length" is wrong. Expect "end".
    try {
      System.out.println("[check] target is \"a\" and space is \"a0a0a0a\": subByteFrequency(2, 5) expect to return 2");
      var o = new s4.B171811.Frequencer();
      o.setTarget("a".getBytes());
      o.setSpace("a0a0a0a".getBytes());
      System.out.println(o.subByteFrequency(2, 5));
    }
    catch(Exception e) {
      test.printException(e);
    }

    // PROBLEM: int frequency()
    // When target length >= 2, it is possible that ArrayIndexOutOfBoundsException happens in "mySpace[start+i]"
    try {
      System.out.println("[check] target length >= 2 (target is \"12\", space is \"00001\": frequency() expect to return 0");
      var o = new s4.B171811.Frequencer();
      o.setTarget("12".getBytes());
      o.setSpace("00001".getBytes());
      System.out.println(o.frequency());
    }
    catch(Exception e) {
      test.printException(e);
    }

    // PROBLEM: int frequency()
    // When target length > space length, it throws ArrayIndexOutOfBoundsExceptions in mySpace[start+i].
    try {
      System.out.println("[check] target length > space length (target is \"a1234\", space is \"a12\"): frequency() expect to return 0");
      var o = new s4.B171811.Frequencer();
      o.setTarget("a1234".getBytes());
      o.setSpace("a12".getBytes());
      System.out.println(o.frequency());
    }
    catch(Exception e) {
      test.printException(e);
    }

    // MEMO: When Space is "AAAA" and Target is "AA", frequency() expect to return 3.

    System.out.println();

    System.out.println("checking s4.B171811.InformationEstimator");
    try {
      InformationEstimatorInterface myObject;
      double value;
      myObject = new s4.B171811.InformationEstimator();
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

    try {
      var o = new s4.B171811.InformationEstimator();
      System.out.println("[check] Do not set Target: expected 0.0");
      System.out.println(o.estimation());
    }
    catch(Exception e) {
      test.printException(e);
    }

    try {
      var o = new s4.B171811.InformationEstimator();
      System.out.println("[check] Set zero-length Target: expected 0.0");
      System.out.println(o.estimation());
    }
    catch(Exception e) {
      test.printException(e);
    }

    try {
      var o = new s4.B171811.InformationEstimator();
      System.out.println("[check] true value is infinite(Target = \"a\", Space = \"bbb\"): expected " + Double.MAX_VALUE);
      o.setTarget("a".getBytes());
      o.setSpace("bbb".getBytes());
      System.out.println(o.estimation());
    }
    catch(Exception e) {
      test.printException(e);
    }

    try {
      var o = new s4.B171811.InformationEstimator();
      System.out.println("[check] Set Target and set zero-length Space: expected " + Double.MAX_VALUE);
      o.setTarget("a".getBytes());
      o.setSpace(new byte[0]);
      System.out.println(o.estimation());
    }
    catch(Exception e) {
      test.printException(e);
    }
  }
}	    
