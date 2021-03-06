package com.chinalife.sz.carcalculate.controller;

import org.springframework.cache.Cache;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by tianwei on 2016/12/29.
 */
//主要用于手动清空缓存
@Controller
public class CacheController {
    @Resource
    private EhCacheCacheManager ehCacheCacheManager;
    @RequestMapping(value = "/clear/{type}",method = RequestMethod.GET)
    public @ResponseBody String  result(@PathVariable("type") String type){
        Cache myCache = ehCacheCacheManager.getCache("myCache");
        if(myCache!=null){
            if("all".equals(type)){
                myCache.clear();
                return "success";
            }
            else {
                  myCache.evict(type);
                return "success";
            }
        }

        return "fail";
    }
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public @ResponseBody String hello(){

        return "hello";
    }

}
