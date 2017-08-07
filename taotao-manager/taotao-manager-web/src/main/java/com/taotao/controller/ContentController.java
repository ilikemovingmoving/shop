package com.taotao.controller;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbContent;
import com.taotao.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/content")
public class ContentController {

	@Autowired
	private ContentService contentService;

	@RequestMapping("/query/list")
	@ResponseBody
	public EUDataGridResult getContentList(Long categoryId, Integer page, Integer rows) throws Exception {
		EUDataGridResult result = contentService.getContentList(categoryId, page, rows);
		return result;
	}

	@RequestMapping("/save")
	@ResponseBody
	public TaotaoResult addContent(TbContent content) throws Exception {
		TaotaoResult result = contentService.addContent(content);
		return result;
	}

	@RequestMapping("/edit")
	@ResponseBody
	public TaotaoResult editContent(TbContent content) throws Exception {
		TaotaoResult result = contentService.editContent(content);
		return result;
	}

	@RequestMapping("/delete")
	@ResponseBody
	public TaotaoResult delContent(String ids) throws Exception {
		TaotaoResult result = contentService.delContent(ids);
		return result;
	}

}


