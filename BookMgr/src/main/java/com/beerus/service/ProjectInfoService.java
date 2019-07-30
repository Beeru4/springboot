package com.beerus.service;

import com.beerus.pojo.Page;
import com.beerus.pojo.ProjectInfo;
import org.springframework.transaction.annotation.Transactional;


/**
 * @Author Beerus
 * @Description
 * @Date 2019-07-25
 **/
@Transactional
public interface ProjectInfoService {
    /**
     * 分页查询项目报表
     *
     * @param projectInfo
     * @return
     */
    @Transactional(readOnly = true)
    Page<ProjectInfo> listByPagProjectInfo(ProjectInfo projectInfo,
                                           Integer currPageNo,
                                           Integer pageSize);


    /**
     * 修改项目信息
     *
     * @param projectInfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    boolean modifyProjectInfo(ProjectInfo projectInfo);

    /**
     * 修改之前先查询
     * @param id
     * @return
     */
    @Transactional(readOnly = true)
    ProjectInfo getProject(Integer id);
}
