package com.lh.back.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.lh.back.UtilPojo.PageBean;
import com.lh.back.entity.Chapter;
import com.lh.back.entity.pojo.ChapterPojo;
import com.lh.back.service.ChapterService;
import com.lh.back.utils.JsonDateValueProcessor;
import com.lh.back.utils.ResponseUtil;

@Controller
@RequestMapping(value = "chapter")
public class ChapterController {

	
	@Autowired
	private ChapterService chapterService;
	
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String chapter(){
		return "chapter/list";
	}
	
/*	@RequestMapping(value = "list",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> list(Chapter chapter,Integer page,Integer rows){
		Map<String,Object> resutlMap = new HashMap<String,Object>();
		PageInfo<ChapterPojo> pageInfo = chapterService.pageChapter(chapter,page,rows);
		System.out.println(pageInfo.getList().size());
		resutlMap.put("rows", pageInfo.getList());
		resutlMap.put("total", pageInfo.getTotal());
		resutlMap.put("firstPage", pageInfo.getFirstPage());
		return resutlMap;
	}*/
	  @RequestMapping("/list")
	    public String list(@RequestParam(value="page", required=false) String page, 
	            @RequestParam(value="rows", required=false) String rows, Chapter chapter, HttpServletResponse response)
	            throws Exception {
	    	
	    	PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
	    	
	        Map<String, Object> map = new HashMap<String, Object>();
	        // 判断查询条件是否为空，如果是，对条件做数据库模糊查询的处理
	        if (chapter.getName() != null && !"".equals(chapter.getName().trim())) {
	            map.put("name", "%" + chapter.getName() + "%");
	            
	        }
	        
	        map.put("firstPage", pageBean.getFirstPage());
	        map.put("rows", pageBean.getRows());
	        
	        List<ChapterPojo> chapterPojoList = chapterService.findChapterPojos(map);
	        Integer total = chapterService.getCount(map);

	        // 处理日期使之能在 easyUI 的 datagrid 中正常显示
	        JsonConfig jsonConfig = new JsonConfig();
	        jsonConfig.registerJsonValueProcessor(Date.class,
	                new JsonDateValueProcessor());
	        // 将数据以 JSON 格式返回前端
	        JSONObject result = new JSONObject();
	        JSONArray jsonArray = JSONArray.fromObject(chapterPojoList, jsonConfig);
	        result.put("rows", jsonArray);
	        result.put("total", total);
	        ResponseUtil.write(response, result);
	        return null;
	    }
	
	
	
	
	
}
