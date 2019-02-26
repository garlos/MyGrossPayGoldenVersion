import org.junit.Test;

import static org.junit.Assert.*;

public class NetPayCalcTest {

    @Test
    public void netPayCalc() {
        NetPayCalc netPay = new NetPayCalc();
        assertEquals(1254.2,netPay.netPayCalc(3.0,55.0,12.0,80.0));
    }
}