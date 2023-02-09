package Lab4;

/**
 * @author Maldin0
 * @created 2/8/2023 - 3:58 PM
 * @project OOP-Lab
 */
public class Fraction {
    public int topN, btmN;

    public String toFraction() {
        return String.valueOf(topN) + '/' + btmN;
    }

    public String toFloat() {
        double res = topN;
        return String.valueOf(res / btmN);
    }

    public void addFraction(Fraction frac) {
        if (this.btmN == frac.btmN) {
            this.topN += frac.topN;
        } else {
            this.topN = (this.topN * frac.btmN) + (frac.topN * this.btmN);
            this.btmN *= frac.btmN;
        }
    }

    public boolean myEquals(Fraction frac) {
        return (this.topN * frac.btmN) == (this.btmN * frac.topN);
    }

    public void LowestTermFrac() {
        int top = this.topN, btm = this.btmN, div = 1;
        for (int i = 1; i <= Math.max(top, btm); i++) {
            if ((top % i == 0) & (btm % i == 0)) {
                if (i > div) {
                    div = i;
                }
            }
        }
        this.topN /= div;
        this.btmN /= div;
    }
}

class Main2 {
    public static void main(String[] args) {
//        Fraction f1 = new Fraction();
//        f1.topN = 2;
//        f1.btmN = 5;
//        Fraction f2 = new Fraction();
//        f2.topN = 3;
//        f2.btmN = 7;
//        System.out.println("before "+f1.toFraction());
//        System.out.println("before "+f1.toFloat());
//        f1.addFraction(f2);
//        System.out.println("after "+f1.toFraction());
//        System.out.println("after "+f1.toFloat());

        Fraction f1 = new Fraction();
        f1.topN = 1;
        f1.btmN = 3;
        Fraction f2 = new Fraction();
        f2.topN = 4;
        f2.btmN = 16;
        Fraction f3 = new Fraction();
        f3.topN = 5;
        f3.btmN = 15;

        System.out.println(f1.toFloat());
        System.out.println(f2.toFloat());
        System.out.println(f3.toFloat());
        System.out.println("f1 is equal to f2 >> " + f1.myEquals(f2));
        System.out.println("f1 is equal to f3 >> " + f1.myEquals(f3));
        System.out.println("Before : " + f2.toFraction());
        f2.LowestTermFrac();
        System.out.println("After : " + f2.toFraction());
    }
}
