package com.helpdocument.dao;

import com.helpdocument.entity.HelpDocument;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Auther: liyuanchi
 * DateTime: 2018/1/16 17:21
 * desc： 帮助文档
 */
@Component
public interface HelpDocumentDao {

    /**
     * 添加文档
     * @param helpDocument
     * @return
     */
    Integer insert(
            @Param("helpDocument") HelpDocument helpDocument
    );


    /**
     * 逻辑上删除
     * @param id ID
     * @return 执行状态
     */
    Integer delete(
            @Param("id") int id
    );

    /**
     *  更新文档
     *  @Param helpDocument
     * @return
     */
    Integer update(
            @Param("helpDocument") HelpDocument helpDocument
    );

    /**
     * 更新状态
     * @param id
     * @param status
     * @return
     */
    Integer updateStatus(
            @Param("id") int id,
            @Param("status") int status
    );

    /**
     * 根据文档ID查找文档
     * @param id 文档ID
     * @return HelpDocument
     */
    HelpDocument load(
            @Param("id") int id
    );

    /**
     * 获取所有文档
     * @return HelpDocument
     */
    List<HelpDocument> query();


    /**
     * 根据状态获取文档
     * @return HelpDocument
     */
    List<HelpDocument> queryByType(
            @Param("type") int type
    );

    /**
     * 根据标题模糊查询
     * @return HelpDocument
     */
    List<HelpDocument> queryLikeTitle(
            @Param("title") String title
    );



}
