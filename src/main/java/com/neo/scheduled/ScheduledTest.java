package com.neo.scheduled;


import com.neo.entity.Factory;
import com.neo.repository.FactoryRepository;
import com.neo.util.DateUtil;
import com.neo.util.RandomGUID;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/12/3.
 */
@Component
public class ScheduledTest {


    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(ScheduledTest .class);

    @Autowired
    private JdbcTemplate jt;

    @Autowired
    private FactoryRepository fr;

    @Scheduled(cron="* * * * * *")
    public void executeFileDownLoadTask() throws Exception{
        // 每秒添加数据


        List<Factory> all = fr.findAll();
        String[] s=new String[all.size()];
        Date d=new Date();
        String dateStr = DateUtil.dateParseString(d);

        for(int i=0;i<all.size();i++){
            Factory factory = all.get(i);

            //10个随机数

            int[] array=new int[10];
            for(int j=0;j<10;j++){
                array[j]=shuiji();
            }

            String sql1 =" INSERT INTO "+factory.getFactoryTable()+"(factory_id,data_time,enter_pressure,leave_pressure,enter_temperature,leave_temperature,water_open,plus_pressure,horizontal_vibration,vertical_vibration,mill_current,feed_volume)";
            sql1+="VALUES ( '"+factory.getFactoryId()+"', '"+dateStr+"', '"+array[0]+"', '"+array[1]+"', '"+array[2]+"', '"+array[3]+"', '"+array[4]+"', '"+array[5]+"', '"+array[6]+"', '"+array[7]+"', '"+array[8]+"', '"+array[9]+"');";

            s[i]=sql1;
        }
        jt.batchUpdate(s);
        //logger.info("ScheduledTest.executeFileDownLoadTask 定时任务1:"+current.getId()+ ",name:"+current.getName());
    }


    public Integer shuiji(){
        java.util.Random random=new java.util.Random();// 定义随机类
        int result=random.nextInt(10);// 返回[0,10)集合中的整数，注意不包括10
        return result+1;
    }


    /**
     * 定时删除数据
     * @throws Exception
     */
    @Scheduled(cron="* * * * * *")
    public void delData() throws Exception{
        // 每秒添加数据
        List<Factory> all = fr.findAll();
        String[] s=new String[all.size()];
        Date d=new Date();
        String dateStr = DateUtil.dateParseString(d);
        for(int i=0;i<all.size();i++){
            Factory factory = all.get(i);

            Calendar date = Calendar.getInstance();
            date.roll(Calendar.DATE, -10);//日期回滚7天
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String format = sdf.format(date);

            String sql1 =" DELETE FROM "+factory.getFactoryTable();
            sql1+="WHERE data_time <= '"+format+"'";

            s[i]=sql1;
        }
        jt.batchUpdate(s);
        //logger.info("ScheduledTest.executeFileDownLoadTask 定时任务1:"+current.getId()+ ",name:"+current.getName());
    }

}
