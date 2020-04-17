package net.sandius.rembulan.lib;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import net.sandius.rembulan.testenv.TestBase;

@FixMethodOrder(MethodSorters.JVM)
public class StringFormatTest extends TestBase {
    
    @Test
    public void testStringFormatPercentG() throws Exception {
        assertThat(run("return string.format('a%gb', 1)")[0]).isEqualTo("a1b");
        assertThat(run("return string.format('a%gb', 2.0)")[0]).isEqualTo("a2b");
        assertThat(run("return string.format('a%gb', 3.1)")[0]).isEqualTo("a3.1b");
        assertThat(run("return string.format('a%gb', 30)")[0]).isEqualTo("a30b");
    }
    
    @Test
    public void testStringFormatPercentF() throws Exception {
        assertThat(run("return string.format('%03.0f', 23)")[0]).isEqualTo("023");
        assertThat(run("return string.format('%03.2f', 23.456)")[0]).isEqualTo("23.46");
        assertThat(run("return string.format('%3.2f', 23.456)")[0]).isEqualTo("23.46");
        assertThat(run("return string.format('%3.0f', 23)")[0]).isEqualTo(" 23");
    }

}
