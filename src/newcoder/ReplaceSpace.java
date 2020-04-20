package newcoder;

/**
 * @author niushaokai
 * @date 2020/4/19
 */
public class ReplaceSpace {
    public String replaceSpace(StringBuffer str) {
        if (str == null)
            return "";
        String res = str.toString().replaceAll(" ","%20");
        return res;
    }

    public static void main(String[] args) {
        ReplaceSpace replaceSpace = new ReplaceSpace();
        StringBuffer sb = new StringBuffer();
        sb.append("we are happy");
        System.out.println(replaceSpace.replaceSpace(sb));
    }
}