package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(computeY(3000, 500, 103, 101));
        int res = multiplicativeInverse(3, 2);
        System.out.println(test(3000, 500, 103, 101));

    }
    public static int euclAlg(int q, int p) {
        if(q < p) {
            q = p;
            p = q;
        }
        int res;
        if(p == 0) {
            res = q;
        } else {
            res = euclAlg(p, q % p);
        }
        return res;
    }


    public static int test(int a, int b, int p, int q) {
        int res = (a * b) % (p * q);
        return res;
    }
    //Determine a solution z for qz ≡ 1 mod p
    //
    public static int multiplicativeInverse(int q, int p) {
        int res = 0;
        if(q < p ) {
            q = p;
            p = q;
        }
        /*
        * Q  A  B  R  T1  T2  T
        * 5  11 2  1   0  1  -5
        * 2  2  1  0   1  -5  11
        * 0  1  0  x   -5  11  x
        * */
        int Q = (int) Math.floor(q / p);
        int r = q % p;
        int t1 = 0;
        int t2 = 1;
        int t;
        while (r >= 0) {
           t = t1 - t2 * Q;
           q  = p;
            p = r;
            t1 = t2;
            t2 = t;
            res = t1;
            //we need this condition to avoid  division by 0 but sti use the last iteration when rest = 0
            if(r == 0) {
                if(t1 < 0) {
                    res = t2 + t1;
                }
                break;
            };
            r = q % p;
            Q = q / p;
        }
        return res;
    }
//  Compute y ≡ (a - b)z mod p
        public static int computeY(int a, int b, int p, int q) {
        int res = 0;
        int ap = a % p;
        int aq = a % q;
        System.out.println("x = " + ap + ", " + aq);
        int bp = b % p;
        int bq = b % q;
        System.out.println("y = " + bp + ", " + bq);
        int aaa = (ap * bp)  % p;
        int bbb = (aq * bq) % q;
        System.out.println("xy = " + aaa + ", " + bbb);
        int z = multiplicativeInverse(p, q);
        System.out.println("z = " + z );
        int xy = (bbb-aaa) * z % q;
        //Determine x = yq + b
        res = q * xy + bbb;
        return res;
        }
    }
