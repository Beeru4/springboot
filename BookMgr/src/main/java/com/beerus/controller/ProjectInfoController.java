package com.beerus.controller;

import com.alibaba.fastjson.JSON;
import com.beerus.pojo.ProjectInfo;
import com.beerus.service.ProjectInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @Author Beerus
 * @Description 控制层
 * @Date 2019-07-25
 **/
@Controller
public class ProjectInfoController {

    /**
     * 页大小
     */
    private final Integer PAGESIZE = 5;

    /**
     * 业务层
     */
    @Resource
    private ProjectInfoService projectInfoService;

    /**
     * 首页访问该接口分页查询数据
     *
     * @param projectInfo 条件
     * @param currPageNo  当前页码
     * @param model       携带数据到视图层
     * @return
     */
    @RequestMapping("/")
    public String listAll(@ModelAttribute ProjectInfo projectInfo,
                          @RequestParam(value = "currPageNo", required = false, defaultValue = "1") Integer currPageNo, Model model) {
        // 回显下拉框
        model.addAttribute("status", projectInfo.getStatus() == null ? -1 : projectInfo.getStatus());
        // 设置查询数据
        model.addAttribute("page", projectInfoService.listByPagProjectInfo(projectInfo, currPageNo, PAGESIZE));
        return "index";
    }

    /**
     * 修改项目列表状态
     *
     * @param projectInfo 修改的项目
     * @return
     */
    @RequestMapping("/modifyProject")
    public String modifyProject(@ModelAttribute ProjectInfo projectInfo, Model model) {
        if (projectInfoService.modifyProjectInfo(projectInfo)) {
            model.addAttribute("msg","修改成功");
            // 修改成功
            return "redirect:/";
        } else {
            model.addAttribute("error","修改失败");
            // 修改失败
            return "redirect:/";
        }

    }

    /**
     * 修改之前先查询
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/getProject/{id}")
    @ResponseBody
    public Object getProject(@PathVariable Integer id) {
        ProjectInfo project = projectInfoService.getProject(id);
        if (null != project) {
            return JSON.toJSONStringWithDateFormat(project,"yyyy-MM-dd");
        } else {
            return "{\"code\",-1}";
        }
    }
}
