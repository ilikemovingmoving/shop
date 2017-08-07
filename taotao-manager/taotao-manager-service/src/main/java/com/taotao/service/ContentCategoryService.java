package com.taotao.service;

import com.taotao.common.pojo.EUTreeNode;
import com.taotao.common.pojo.TaotaoResult;

import java.util.List;

/**
 * Created by Administrator on 2017/8/2.
 */
public interface ContentCategoryService {
    public List<EUTreeNode> getContentCategoryList(long parentid) throws Exception;

    public TaotaoResult addNode(long parentid, String name) throws Exception;

    public int rename(long id,String name) throws Exception;

    public int delNode(long id) throws  Exception;

}
