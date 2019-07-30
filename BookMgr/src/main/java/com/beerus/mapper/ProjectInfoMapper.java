package com.beerus.mapper;

import com.beerus.pojo.ProjectInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author Beerus
 * @Description 映射层
 * @Date 2019-07-25
 **/
@Mapper
public interface ProjectInfoMapper {

    /**
     * 分页查询项目报表
     *
     * @param projectInfo
     * @return
     */
    List<ProjectInfo> listByPagProjectInfo(@Param("info") ProjectInfo projectInfo,
                                           @Param("currPageNo") Integer currPageNo,
                                           @Param("pageSize")Integer pageSize);

    /**
     * 查找总行数
     *
     * @param projectInfo
     * @return
     */
    Integer count_Rows(@Param("info")ProjectInfo projectInfo);

    /**
     * 修改项目信息
     *
     * @param projectInfo
     * @return
     */
    Integer modifyProjectInfo(ProjectInfo projectInfo);

    /**
     * 修改之前先查询
     * @param id
     * @return
     */
    ProjectInfo getProject(Integer id);
}
