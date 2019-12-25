package com.lyc.study.search;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;

import java.util.List;

/**
 * create by Intellij IDEA.
 *
 * @author: liyuanchi
 * @date: 2019/12/24
 * @time: 17:29
 * @desc:
 */
@Slf4j
public class PinYinFirstChar {

    public static void main(String[] args) {
        List<String> shopNames = Lists.newArrayList("阿甘锅盔","APPLE STORE","阿芮烤鸡爪","避风塘Express","霸蛮湖南常德米粉","必胜客","报喜鸟","Camicissimo","草本工坊","cheers齐饮进口葡萄酒","超级花坊","超级物种","茶米茶","大燕和食","ELEGANTLIFESTYLE","ESANE","GREASE by TWOFACE 双面理发馆","HARBOR HOUSE美国整体家居","HEARTISANS匠心艺语手工皮艺皮具体验店","9号高尔夫球俱乐部","荷花泰菜","好利来","海马体照相馆","华为授权体验店","华夏影城","好鱼鲜","黑泷太郎","九木杂物社","匠人牛品烧肉","玖五京菜","匠心工坊","空处生活馆","鲁采LU STYLE","鹿港小镇","乐刻健身","龙门花甲","冷面张","蓝小喵串串","弥茶","抹茶本铺","麦当劳","满记甜品","木墨","冒鲜","米芝莲","Nail Raven日式美甲美睫","NǑME","牛排家","O-lens北京环宇荟店","polymono","屈臣氏","royaltea皇茶","十八字金银饰DIY体验","陕客肉夹馍","神奇熊可可","三三潮品生活馆","莎莎salsa","圣提生活馆","同或绘馆","同仁堂健康","Ummm Classic 最意·经典","wagas","丸龟制面","wow beal","星巴克臻选","小罐茶","喜家德虾仁水饺","熊猫日记牛轧糖","小明同学","小吾厨房","小心虾滑","伊豆野菜村","壹霖·洱语云南菜","野人牧坊","野叶子","呷哺呷哺","ZENS哲品","ZEROLL零擀面包","ZHIZUO","恺米切","中信书店","知作");

        for (String shopName : shopNames) {
            String shopNameInitialsChar = getShopNameInitialsChar(shopName);
            System.out.println(shopName + "=======" +shopNameInitialsChar+"\n");
        }


    }


    public static String getShopNameInitialsChar(String str) {
        String alpha = getAlpha(str);
        StringBuilder result = new StringBuilder();
        for (char c : alpha.toCharArray()) {
            char resultChar = getBigCh(c);
            if (resultChar != '#') {
                result.append(resultChar);
            }
        }
        return result.toString();
    }



    public static char getBigCh(char ch) {
        // 对英文字母的处理：小写字母转换为大写，大写的直接返回
        if (ch >= 'a' && ch <= 'z') {
            return (char) (ch - 'a' + 'A');
        }
        if (ch >= 'A' && ch <= 'Z') {
            return ch;
        }
        return '#';
    }


    /**
     * 获得汉语拼音首字母(简繁体通用)（只处理中文汉字其余字符不做改变）
     *
     * @param chines
     *            汉字
     * @return
     */
    public static String getAlpha(String chines) {
        String pinyinName = "";
        char[] nameChar = chines.toCharArray();
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.UPPERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        for (int i = 0; i < nameChar.length; i++) {
            if (nameChar[i] == 160 || isChinesePunctuation(nameChar[i])){
                continue;
            }
            if (nameChar[i] > 128) {
                try {
                    String[] hanyuPinyinStringArray = PinyinHelper.toHanyuPinyinStringArray(nameChar[i], defaultFormat);
                    if (hanyuPinyinStringArray != null && hanyuPinyinStringArray.length > 0){
                        pinyinName += hanyuPinyinStringArray[0].charAt(0);
                    }
                } catch (Exception e) {
                    log.warn("getAlpha error chines = {}", chines, e);
                    continue;
                }
            } else {
                pinyinName += nameChar[i];
            }
        }
        return pinyinName;
    }

    // 根据UnicodeBlock方法判断中文标点符号
    public static boolean isChinesePunctuation(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_FORMS
                || ub == Character.UnicodeBlock.VERTICAL_FORMS) {
            return true;
        } else {
            return false;
        }
    }


}
