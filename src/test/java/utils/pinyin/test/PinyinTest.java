package utils.pinyin.test;

import junit.framework.TestCase;
import utils.pinyin.Pinyin;
import utils.pinyin.PinyinException;

/**
 * 单元测试
 * @author Administrator
 *
 */
public class PinyinTest extends TestCase {
    public void testPinyin(){
        Pinyin py = null;
        try {
            py = new Pinyin();
        } catch (PinyinException e) {
            e.printStackTrace();
        }

        String[] result1 = py.translateInArray("我是中国人，我爱我的祖国。i am a chinese, i love china.");
        String[] expect1 = {"wǒ","shì","zhōng","guó","rén","，","wǒ","ài","wǒ","de","zǔ","guó","。","i"," ","a","m"," ","a"," ","c","h","i","n","e","s","e",","," ","i"," ","l","o","v","e"," ","c","h","i","n","a","."};
        for (int i = 0; i < result1.length; i++){
            assertEquals(result1[i], expect1[i]);
        }

        String result2 = py.translate("わたしわ数据, and my English name is Tom. ^_^。下面是一段多音分词歧义测试，冬天：能穿多少穿多少；夏天：能穿多少穿多少。");
        assertEquals(result2, "わたしわshùjù , and my English name is Tom。xiàmiànshìyīduànduōyīnfèncíqíyìcèshì，dōngtiān：néngchuānduōshǎochuānduōshǎo；xiàtiān：néngchuānduōshǎochuānduōshǎo。");

        String result3 = py.translateWithSep("世界你好, hello world", ",");
        assertEquals(result3, "shì,jiè,nǐ,hǎo,,, ,h,e,l,l,o, ,w,o,r,l,d");

        String result3_1 = py.translateWithSep("世界你好, hello world");
        assertEquals(result3_1, "shì,jiè,nǐ,hǎo,,, ,h,e,l,l,o, ,w,o,r,l,d");

        String[] result4 = py.translateInArrayNoMark("わたしわ数据, and my English name is Tom. ^_^。下面是一段多音分词歧义测试，冬天：能穿多少穿多少；夏天：能穿多少穿多少。");
        this.dumpStringArray(result4);

        String result5 = py.translateFirstChar("わたしわ数据, and my English name is Tom. ^_^。下面是一段多音分词歧义测试，冬天：能穿多少穿多少；夏天：能穿多少穿多少。");
        System.out.println(result5);
    }

    private void dumpStringArray(String[] array){
        System.out.print("[");
        for (String element : array){
            System.out.print(element + ",");
        }
        System.out.print("]\n");
    }
}
