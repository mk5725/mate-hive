package com.mk.controller;

import com.mk.common.ErrorCode;
import com.mk.exception.BusinessException;
import com.mk.model.domain.Team;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 队伍接口
 */
@RestController
@RequestMapping("/team1")
public class TeamController1 {
    /**
     * 加入队伍需求分析
     * 1. 用户可以加入未满的队伍
     *
     * 接口开发
     *    判断用户是否登录
     *    判断队伍是否存在，切队伍未满
     *    判断是否已经加入队伍
     *    判断队伍是否加密
     *      加密 密码不能为空
     *    插入用户队伍信息
     */
    public void join(@RequestBody Team team, HttpServletRequest request){
        if (team == null){
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }

    }
}
