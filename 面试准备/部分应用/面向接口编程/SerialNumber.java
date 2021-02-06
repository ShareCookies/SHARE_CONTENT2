package com.rongji.egov.rjoa.urger.business.service;

import com.alibaba.fastjson.JSONObject;

/**
 * @autor hecaigui
 * @date 2020-1-10
 * @description
 */
public interface SerialNumber {
    /**
     * 获取编号页面展示数据
     *
     * @param id      主文档ID
     * @param docWord 字 例：榕政
     * @param docMarkYear 年份  例：2001
     * @param docMarkNum 序号  例：1
     * @return {"docMarkYear":2021,"docMark":"群众来信2021D000010019","noUsedMaxNo":20,""docMarkNum":19 ，docMarkId":"XcOEW1S1T-zjSKnB"}
     */
    public abstract JSONObject getSerialPageJson(String systemNo, String id, String docWord, Integer docMarkYear, Integer docMarkNum);

    /**
     * 获取漏号<br/>
     *
     * @param docWord 字 例：榕政
     * @param docMarkYear 年份  例：2001
     * @param docMarkId 文件字对应id  例：
     * @return 1,2,3
     */
    public abstract String getLoseNum(String docWord, int docMarkYear, String systemNo, String docMarkId);

    /**
     * 编号
     *
     * @param docMark     文号 例：榕政20011
     * @param docId       主文档ID
     * @param docWord     文件字 例：榕政
     * @param docMarkYear 年度 例：2001
     * @param docMarkNum  序号 例：1
     * @param docMarkId 文件字对应id  例：
     * @return
     */
    public abstract void serialNum(String docId, String docWord, String docMark, int docMarkYear, int docMarkNum, String systemNo, String docMarkId);

}
