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

