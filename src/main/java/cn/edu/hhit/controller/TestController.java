package cn.edu.hhit.controller;


import cn.edu.hhit.entity.TrainFile;
import cn.edu.hhit.service.TestService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    protected TestService testService;

    @Autowired
    private Gson gson;

    @RequestMapping("/index.do")
    public String index(){
        System.out.println("index");
        return  "index";
    }

    @RequestMapping(value = "/t.do",method = RequestMethod.GET)
    @ResponseBody
    public String get() {
        List<TrainFile> list = testService.getCount();
        System.out.println("测试热部署！！！！");
        System.out.println();
        for (int i = 0; i < list.size(); i++) {
            TrainFile trainFile =  list.get(i);
            System.out.println(trainFile.getName()+","+trainFile.getId());
        }
        for (TrainFile trainFile : list) {
            System.out.println(trainFile.getName()+","+trainFile.getId());
        }
        return gson.toJson(list);
    }
    @RequestMapping(value = "t.do",method = RequestMethod.POST)
    public String post(){

        return "";
    }
    @RequestMapping("/update.do")
    @ResponseBody
    public String update(String id,String name){
        testService.update(id,name);
        return "success";
    }
}
