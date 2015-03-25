import org.junit.Test;

import static org.junit.Assert.*;


public class ex100Test {

    @Test
    public void testCheck() throws Exception {
        assertEquals(true, ex100.check("a(beer)"));
        assertEquals(true, ex100.check("[{}]"));
        assertEquals(false, ex100.check("[(]"));
        assertEquals(false, ex100.check("}{"));
        assertEquals(true, ex100.check("z([{}-()]{a})"));
        assertEquals(true, ex100.check(""));
        assertEquals(false, ex100.check("a(( b)"));
    }
    @Test
    public void testCheck2() throws Exception {
        assertEquals(true, ex100.check2("a(beer)"));
        assertEquals(true, ex100.check2("[{}]"));
        assertEquals(false, ex100.check2("[(]"));
        assertEquals(false, ex100.check2("}{"));
        assertEquals(true, ex100.check2("z([{}-()]{a})"));
        assertEquals(true, ex100.check2(""));
        assertEquals(false, ex100.check2("a(( b)"));

    }
}