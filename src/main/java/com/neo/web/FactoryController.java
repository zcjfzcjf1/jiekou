package com.neo.web;

import com.neo.entity.*;
import com.neo.service.FactoryService;
import com.neo.service.UserService;
import com.neo.util.DateUtil;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by Administrator on 2017/12/9.
 */
@RestController
@RequestMapping("factroy")
public class FactoryController {

    @Resource
    FactoryService factoryService;

    @Autowired
    private JdbcTemplate jt;

    @RequestMapping("/getFactory")
    @ResponseBody
    // @AccessRequired(resoName="getList")
    public DataTableBean getList(User user, String a, String b,HttpServletRequest request,String length,String start) {
        RestSResponse rs=new RestSResponse();

        //查询工厂总数
        Integer recordsFiltered= factoryService.factoryCount();
        //查询工厂列表
        List<Factory> factory = factoryService.getFactory(Integer.parseInt(start), Integer.parseInt(length));
        List<FactoryInfo> infoList=new ArrayList<FactoryInfo>();
        for(int i=0;i<factory.size();i++){
            Factory factory1 = factory.get(i);
            FactoryInfo fi=new FactoryInfo();
            fi.setFactoryId(factory1.getFactoryId());
            fi.setFactoryName(factory1.getFactoryName());

            //使用jdbc获得其他数据


            String sql="SELECT factory_data_no, factory_id, data_time  , enter_pressure, leave_pressure, enter_temperature, leave_temperature,water_open,plus_pressure,horizontal_vibration,vertical_vibration,mill_current,feed_volume";
            sql+=" FROM "+factory1.getFactoryTable()+",";
            sql+=" (select max(data_time) as data_time1 from "+factory1.getFactoryTable()+" ) b";
            sql+=" where data_time =b.data_time1 ";
            sql+="  limit 1 ";

             Map<String, Object> m = jt.queryForMap(sql);
//            fi.setFactoryDataNo(m.get("factory_data_no").toString());
            fi.setFactoryId(m.get("factory_id").toString());
            fi.setDataTime(m.get("data_time").toString());
            fi.setEnterPressure(m.get("enter_pressure").toString());
            fi.setLeavePressure(m.get("leave_pressure").toString());
            fi.setEnterTemperature(m.get("enter_temperature").toString());
            fi.setLeaveTemperature(m.get("leave_temperature").toString());
            fi.setWaterOpen(m.get("water_open").toString());
            fi.setPlusPressure(m.get("plus_pressure").toString());
            fi.setHorizontalVibration(m.get("horizontal_vibration").toString());
            fi.setVerticalVibration(m.get("vertical_vibration").toString());
            fi.setMillCurrent(m.get("mill_current").toString());
            fi.setFeedVolume(m.get("feed_volume").toString());
            infoList.add(fi);
        }

        DataTableBean<FactoryInfo> dataTableBean = new DataTableBean<FactoryInfo>();
        dataTableBean.setDraw(Integer.parseInt(request.getParameter("draw") == null ? "0"
                : request.getParameter("draw")) + 1);
        dataTableBean.setRecordsFiltered(recordsFiltered.toString());
        dataTableBean.setRecordsTotal(recordsFiltered.toString());
        dataTableBean.setData(infoList);
        return dataTableBean;
    }

}
