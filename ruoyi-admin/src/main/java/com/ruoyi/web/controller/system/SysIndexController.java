package com.ruoyi.web.controller.system;

import java.util.List;

import com.ruoyi.framework.web.domain.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import com.ruoyi.common.config.Global;
import com.ruoyi.system.domain.SysMenu;
import com.ruoyi.system.domain.SysUser;
import com.ruoyi.system.service.ISysMenuService;
import com.ruoyi.framework.web.base.BaseController;

/**
 * 首页 业务处理
 *
 * @author ruoyi
 */
@Controller
public class SysIndexController extends BaseController {
    @Autowired
    private ISysMenuService menuService;

    /**
     * 系统首页
     * @param mmap 模型参数
     * @return
     */
    @GetMapping("/index")
    public String index(ModelMap mmap) {
        // 取身份信息
        SysUser user = getSysUser();
        // 根据用户id取出菜单
        List<SysMenu> menus = menuService.selectMenusByUser(user);

        mmap.put("menus", menus);
        mmap.put("user", user);
        mmap.put("copyrightYear", Global.getCopyrightYear());

        return "index";
    }

    /**
     * 系统介绍
     * @param mmap 模型参数
     * @return
     */
    @GetMapping("/system/main")
    public String main(ModelMap mmap) throws Exception {
        mmap.put("version", Global.getVersion());
        Server server = new Server();
        server.copyTo();

        mmap.put("server", server);

        return "main";
    }
}
