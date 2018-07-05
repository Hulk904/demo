package com.demo.base.trampline;

import org.junit.Test;

import java.io.IOException;
import static org.junit.Assert.*;

/**
 * Created by yangyuan on 6/28/18.
 */
public class TrampolineAppTest {

    @Test
    public void testTrampolineWithFactorialFunction() throws IOException {
        int result = TrampolineApp.loop(10, 1).result();
        assertEquals("Be equal", 3628800, result);
    }
}
