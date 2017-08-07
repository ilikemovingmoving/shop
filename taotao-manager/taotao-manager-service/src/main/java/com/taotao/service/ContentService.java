package com.taotao.service;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbContent;

/**
 * Created by Administrator on 2017/8/5.
 */
public interface ContentService {

    public EUDataGridResult getContentList(long catId, Integer page, Integer rows) throws Exception;

    public TaotaoResult addContent(TbContent content) throws Exception;

    public TaotaoResult editContent(TbContent content) throws  Exception;

    public TaotaoResult delContent(String ids) throws  Exception;
}
