package s4.B193333; // Please modify to s4.Bnnnnnn, where nnnnnn is your student ID.
import java.lang.*;
import s4.specification.*;

/*
interface FrequencerInterface {     // This interface provides the design for frequency counter.
    void setTarget(byte[]  target); // set the data to search.
    void setSpace(byte[]  space);  // set the data to be searched target from.
    //検索対象のデータを設定します。
    int frequency(); //It return -1, when TARGET is not set or TARGET's length is zero
                    //TARGETが設定されていないか、TARGETの長さがゼロの場合、-1を返します

                    //Otherwise, it return 0, when SPACE is not set or Space's length is zero
                    //それ以外の場合、SPACEが設定されていないか、スペースの長さがゼロの場合、0を返します

                    //Otherwise, get the frequency of TAGET in SPACE
                    //それ以外の場合は、SPACEでTAGETの頻度を取得します
    int subByteFrequency(int start, int end);
    // get the frequency of subByte of taget, i.e target[start], taget[start+1], ... , target[end-1].
    //tagetのsubByteの頻度、つまりtarget [start]、taget [start + 1]、...、target [end-1]を取得します。

    // For the incorrect value of START or END, the behavior is undefined.
    // STARTまたはENDの誤った値の場合、動作は未定義です。
}
*/

/*
package s4.specification;
public interface InformationEstimatorInterface{
    void setTarget(byte target[]); // set the data for computing the information quantities
    //情報量を計算するためのデータを設定する
    void setSpace(byte space[]); // set data for sample space to computer probability
    //サンプル空間のデータをコンピューター確率に設定する
    double estimation(); // It returns 0.0 when the target is not set or Target's length is zero;
    //ターゲットが設定されていない場合、またはターゲットの長さがゼロの場合、0.0を返します。

// It returns Double.MAX_VALUE, when the true value is infinite, or space is not set.
//真の値が無限の場合、またはスペースが設定されていない場合、Double.MAX_VALUEを返します。

// The behavior is undefined, if the true value is finete but larger than Double.MAX_VALUE.
//真の値が細かいがDouble.MAX_VALUEより大きい場合、動作は未定義です。

// Note that this happens only when the space is unreasonably large. We will encounter other problem anyway.
// これは、スペースが不当に大きい場合にのみ発生することに注意してください。とにかく他の問題に遭遇します。

// Otherwise, estimation of information quantity,
//そうでなければ、情報量の推定、
}
*/


public class TestCase {
    public static void main(String[] args) {
	try {
	    FrequencerInterface  myObject;
      FrequencerInterface test,test1,test2,test3,;
	    int freq;
	    System.out.println("checking s4.B193333.Frequencer");
      test =new s4.B193333.Frequencer();
      test1=new s4.B193333.Frequencer();
      test2=new s4.B193333.Frequencer();
      test3=new s4.B193333.Frequencer();
	    myObject = new s4.B193333.Frequencer();
      //通常の実行
	    myObject.setSpace("Hi Ho Hi Ho".getBytes());//検索対象のデータ指定
	    myObject.setTarget("H".getBytes());//検索文字
	    freq = myObject.frequency();//頻出回数を代入
	    System.out.print("\"H\" in \"Hi Ho Hi Ho\" appears "+freq+" times. ");//表示
	    if(4 == freq) { System.out.println("OK"); } else {System.out.println("WRONG"); }
      freq =test.frequency();

      //ブラックボックステスト
      test.setSpace("ab ac ad cd".getBytes());
	    test.setTarget("a".getBytes());
      System.out.print("\"a\" in \"ab ac ad cd\" appers "+freq+" times. ");
	    if(3 == freq) { System.out.println("OK"); } else {System.out.println("WRONG"); }

      //ホワイトボックステスト
      //target length is zero
      test.setSpace("ab ac ad cd".getBytes());
	    test.setTarget("".getBytes());
      freq =test.frequency();
      System.out.print("\"(target length is zero)\" in \"ab ac ad cd\" appers "+freq+" times. ");
      if(-1 == freq) { System.out.println("OK"); } else {System.out.println("WRONG"); }

      //space length is zero
      test.setSpace("".getBytes());
	    test.setTarget("a".getBytes());
      freq =test.frequency();
      System.out.print("\"a\" in \"(space length is zero)\" appers "+freq+" times. ");
      if(0 == freq) { System.out.println("OK"); } else {System.out.println("WRONG"); }

      //space is undefined
      test2.setTarget("a".getBytes());
      freq =test2.frequency();
      System.out.print("\"a\" in \"(undefined)\" appers "+freq+" times. ");
      if(0 == freq) { System.out.println("OK"); } else {System.out.println("WRONG"); }

      //target is undefined
	    test1.setSpace("ab ac ad cd".getBytes());
      freq =test1.frequency();
      System.out.print("\"(undefined)\" in \"ab ac ad cd\" appers "+freq+" times. ");
      if(-1 == freq) { System.out.println("OK"); } else {System.out.println("WRONG"); }

      //target and space is undefined
      freq =test3.frequency();
      System.out.print("\"(undefined)\" in \"ab ac ad cd\" appers "+freq+" times. ");
      if(-1 == freq) { System.out.println("OK"); } else {System.out.println("WRONG"); }

      //target and space length is zero
      test.setSpace("".getBytes());
	    test.setTarget("".getBytes());
      freq =test.frequency();
      System.out.print("\"(targetLength is zero)\" in \"(spaceLength is zero)\" appers "+freq+" times. ");
      if(0 == freq) { System.out.println("OK"); } else {System.out.println("WRONG"); }

      //targetLength is zero and space is undefined
      test2.setTarget("".getBytes());
      freq =test2.frequency();
      System.out.print("\"(targetLength is zero)\" in \"(undefined)\" appers "+freq+" times. ");
      if(0 == freq) { System.out.println("OK"); } else {System.out.println("WRONG"); }

      //spaceLength is zero and target is undefined
      test1.setSpace("".getBytes());
      freq =test1.frequency();
      System.out.print("\"(undefined)\" in \"(spaceLength is zero)\" appers "+freq+" times. ");
      if(-1 == freq) { System.out.println("OK"); } else {System.out.println("WRONG"); }
	}
	catch(Exception e) {
	    System.out.println("Exception occurred: STOP");
	}

	try {
	    InformationEstimatorInterface myObject;
	    double value;
	    System.out.println("checking s4.B193333.InformationEstimator");
	    myObject = new s4.B193333.InformationEstimator();
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
