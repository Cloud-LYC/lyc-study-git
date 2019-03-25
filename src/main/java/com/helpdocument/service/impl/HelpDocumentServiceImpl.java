package com.helpdocument.service.impl;


import com.helpdocument.dao.HelpDocumentDao;
import com.helpdocument.dto.CommonResponse;
import com.helpdocument.dto.HelpDocumentWrapper;
import com.helpdocument.entity.HelpDocument;
import com.helpdocument.service.HelpDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Auther: liyuanchi
 * @Date: 2018/2/7
 * @Time: 17:01
 */
@Service("helpDocumentService")
public class HelpDocumentServiceImpl implements HelpDocumentService {
    @Resource
    private HelpDocumentDao helpDocumentDao;

    @Override
    public CommonResponse<Boolean> updateHelpDocumentStatus(int id, int status) {

        if (helpDocumentDao.updateStatus(id, status) > 0){
            return CommonResponse.buildSuccessResponse(true,"更新状态成功");
        }
        else {
            return CommonResponse.buildFailResponse("更新状态失败");
        }
    }

    @Override
    public CommonResponse<Boolean> addHelpDocument(HelpDocument helpDocument) {
        if (helpDocumentDao.insert(helpDocument) > 0 ) {
            return CommonResponse.buildSuccessResponse(true,"添加成功");
        }
        return CommonResponse.buildFailResponse("添加失败");
    }

    @Override
    public CommonResponse<Boolean> editHelpDocument(HelpDocument helpDocument) {
        if (helpDocumentDao.update(helpDocument) > 0){
            return CommonResponse.buildSuccessResponse(true,"更新成功");
        }
        else {
            return CommonResponse.buildFailResponse("更新失败");
        }
    }

    @Override
    public CommonResponse<HelpDocument> loadHelpDocumentById(int id) {
        HelpDocument helpDocument = helpDocumentDao.load(id);
        if (helpDocument != null && helpDocument.getId() >0){
            return CommonResponse.buildSuccessResponse(helpDocument);
        }
        return CommonResponse.buildFailResponse("无信息");    }

    @Override
    public CommonResponse<HelpDocumentWrapper> queryHelpDocument() {
        List<HelpDocument> helpDocumentList = helpDocumentDao.query();
        if (helpDocumentList.size() == 0){
            return CommonResponse.buildFailResponse("无信息");
        }
        HelpDocumentWrapper helpDocumentWrapper = new HelpDocumentWrapper();
        helpDocumentWrapper.setHelpDocuments(helpDocumentList);

        return CommonResponse.buildSuccessResponse(helpDocumentWrapper);
    }

    @Override
    public CommonResponse<HelpDocumentWrapper> queryHelpDocumentByType(int type) {
        List<HelpDocument> helpDocumentList = helpDocumentDao.queryByType(type);
        if (helpDocumentList.size() == 0){
            return CommonResponse.buildFailResponse("无信息");
        }
        HelpDocumentWrapper helpDocumentWrapper = new HelpDocumentWrapper();
        helpDocumentWrapper.setHelpDocuments(helpDocumentList);

        return CommonResponse.buildSuccessResponse(helpDocumentWrapper);
    }

    @Override
    public CommonResponse<HelpDocumentWrapper> queryHelpDocumentLikeTitle(String title) {
        List<HelpDocument> helpDocumentList = helpDocumentDao.queryLikeTitle(title);
        if (helpDocumentList.size() == 0){
            return CommonResponse.buildFailResponse("无信息");
        }
        HelpDocumentWrapper helpDocumentWrapper = new HelpDocumentWrapper();
        helpDocumentWrapper.setHelpDocuments(helpDocumentList);

        return CommonResponse.buildSuccessResponse(helpDocumentWrapper);
    }
}
