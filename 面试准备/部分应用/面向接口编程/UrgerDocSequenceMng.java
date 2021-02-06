package com.rongji.egov.rjoa.urger.business.service;

import com.rongji.egov.rjoa.urger.business.model.UrgerDocSequence;
import com.rongji.egov.utils.api.paging.Page;
import com.rongji.egov.utils.api.paging.PagingRequest;

import java.util.HashMap;
import java.util.List;

public interface UrgerDocSequenceMng extends SerialNumber {
    /**
     * 获取督查流水号列表
     * @param paging
     * @param urgerDocSequence
     * @param word
     * @return
     */
    Page<UrgerDocSequence> getUrgerSequence4Page(PagingRequest<UrgerDocSequence> paging, UrgerDocSequence urgerDocSequence, String word);

    /**
     * 通过id获取督查流水号详情
     * @param id
     * @return
     */
    UrgerDocSequence getUrgerSequenceById(String id);

    /**
     * 通过督查流水号名称查找
     * @param sequenceName
     * @param systemNo
     * @return
     */
    UrgerDocSequence getUrgerSequenceBySequenceName(String sequenceName, String systemNo);

    /**
     * 更改督查流水号
     * @param urgerDocSequence
     * @return
     */
    UrgerDocSequence updateUrgerSequence(UrgerDocSequence urgerDocSequence);

    /**
     * 新增督查流水号
     * @param urgerDocSequence
     * @return
     */
    UrgerDocSequence insertUrgerSequence(UrgerDocSequence urgerDocSequence);

    /**
     * 删除督查流水号
     * @param ids
     * @return
     */
    Boolean deleteUrgerSequences(List<String> ids);

    /**
     * 获取全部督查流水号
     * @param systemNo
     * @return
     */
    List<UrgerDocSequence> getUrgerSequenceOrderBySortNo(String systemNo);

    /**
     * 根据督查类型生成流水号
     * @param urgerType
     * @return
     */
    HashMap<String, Object> generateDocSequence(String urgerType);
}
