import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void minExtraCharTest1() {
        String s = "leetscode";
        String[] dictionary = {"leet", "code", "leetcode"};
        int expected = 1;
        int actual = new Solution().minExtraChar(s, dictionary);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void minExtraCharTest2() {
        String s = "sayhelloworld";
        String[] dictionary = {"hello", "world"};
        int expected = 1;
        int actual = new Solution().minExtraChar(s, dictionary);

        Assert.assertEquals(expected, actual);
    }

}
