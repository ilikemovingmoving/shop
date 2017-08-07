package com.taotao.controller;

import com.taotao.common.pojo.EUTreeNode;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.service.ContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2017/8/2.
 */
@Controller
@RequestMapping("/content/category")
public class ContentCategoryController {

    @Autowired
    private ContentCategoryService contentCategoryService;

    @RequestMapping("/list")
    @ResponseBody
    public List<EUTreeNode> getContentCategoryList(@RequestParam(value="id", defaultValue="0")long parentid) throws Exception {
        List<EUTreeNode> list = contentCategoryService.getContentCategoryList(parentid);
        return list;
    }

    @RequestMapping("/create")
    @ResponseBody
    public TaotaoResult addNode(Long parentId, String name) throws Exception {

        TaotaoResult result = contentCategoryService.addNode(parentId, name);
        return result;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public int delNode(Long id) throws Exception{
        int i = contentCategoryService.delNode(id);
        return i;
    }

    @RequestMapping("/update")
    @ResponseBody
    public int rename(Long id,String name) throws Exception{
        return contentCategoryService.rename(id,name);
    }


}

