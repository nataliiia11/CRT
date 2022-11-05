package com.company;
import org.w3c.dom.css.CSSStyleDeclaration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {
     /*   BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        System.out.println("Please enter first really big number");
        String inputString1 = reader.readLine();
        BigInteger num1 = new BigInteger(inputString1);
        System.out.println("Please enter second really big number");
        String inputString2 = reader.readLine();
        BigInteger num2 = new BigInteger(inputString2);
        System.out.println("Please enter first prime big number");
        String inputString3 = reader.readLine();
        int num3 = Integer.valueOf(inputString3);
        System.out.println("Please enter second prime big number");
        String inputString4 = reader.readLine();
        int num4 = Integer.valueOf(inputString4) ;

        System.out.println(computeY(num1, num2, num3, num4));
        System.out.println(test(num1, num2, num3, num4));

      */
        System.out.println(multiplicativeInverse(10, 17));
    }
    public static int euclAlg(int q, int p) {
        int inv = 0;
        if(q < p) {
            inv = p;
            p = q;
            q = inv;
        }
        int res;
        if(p == 0) {
            res = q;
        } else {
            res = euclAlg(p, q % p);
        }
        return res;
    }




    //Determine a solution z for qz ≡ 1 mod p

    public static int multiplicativeInverse(int q, int p) {
        int res = 0;
        int inv;
        if(q < p ) {
            inv = p;
            p = q;
            q = inv;
        }
        /*
        * Q  A  B  R  T1  T2  T
        * 5  11 2  1   0  1  -5
        * 2  2  1  0   1  -5  11
        * 0  1  0  x   -5  11  x
        * */
        int Q = q / p;
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
            }
            r = q % p;
            Q = q / p;
        }
        return res;
    }
//  Compute y ≡ (a - b)z mod p
        public static BigInteger computeY(BigInteger X, BigInteger Y, int p, int q) {
        BigInteger res ;
        //(a,b) := x mod p, x mod q
            // a := x mod p
        BigInteger ap = X.remainder(BigInteger.valueOf(p));
        //b:= x mod q
        BigInteger aq = X.remainder(BigInteger.valueOf(q));
        //(c,d) := y mod p, y mod q
            //  c:= y mod p
        BigInteger bp = Y.remainder(BigInteger.valueOf(p));
        // d := y mod p
        BigInteger bq = Y.remainder(BigInteger.valueOf(q));
        // e,f : = (ac) mod p, (bd) mod q

            //(ac) mod p,
        BigInteger aaa = (ap.multiply(bp)).remainder(BigInteger.valueOf(p));
        //(bd) mod q
        BigInteger bbb = (aq.multiply(bq)).remainder(BigInteger.valueOf(q));
        //qz ≡ 1 mod p
        BigInteger z = BigInteger.valueOf(multiplicativeInverse(p, q));
       // v ≡ (f-e) * z % q
        BigInteger V = (bbb.subtract(aaa)).multiply(z).remainder(BigInteger.valueOf(q));
        //Determine x = yq + b
        res = (V.multiply(BigInteger.valueOf(q))).add(bbb);
        return res;
        }
        //Compute y ≡ (a - b)z mod p
    }
