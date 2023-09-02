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
        int expected = 3;
        int actual = new Solution().minExtraChar(s, dictionary);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void minExtraCharTest3() {
        String s = "dwmodizxvvbosxxw";
        String[] dictionary = {"ox","lb","diz","gu","v","ksv","o","nuq","r","txhe","e","wmo","cehy","tskz","ds","kzbu"};
        int expected = 7;
        int actual = new Solution().minExtraChar(s, dictionary);

        Assert.assertEquals(expected, actual);
    }
}
