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

        }

                @Test
        public void testComputeY() {
                Assert.assertEquals(BigInteger.valueOf(1968), Main.computeY(BigInteger.valueOf(3000), BigInteger.valueOf(500), 103,101));
                }

        }