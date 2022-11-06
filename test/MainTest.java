import com.company.Main;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

public class MainTest {
        @Test
        public void testMultiplicativeInverse() {
                Assert.assertEquals(4, Main.multiplicativeInverse(3, 11));
                Assert.assertEquals(12, Main.multiplicativeInverse(10, 17));
                Assert.assertEquals(6, Main.multiplicativeInverse(2, 11));
                Assert.assertEquals(8, Main.multiplicativeInverse(5, 13));
                Assert.assertEquals(51, Main.multiplicativeInverse(103, 101));
                Assert.assertEquals(46, Main.multiplicativeInverse(11, 101));
                Assert.assertEquals(74, Main.multiplicativeInverse(51, 77));
        }

                @Test
        public void testComputeY() {
              Assert.assertEquals(BigInteger.valueOf(1968), Main.computeY(BigInteger.valueOf(500), BigInteger.valueOf(3000), 103,101));
                }

                @Test
                public void testComputeY2() throws IllegalArgumentException {

                    int num1 = 36;
                    int num2 = 206;
                    int prime1 = 103;
                    int prime2 = 107;
                    int expectRes = (num1 * num2) % (prime1 * prime2);
                    if(num1 < prime1 * prime2 && num2 < prime1*prime2) {
                        Assert.assertEquals(BigInteger.valueOf(expectRes), Main.computeY(BigInteger.valueOf(num1), BigInteger.valueOf(num2), prime1, prime2));
                    } else {
                        throw new IllegalArgumentException("both X and Y should be smaller than p * q");
                    }
                }



}