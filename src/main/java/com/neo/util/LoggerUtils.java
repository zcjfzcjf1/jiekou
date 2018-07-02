package com.neo.util;



import com.neo.entity.RestSResponse;
import com.neo.enums.CheckEnum;
import com.neo.enums.ResultEnum;
import com.neo.javabean.CheckBean;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * 开发公司：SOJSON在线工具 <p>
 * 版权所有：© www.sojson.com<p>
 * 博客地址：http://www.sojson.com/blog/  <p>
 * <p>
 *
 * Log输出封装
 *
 * <p>
 *
 * 区分　责任人　日期　　　　说明<br/>
 * 创建　周柏成　2016年6月2日 　<br/>
 *
 * @author zhou-baicheng
 * @version 1.0,2016年6月2日 <br/>
 *
 */
public class LoggerUtils {
	/**
	 * 日志对象
	 */
	private static   Logger  logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    /**
     * 错误结果运算
     * @param rs 结果对象
     * @param result  结果字符串
     * @throws Exception
     */
    public  static void returnError(RestSResponse rs, String result) {
        logger.info(result);
        ResultEnum resultEnum = ResultEnum.PARAM_ERROR;
        rs.setRetCode(resultEnum.getRetCode());
        rs.setRetInfo(resultEnum.getRetInfo());
        rs.setData(result);
    }


    /**
     * 成功结果运算
     * @param rs 结果对象
     * @param result  结果字符串11
     * @throws Exception
     */
    public  static void returnSeccuess(RestSResponse rs, Object result) {
        logger.info(result);
        ResultEnum resultEnum = ResultEnum.SECCUESS;
        rs.setRetCode(resultEnum.getRetCode());
        rs.setRetInfo(resultEnum.getRetInfo());
        rs.setData(result);
    }

    public static boolean CheckConditions(RestSResponse rs, CheckBean[] cbarray){
        boolean falg=false;

        for(CheckBean cb:cbarray){
            CheckEnum[] checkEnum = cb.checkEnum;
            for (CheckEnum ce:checkEnum){
                switch (ce){
                    case ISNULL:
                        if(RegexUtils.isnull(cb.value)){
                            LoggerUtils.returnError(rs,cb.chinaName+"不能为空");
                            return falg;
                        }
                        break;
                    case ISNUMBER:
                        if(!RegexUtils.checkNumber(cb.value)){
                            LoggerUtils.returnError(rs,cb.chinaName+"不为数字"+cb.englishName+":"+cb.value);
                            return falg;
                        }
                        break;
                    case ISDATE:
                        if(!RegexUtils.checkDate(cb.value)){
                            LoggerUtils.returnError(rs,cb.chinaName+"不为时间格式"+cb.englishName+":"+cb.value);
                            return falg;
                        }
                        break;
                    case HHMMSS:
                        if(!RegexUtils.checkhhmmss(cb.value)){
                            LoggerUtils.returnError(rs,cb.chinaName+"不为时分秒格式"+cb.englishName+":"+cb.value);
                            return falg;
                        }
                        break;
                    case DATETIME:
                        if(!RegexUtils.checkDateTime(cb.value)){
                            LoggerUtils.returnError(rs,cb.chinaName+"不为时间格式"+cb.englishName+":"+cb.value);
                            return falg;
                        }
                        break;
                }
            }
        }

        return true;
    }

    public static void info(String info){
        logger.info(info);
    }

    public static void error(String info){
        logger.error(info);
    }
}
