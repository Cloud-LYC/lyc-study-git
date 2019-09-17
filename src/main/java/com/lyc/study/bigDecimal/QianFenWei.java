package com.lyc.study.bigDecimal;

import java.text.DecimalFormat;

/**
 * create by Intellij IDEA.
 *
 * @author: liyuanchi
 * @date: 2019/8/27
 * @time: 18:01
 * @desc:
 */
public class QianFenWei {

    public static void main(String[] args) {
        System.out.println(fmtMicrometer("-458794.291236"));
    }

    public static String fmtMicrometer(String text) {
        DecimalFormat df = null;
        if (text.indexOf(".") > 0) {
            if (text.length() - text.indexOf(".") - 1 == 0) {
                df = new DecimalFormat("###,##0.");
            } else {
                df = new DecimalFormat("###,##0.0");
            }
        } else {
            df = new DecimalFormat("###,##0");
        }
        double number = 0.0;
        try {
            number = Double.parseDouble(text);
        } catch (Exception e) {
            number = 0.0;
        }
        return df.format(number);
    }
}
