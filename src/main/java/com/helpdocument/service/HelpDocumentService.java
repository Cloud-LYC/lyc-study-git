package com.helpdocument.service;


import com.helpdocument.entity.HelpDocument;
import com.helpdocument.dto.CommonResponse;
import com.helpdocument.dto.HelpDocumentWrapper;


/**
 * @Auther: liyuanchi
 * @Date: 2018/2/7
 * @Time: 15:59
 */
public interface HelpDocumentService {

    /**
     * 更改文档状态
     * @param id
     * @param status
     * @return
     */

    CommonResponse<Boolean> updateHelpDocumentStatus(int id, int status);

    /**
     * 添加文档
     * @param helpDocument
     * @return
     */
    CommonResponse<Boolean> addHelpDocument(HelpDocument helpDocument);

    /**
     * 编辑文档
     * @param helpDocument
     * @return
     */
    CommonResponse<Boolean> editHelpDocument(HelpDocument helpDocument);

    /**
     * 根据ID得到文档
     * @param id
     * @return
     */
    CommonResponse<HelpDocument> loadHelpDocumentById(int id);

    /**
     * 帮助文档列表
     * @return
     */
    CommonResponse<HelpDocumentWrapper> queryHelpDocument();


    /**
     * 根据文档分类查询
     * @param type
     * @return
     */
    CommonResponse<HelpDocumentWrapper> queryHelpDocumentByType(int type);

    /**
     * 模糊查询
     * @return
     */
    CommonResponse<HelpDocumentWrapper> queryHelpDocumentLikeTitle(String title);

}
