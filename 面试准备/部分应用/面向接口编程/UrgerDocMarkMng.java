package com.rongji.egov.rjoa.urger.business.service;

import com.alibaba.fastjson.JSONObject;
import com.rongji.egov.rjoa.urger.business.model.UrgerDocMark;
import com.rongji.egov.utils.api.paging.Page;
import com.rongji.egov.utils.api.paging.PagingRequest;

import java.util.HashMap;
import java.util.List;

public interface UrgerDocMarkMng extends SerialNumber {
    /**
     * 获取督查文号列表
     * @param paging
     * @param urgerDocMark
     * @param word
     * @return
     */
    Page<UrgerDocMark> getUrgerDocMark4Page(PagingRequest<UrgerDocMark> paging, UrgerDocMark urgerDocMark, String word);
    /**
     * 通过id获取督查文号详情
     * @param id
     * @return
     */
    UrgerDocMark getUrgerDocMarkById(String id);
    /**
     * 通过督查文号名称查找
     * @param sequenceName
     * @param systemNo
     * @return
     */
    UrgerDocMark getUrgerDocMarkBySequenceName(String sequenceName, String systemNo);
    /**
     * 更改督查文号
     * @param urgerDocMark
     * @return
     */
    UrgerDocMark updateUrgerDocMark(UrgerDocMark urgerDocMark);
    /**
     * 新增督查文号
     * @param urgerDocMark
     * @return
     */
    UrgerDocMark insertUrgerDocMark(UrgerDocMark urgerDocMark);
    /**
     * 删除督查文号
     * @param ids
     * @return
     */
    Boolean deleteUrgerDocMarks(List<String> ids);
    /**
     * 获取全部督查文号
     * @param systemNo
     * @return
     */
    List<HashMap> getUrgerDocMarkOrderBySortNo(String systemNo);

    /**
     * 获取文号使用编号的最大值
     *
     * @param year
     * @return
     */
    Object getDisDocNumMaxNoByUsedNos(UrgerDocMark urgerDocMark, Integer year);
    /**
     * 根据文件字、年度、序号-生成文号
     *
     * @param urgerDocMark
     * @return {docMark,docMarkNum}
     */
    JSONObject generateDocNum(UrgerDocMark urgerDocMark, Integer docMarkYear, Integer docMarkNum);

    /**
     * 获取文号全部组
     * @param systemNo
     * @return
     */
    List<JSONObject> getGroups(String systemNo);
}
