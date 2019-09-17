/**
 * @Author: 王吉
 * @Description：
 * @Date: Created in  2019/9/2
 * @Modifited By:
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName:test
 * @Description:
 * @Author:ASUS
 * @Date:2019/9/2 11:22
 * @Version:1.0
 **/
public class test {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        long sum=0L;
        int   count=0;
        String regex="step1:\\d+ms,step2:\\d+ms,step3:\\d+ms";
//        String testData1="requesttime:2019-09-04 00:00:00,clientip:127.0.0.1,step1:10ms,step2:20ms,step3:10ms,return_cnt:112";
//        String testData2="requesttime:2019-09-04 00:00:00,clientip:127.0.0.1,step1:30ms,step2:15ms,step3:20ms,return_cnt:11";
        Pattern pattern=Pattern.compile(regex);
        //s  System.out.println(Pattern.matches(regex, "step1:\\d+ms,step2:\\d+ms,step3:\\d+ms"));
        while (scanner.hasNextLine()) {
            String data = scanner.nextLine();
            Matcher matcher = pattern.matcher(data);
            //    MatchResult matchResult=matcher.toMatchResult();
            if (matcher.find()) {
                String tmpData0=data.replaceAll("requesttime:\\d{4}-\\d{2}-\\d{2}\\s+\\d{2}:\\d{2}:\\d{2},clientip:\\d+.\\d+.\\d+.\\d+,","");
                String tmpData1= tmpData0.replaceAll("step[123]:","");
                String tmpData2=tmpData1.replaceAll("ms","");
                String[] result=tmpData2.split(",");
                int step1 = Integer.valueOf( result[0]);
                System.out.println(step1);
                int step2 = Integer.valueOf(result[1]);
                System.out.println(step2);
                int step3 = Integer.valueOf(result[2]);
                System.out.println(step3);
                sum += step1 + step2 + step3;
                count += 1;
            }
        }
        System.out.println(String.format("%.2f",Math.round(1.0*sum/count)));


    }
}
