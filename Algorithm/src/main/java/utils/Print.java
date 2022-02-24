package utils;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Print {
    public static List<String> timeCut(LocalDateTime inTime, LocalDateTime outTime, List<LocalTime> cutTimes) {
        List<String> list = new LinkedList<>();
        if (inTime.isAfter(outTime)) return null;
        boolean flag = true;
        // 开始时间设为切割点起点
        for (LocalTime cutTime : cutTimes) {
            // 初始切割点在左边界以外
            if (inTime.toLocalTime().isAfter(cutTime))
            {
                list.add(inTime+"~"+inTime.plusSeconds(24*60*60-Duration.between(cutTime,inTime.toLocalTime()).getSeconds()));
                inTime = inTime.plusSeconds(24*60*60-Duration.between(cutTime,inTime.toLocalTime()).getSeconds());
                continue;
            }
            // 初始切割点在右边界以外
            if (inTime.toLocalTime().isBefore(cutTime)){
                list.add(inTime + "~" + inTime.plusSeconds(Duration.between(inTime.toLocalTime(),cutTime).getSeconds()));
                inTime = inTime.plusSeconds(Duration.between(inTime.toLocalTime(),cutTime).getSeconds());
                continue;
            }
            list.add(inTime + "~" + inTime.plusSeconds(Duration.between(inTime.toLocalTime(),cutTime).getSeconds()));
            inTime = inTime.plusSeconds(Duration.between(inTime.toLocalTime(),cutTime).getSeconds());
        }
        while (flag){
            for (LocalTime cutTime : cutTimes) {
                if (cutTime .equals(inTime.toLocalTime())) {
                    cutTime.plusHours(24);
                }
                list.add(inTime + "~" + inTime.plusSeconds((Duration.between(inTime.toLocalTime(),cutTime)).getSeconds() == 0
                        ? 24*60*60
                        :(Duration.between(inTime.toLocalTime(),cutTime)).getSeconds()));
                inTime = inTime.plusSeconds((Duration.between(inTime.toLocalTime(),cutTime)).getSeconds() == 0
                        ? 24*60*60
                        :(Duration.between(inTime.toLocalTime(),cutTime)).getSeconds());
                // 如果左边界大于等于右边界 --> 结束
                if (outTime.isBefore(inTime) || outTime.isEqual(inTime)) {
                    // 删除list最后一个越界时间
                    list.remove(list.size() -1 );
                    list.add(inTime.minusSeconds((Duration.between(inTime.toLocalTime(),cutTime)).getSeconds())+ "~" + outTime);
                    flag = false;
                    break;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {

        List<LocalTime> list = new ArrayList<>();

        list.add(LocalTime.of(10,0,0));
        list.add(LocalTime.of(12,0,0));
        list.add(LocalTime.of(14,0,0));
        list.add(LocalTime.of(18,0,0));
        List<String> cuts = timeCut(
                LocalDateTime.of(2020,9,14,14,0,0),
                LocalDateTime.of(2020,9,17,8,0,0),
                list);
        for (String cut : cuts) {
            System.out.println(cut);
        }
    }


}
