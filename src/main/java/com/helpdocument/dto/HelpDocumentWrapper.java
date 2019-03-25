package com.helpdocument.dto;

import com.helpdocument.entity.HelpDocument;

import java.io.Serializable;
import java.util.List;

/**
 * Auther: liyuanchi
 * Mail: liyuanchi@meituan.com
 * DateTime: 2018/1/23 17:25
 * Project:
 */
public class HelpDocumentWrapper implements Serializable{
    List<HelpDocument> helpDocuments;

    public List<HelpDocument> getHelpDocuments() {
        return helpDocuments;
    }

    public void setHelpDocuments(List<HelpDocument> helpDocuments) {
        this.helpDocuments = helpDocuments;
    }
}
