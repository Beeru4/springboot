package com.beerus.service.impl;

import com.beerus.mapper.ProjectInfoMapper;
import com.beerus.pojo.Page;
import com.beerus.pojo.ProjectInfo;
import com.beerus.service.ProjectInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author Beerus
 * @Description
 * @Date 2019-07-25
 **/
@Service
public class ProjectInfoServiceImpl implements ProjectInfoService {

    @Resource
    private ProjectInfoMapper projectInfoMapper;


    @Override
    public Page<ProjectInfo> listByPagProjectInfo(ProjectInfo projectInfo, Integer currPageNo, Integer pageSize) {
        Page<ProjectInfo> page = new Page<>();
        page.setCurrPageNo(currPageNo);
        page.setTotalRows(projectInfoMapper.count_Rows(projectInfo));
        page.setPageSize(pageSize);
        page.setTotalPage((page.getTotalRows() + pageSize - 1) / pageSize);
        page.setDatas(projectInfoMapper.listByPagProjectInfo(projectInfo, (currPageNo - 1) * pageSize, pageSize));
        return page;
    }

    @Override
    public boolean modifyProjectInfo(ProjectInfo projectInfo) {
        return projectInfoMapper.modifyProjectInfo(projectInfo) > 0;
    }

    @Override
    public ProjectInfo getProject(Integer id) {
        return projectInfoMapper.getProject(id);
    }
}
