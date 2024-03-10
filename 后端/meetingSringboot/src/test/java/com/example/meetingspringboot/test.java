import com.example.meetingspringboot.util.QrCodeUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Stack;

public class test {
//    public static void main(String[] args) {
//        // 步骤1: 创建一个Date对象
//        Date date = new Date();
////        date ="2023-11-17 08:00:00";
//        // 步骤2: 设置需要加的小时数
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(date);
//        int hoursToAdd = 3; // 设置需要加的小时数，这里示例为3小时
//        calendar.add(Calendar.HOUR_OF_DAY, hoursToAdd);
//        // 步骤3: 获取加小时后的日期
//        Date newDate = calendar.getTime();
//
//        // 步骤4: 输出加小时后的日期
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String formattedDate = sdf.format(newDate);
//        System.out.println(formattedDate);
//        String ddd="2023-11-17 08:00:00";
//        String[] collection = ddd.split("[: -]");
//        for (int i=0;i<collection.length;i++){
//            System.out.println(collection[i]);
//        }
//
//    }
    public static void main(String[] args) throws ParseException {
//        String ids="11,12";
//            System.out.println(ids);
//            String time="";
//            String[] collection = ids.split(",");
//            System.out.println(collection[1]);
//        Stack<Integer> start = new Stack<>();
//        Stack<Integer> end = new Stack<>();
//            start.push(Integer.parseInt(collection[0]));
//            for(int i=1;i<collection.length;i++) {
//                if (Integer.parseInt(collection[i])!=Integer.parseInt(collection[i-1])+1){
//                    start.push(Integer.parseInt(collection[i]));
//                    end.push(Integer.parseInt(collection[i-1]));
//                }else {
//                }
//            }
//        end.push(Integer.parseInt(collection[collection.length-1]));
//        System.out.println("start"+start);
//        System.out.println("end"+end);
//        while (!start.isEmpty()){
//            if (start.peek()==end.peek()){
//                time=(start.pop()+8)+":00~"+(end.pop()+9)+":00"+" "+time;
//            }else {
//                time=(start.pop()+8)+":00~"+(end.pop()+9)+":00"+" "+time;
//
//            }
//        }
//        System.out.println(time);
        String str1 = "2021-09-24 12:13:14";
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date myDate = sdf1.parse(str1);
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        String strDate1 = sdf2.format(myDate);
        System.out.println("strDate2:" + strDate1);

    }

}