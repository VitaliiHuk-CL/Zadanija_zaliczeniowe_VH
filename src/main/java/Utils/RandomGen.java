package Utils;

public class RandomGen {

    double a = Math.random();


    String myEmailGen = ("vitalii" + a + "@hotmail.com");
    String myPassWordGen = ("pass"+ a);

    public String getMyEmailGen() {
        return myEmailGen;
    }
    public String getMyPassWordGen() {
        return myPassWordGen;
    }

//    public void setMyEmailGen(String myEmailGen) {
//        this.myEmailGen = myEmailGen;
//    }
//
//    public void setMyPassWordGen(String myPassWordGen) {
//        this.myPassWordGen = myPassWordGen;
//    }



}
