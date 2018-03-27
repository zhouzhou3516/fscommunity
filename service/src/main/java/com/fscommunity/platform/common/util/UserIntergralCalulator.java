package com.fscommunity.platform.common.util;

/**
 * 用户积分增加计算器
 * @author lixiaoxiong
 * @version 2018-03-28
 */
public class UserIntergralCalulator {

    public static int addIntegral(int continuousDays) {
        if (continuousDays <= 3) {
            return 10;
        }

        if (continuousDays >3 && continuousDays <=7) {
            return 12;
        }

        if (continuousDays > 7 && continuousDays <= 30) {
            return 17;
        }

        if (continuousDays > 30) {
            return 30;
        }

        return 10;
    }
}
