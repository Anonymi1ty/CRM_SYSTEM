package controller.workbench;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("/workbench/index.do")//和资源路径一致
    public String index(){
        //跳转到业务首页
        return "workbench/index";
    }
}
