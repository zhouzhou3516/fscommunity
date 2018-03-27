package com.fscommunity.platform.common.util;

import com.fscommunity.platform.persist.pojo.UserLevel;

/**
 * @author lixiaoxiong
 * @version 2018-03-28
 */
public class UserLevelCalulator {
    /**
     * Lv1-Lv4 每100积分升一级，Lv5-Lv8 每200积分升一级，Lv9-Lv12 每400积分升一级；即每4级每升一级积分翻一倍
     * @param integral
     * @return
     */
    public static UserLevel checkLevel(int integral) {
        int sum = 0;
        for (int i=1; i<1000; ++i) {
            int i1 = needIntegral(i);
            sum += i1;
            if (integral == sum) {
                return UserLevel.codeOf(i);
            } else if (integral < sum) {
                return UserLevel.codeOf(i - 1);
            }
        }
        return UserLevel.codeOf(0);
    }

    private static int needIntegral(int level) {
        int multipleOfFour = level % 4 == 0? level / 4 : (level / 4) + 1;
        return 100 * (int) Math.pow(2, multipleOfFour - 1);
    }
}
