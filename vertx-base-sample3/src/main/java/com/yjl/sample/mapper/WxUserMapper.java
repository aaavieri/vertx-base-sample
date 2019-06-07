package com.yjl.sample.mapper;

import com.yjl.vertx.base.com.anno.Param;
import com.yjl.vertx.base.dao.anno.component.Dao;
import com.yjl.vertx.base.dao.anno.operation.Insert;
import com.yjl.vertx.base.dao.anno.operation.Select;
import io.vertx.core.Future;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

import java.util.List;

@Dao
public interface WxUserMapper {
    
    @Select("select wxappID, openID, clientID, channelID, unionid, phoneNum, information, sessionKey, token, tokenStartTime, insertUser, insertTime, updateUser, updateTime from t_wxuser " +
                "where wxappID = #{wxappID} and openid = #{openID}")
    Future<JsonObject> getWxUser(@Param("wxappID") String appId, @Param("openID") final String openid);
    
    @Select("select wxappID, openID, clientID, channelID, unionid, phoneNum, information, sessionKey, token, tokenStartTime, insertUser, insertTime, updateUser, updateTime from t_wxuser " +
        "where wxappID in " +
        "<foreach collection='appList' item='app' open='(' close=')' separator=','>#{app}</foreach>")
    Future<JsonArray> getAppUserList(@Param("appList") List<String> appIdList);
    
    @Insert("insert into t_wxuser (wxappID, openID, clientID, channelID, unionid, phoneNum, information, sessionKey, token, tokenStartTime, insertUser, insertTime, updateUser, updateTime) " +
                "values (#{wxappID}, #{openID}, #{clientID}, #{channelID}, #{unionid}, #{phoneNum}, #{information}, #{sessionKey}, #{token}, #{tokenStartTime}, -1, sysdate(), -1, sysdate()) " +
                "on duplicate key update unionid = #{unionid}, phoneNum = #{phoneNum}, token = #{token}, sessionKey = #{sessionKey}, tokenStartTime = #{tokenStartTime}, " +
                "updateUser = -1, updateTime = sysdate()")
    Future<Integer> saveWxUser(@Param("userInfo") final JsonObject userInfo);
}
