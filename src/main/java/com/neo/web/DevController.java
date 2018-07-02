package com.neo.web;

import com.neo.entity.Factory;
import com.neo.entity.RestSResponse;
import com.neo.entity.User;
import com.neo.inter.AccessRequired;

import com.neo.service.FactoryService;
import com.neo.util.DateUtil;
import com.neo.util.RegexUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * Created by Administrator on 2017/11/25.
 */
@RestController
@RequestMapping("dev")
public class DevController {
    @Autowired
    private JdbcTemplate jt;

    @Autowired
    private FactoryService fs;

    @RequestMapping("/getList")
    @ResponseBody
   // @AccessRequired(resoName="getList")
    public RestSResponse getList( String factoryId, String valueName,
                                  String Date) throws Exception {
        RestSResponse rs=new RestSResponse();
        Date crruentDate=new Date();
        Date date=null;
        if(RegexUtils.isnull(factoryId)){
            factoryId="1";
        }
        if(RegexUtils.isnull(valueName)){
            valueName="enter_pressure";
        }
        if(RegexUtils.isnull(Date)){
            date=crruentDate;
        }else{
            date=DateUtil.StringToDate(Date);
        }


        Date subtractDay = DateUtil.dateSubtracthhmmss(date,"00:10:00");

        List<String> HHmmList=new ArrayList<String>();
        List<Date> dateList=new ArrayList<Date>();
        List<String> valyeList=new ArrayList<String>();
//        while(1==1){
//            if(subtractDay.getTime()>crruentDate.getTime()){
//                break;
//            }
//            subtractDay=new Date(subtractDay.getTime()+((long) 1 * 60 * 1000)) ;
//            dateList.add(subtractDay);
//            String HHmm = DateUtil.getHH(subtractDay);
//            HHmmList.add(HHmm);
//            valyeList.add("1");
//        }
        Factory factory= fs.findFactoryByFactoryId(factoryId);
        String sql="select data_time,"+valueName+" from "+factory.getFactoryTable()+" where data_time >'"+DateUtil.dateParseString(subtractDay)+"' and data_time <'"+DateUtil.dateParseString(date)+"'";

        List<Map<String, Object>> maps = jt.queryForList(sql);

        for(Map<String, Object> m:maps){
            String HHmm = DateUtil.getHH(DateUtil.stringParseDate(m.get("data_time").toString()));
            if(!HHmmList.contains(HHmm)){
                HHmmList.add(HHmm);
                valyeList.add(m.get(valueName).toString());
            }
        }


        Map<String,List<String>> m=new HashMap<>();
        m.put("dataList",HHmmList);
        m.put("valueList",valyeList);
        rs.setData(m);
        return rs;
    }



}
