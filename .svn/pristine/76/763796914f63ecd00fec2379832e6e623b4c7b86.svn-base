package com.chinalife.sz.cc.combos.mapper;


import com.chinalife.sz.cc.model.combos.CombosSchemaDTO;
import com.prs.framework.core.biz.mapper.RepositoryMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by tianwei on 2016/12/23.
 */
@RepositoryMapper
public interface CombosSchemaMapper {
//    保存商业险套餐
    public void saveCombosSchema(CombosSchemaDTO combosScheme);
//    查找商业险套餐
    public List<CombosSchemaDTO>  findCombosSchemas(@Param("handlerCode")String handlerCode);
//    更新商业险套餐
    public int updateCombosSchema(CombosSchemaDTO combosScheme);
//    删除商业套餐
    public int deleteCombosSchema(@Param("id") Long id);
}
