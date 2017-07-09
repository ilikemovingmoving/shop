package com.taotao.service;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItemParam;

/**
 * Created by Administrator on 2017/7/8.
 */
public interface ItemParamService {

    EUDataGridResult getItemParamList(int page, int rows);
    public TaotaoResult getItemParamByCid(long cid);
    public TaotaoResult insertItemParam(TbItemParam itemParam);
}
