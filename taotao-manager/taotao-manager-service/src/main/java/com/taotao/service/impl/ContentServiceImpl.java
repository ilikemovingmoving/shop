package com.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.mapper.TbContentMapper;
import com.taotao.pojo.TbContent;
import com.taotao.pojo.TbContentExample;
import com.taotao.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ContentServiceImpl implements ContentService {

	@Autowired
	private TbContentMapper contentMapper;

	@Override
	public EUDataGridResult getContentList(long catId, Integer page, Integer rows) throws Exception {
		//根据category_id查询内容列表
		TbContentExample example = new TbContentExample();
		TbContentExample.Criteria criteria = example.createCriteria();
		criteria.andCategoryIdEqualTo(catId);
		//分页处理
		PageHelper.startPage(page, rows);
		List<TbContent> list = contentMapper.selectByExampleWithBLOBs(example);
		//取分页信息
		PageInfo<TbContent> pageInfo = new PageInfo<>(list);
		EUDataGridResult result = new EUDataGridResult();
		result.setTotal(pageInfo.getTotal());
		result.setRows(list);
		return result;
	}

	@Override
	public TaotaoResult addContent(TbContent content) throws Exception {

		//把图片信息保存至数据库
		content.setCreated(new Date());
		content.setUpdated(new Date());
		//把内容信息添加到数据库
		contentMapper.insert(content);

		return TaotaoResult.ok();
	}

	@Override
	public TaotaoResult editContent(TbContent content) throws Exception {
		content.setUpdated(new Date());
		//TbContentExample example = new TbContentExample();
		//contentMapper.updateByExampleSelective(content,example);
		contentMapper.updateByPrimaryKey(content);
		return TaotaoResult.ok();
	}

	@Override
	public TaotaoResult delContent(String ids)  throws  Exception{
		String[] idAddr = ids.split(",");
		for (String id:idAddr){
			contentMapper.deleteByPrimaryKey(Long.parseLong(id));
		}
		return TaotaoResult.ok();
	}

}

