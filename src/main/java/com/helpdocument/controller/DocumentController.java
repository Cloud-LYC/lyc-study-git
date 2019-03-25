package com.helpdocument.controller;

import com.helpdocument.dto.CommonResponse;
import com.helpdocument.dto.HelpDocumentWrapper;
import com.helpdocument.entity.HelpDocument;
import com.helpdocument.service.HelpDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * @Auther: liyuanchi
 * @Date: 2018/2/8
 * @Time: 16:06
 */
@Controller
@RequestMapping("/document")
public class DocumentController extends BaseController{
    @Resource
    private HelpDocumentService helpDocumentService;

    @RequestMapping(value = "/faq", method = RequestMethod.GET)
    public ModelAndView helpDocumentList() {
        ModelAndView modelAndView = new ModelAndView("query");
        CommonResponse<HelpDocumentWrapper> response = helpDocumentService.queryHelpDocument();
        if (response.isResult()){
            if (CollectionUtils.isNotEmpty(response.getData().getHelpDocuments())){
                modelAndView.addObject("documents",response.getData().getHelpDocuments());
            }
        }

        return modelAndView;
    }

    @RequestMapping(value = "/updateStatus", method = RequestMethod.GET)
    public String updateStatusDocument(@RequestParam("id") int id,
                                       @RequestParam("status") int status,
                                       @RequestParam("author") String author) {

        //可以验证用户身份再让其进行操作
        /*if (!UserLoginUtil.getUserAccount().getEnName().equals(author)) {
            return "redirect:/document/unauthorized";
        } else {
            CommonResponse<Boolean> commonResponse = helpDocumentService.updateHelpDocumentStatus(id, status);
            return "redirect:/document/faq";
        }*/

        CommonResponse<Boolean> commonResponse = helpDocumentService.updateHelpDocumentStatus(id, status);
        return "redirect:/document/faq";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public ModelAndView documentEdit(@RequestParam("document_id") int id,
                                     @RequestParam("author") String author){

        CommonResponse<HelpDocument> response = helpDocumentService.loadHelpDocumentById(id);
        if (response.getData() != null){
            //可以验证用户身份再让其进行操作
            /*if (!UserLoginUtil.getUserAccount().getEnName().equals(author)) {
                return new ModelAndView("/unauthorized");
            }else {
                ModelAndView modelAndView = new ModelAndView("document/add");
                modelAndView.addObject("document", response.getData());
                return modelAndView;
            }*/
            ModelAndView modelAndView = new ModelAndView("document/add");
            modelAndView.addObject("document", response.getData());
            return modelAndView;
        }else {
            return new ModelAndView("document/faq");
        }
    }

    @RequestMapping(value = "/edit/submit", method = RequestMethod.GET)
    public String documentEditSubmit(@RequestParam("document_id") int id,
                                     @RequestParam("document_title") String title,
                                     @RequestParam("document_url")  String url,
                                     @RequestParam("document_type") int type) throws Exception{
        if (StringUtils.isNotEmpty(title)){
            HelpDocument helpDocument = new HelpDocument();
            helpDocument.setId(id);
            helpDocument.setTitle(title);
            helpDocument.setUrl(url);
            helpDocument.setType(type);
//            helpDocument.setAuthor(UserLoginUtil.getUserAccount().getEnName());  设置用户

            helpDocumentService.editHelpDocument(helpDocument);
        }
        return "redirect:/document/faq";
    }

    @RequestMapping(value = "/create")
    public ModelAndView documenrCreate(){
        ModelAndView modelAndView = new ModelAndView("document/add");
        return modelAndView;
    }

    @RequestMapping(value = "/create/add", method = RequestMethod.POST)
    public String addDocument(@RequestParam("document_title") String title,
                              @RequestParam("document_url")  String url,
                              @RequestParam("document_type") int type) throws Exception {

        if (StringUtils.isEmpty(title) || StringUtils.isEmpty(url) || type <= 0){
            return "redirect:/document/faq";
        }

        HelpDocument helpDocument = new HelpDocument();
        helpDocument.setTitle(title);
        helpDocument.setUrl(url);
//        helpDocument.setAuthor(UserLoginUtil.getUserAccount().getEnName()); 设置用户
        helpDocument.setType(type);

        CommonResponse<HelpDocumentWrapper> response = helpDocumentService.queryHelpDocument();
        if (response.isResult()){
            if (CollectionUtils.isNotEmpty(response.getData().getHelpDocuments())){
                for (HelpDocument document : response.getData().getHelpDocuments()
                        ) {
                    if (document.getTitle().equals(helpDocument.getTitle())){
                        return "redirect:/document/faq";
                    }
                }
            }
        }

        CommonResponse<Boolean> result = helpDocumentService.addHelpDocument(helpDocument);

        if(result.getData()){
            return "redirect:/document/faq";
        }else {
            return "redirect:/document/faq";
        }
    }

    @RequestMapping(value = "/find/title",method = RequestMethod.GET)
    public ModelAndView findDocumentByTitle(@RequestParam("document_title") String title) throws Exception{
//        title = new String(title.getBytes("ISO-8859-1"),"UTF-8");
        ModelAndView modelAndView = new ModelAndView("query");
        CommonResponse<HelpDocumentWrapper> response = helpDocumentService.queryHelpDocumentLikeTitle(title);
        if (response.isResult()){
            if (CollectionUtils.isNotEmpty(response.getData().getHelpDocuments())){
                modelAndView.addObject("documents",response.getData().getHelpDocuments());
            }
        }

        return modelAndView;
    }

    @RequestMapping(value = "/find/type",method = RequestMethod.GET)
    public ModelAndView findDocumentByType(@RequestParam("document_type") int type){
        CommonResponse<HelpDocumentWrapper> response = null;
        ModelAndView modelAndView = new ModelAndView("document/query");
        if (type == 0){
            response = helpDocumentService.queryHelpDocument();
        }
        if (type > 0 ){
            response= helpDocumentService.queryHelpDocumentByType(type);
        }
        if (response != null && response.isResult()){
            if (CollectionUtils.isNotEmpty(response.getData().getHelpDocuments())){
                modelAndView.addObject("documents",response.getData().getHelpDocuments());
            }
        }
        return modelAndView;
    }

    @RequestMapping(value = "/unauthorized", method = RequestMethod.GET)
    public ModelAndView documentUnauthorized(){
        return new ModelAndView("/unauthorized");
    }
}
