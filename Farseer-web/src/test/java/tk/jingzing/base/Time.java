package tk.jingzing.base;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wangyunjing on 16/9/29.
 */
public class Time {
    public static void main(String[] args) throws Exception {
     //   TimeDiff("2016-09-29 16:00","2016-09-30 08:00");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        Date d1 = format.parse("2016-09-29 16:00");
        Date d2 = format.parse("2016-09-29 18:00");
        System.out.println("Time.main:" + diffMinute(d1,d2));
    }
    /**
     * 判断2个时间相差多少天、多少小时、多少分<br>
     * <br>
     * @param pBeginTime 请假开始时间<br>
     * @param pEndTime 请假结束时间<br>
     * @return String 计算结果<br>
     * @Exception 发生异常<br>
     */
    public static String TimeDiff(String pBeginTime, String pEndTime) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        Long beginL = format.parse(pBeginTime).getTime();
        Long endL = format.parse(pEndTime).getTime();
        Long day = (endL - beginL) / 86400000;
        Long hour = ((endL - beginL) % 86400000) / 3600000;
        Long min = ((endL - beginL) % 86400000 % 3600000) / 60000;

        System.out.println("Time.TimeDiff:" + "实际请假" + day + "小时" + hour + "分钟" + min);
        return ("实际请假" + day + "小时" + hour + "分钟" + min);

    }

    public static Integer diffMinute(Date sd, Date ed) {
        if (null != sd && null != ed) {
            return (int) ((ed.getTime() - sd.getTime()) / 60000);
        }
        return -1;
    }

    public static Long dateDiffByType(String startTime, String endTime, String str) {
        // 按照传入的格式生成一个simpledateformate对象
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        long nd = 1000 * 24 * 60 * 60;// 一天的毫秒数
        long nh = 1000 * 60 * 60;// 一小时的毫秒数
        long nm = 1000 * 60;// 一分钟的毫秒数
        long ns = 1000;// 一秒钟的毫秒数
        long diff;
        long day = 0;
        long hour = 0;
        long min = 0;
        long sec = 0;
        // 获得两个时间的毫秒时间差异
        try {
            diff = sd.parse(endTime).getTime() - sd.parse(startTime).getTime();
            day = diff / nd;// 计算差多少天
            hour = diff % nd / nh + day * 24;// 计算差多少小时
            min = diff % nd % nh / nm + day * 24 * 60;// 计算差多少分钟
            sec = diff % nd % nh % nm / ns;// 计算差多少秒
            // 输出结果
            System.out.println("时间相差：" + day + "天" + (hour - day * 24) + "小时"
                    + (min - day * 24 * 60) + "分钟" + sec + "秒。");
            System.out.println("hour=" + hour + ",min=" + min);
            if (str.equalsIgnoreCase("h")) {
                return hour;
            } else {
                return min;
            }

        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (str.equalsIgnoreCase("h")) {
            return hour;
        } else {
            return min;
        }
    }
 }
