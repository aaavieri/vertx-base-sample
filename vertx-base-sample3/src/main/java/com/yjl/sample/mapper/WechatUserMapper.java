package com.yjl.sample.mapper;

import com.yjl.vertx.base.com.anno.Param;
import com.yjl.vertx.base.dao.anno.component.Dao;
import com.yjl.vertx.base.dao.anno.operation.Select;
import io.vertx.core.Future;
import io.vertx.core.json.JsonObject;

@Dao
public interface WechatUserMapper {
    
    @Select("select clientID, channelID, openID, nickname, sex, language, city, province, country, headimgurl, subscribe_time, unionid, " +
                "remark, groupid, tagid_list from t_wechatuser where unionid = #{unionid}")
    Future<JsonObject> findByUnionId(@Param("unionid") final String unionid);
}
