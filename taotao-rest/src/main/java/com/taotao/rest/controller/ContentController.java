package com.taotao.rest.controller;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.rest.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017/8/6.
 */
@Controller
@RequestMapping("/content")
public class ContentController {

    @Autowired
    private ContentService contentService;

    @RequestMapping("/category/{cid}")
    @ResponseBody
    public TaotaoResult getContentList(@PathVariable Long cid) {
        TaotaoResult result = null;
        try {
            result = contentService.getContentList(cid);
        } catch (Exception e) {
            e.printStackTrace();
            return TaotaoResult.build(500, e.getMessage());
        }
        return result;
    }
}


