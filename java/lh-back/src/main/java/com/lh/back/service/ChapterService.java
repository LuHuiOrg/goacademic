package com.lh.back.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lh.back.UtilPojo.ComboTreeModel;
import com.lh.back.UtilPojo.PageBean;
import com.lh.back.dao.ChapterMapper;
import com.lh.back.dao.CourseMapper;
import com.lh.back.entity.Chapter;
import com.lh.back.entity.pojo.ChapterPojo;


@Service
public class ChapterService {
	
	@Autowired
	private ChapterMapper chapterMapper;
	
	@Autowired
	private CourseMapper courseMapper;
	
	//存放转换后数据的集合 
	
	
	public PageInfo<ChapterPojo> pageChapter(Chapter chapter,Integer pageNum,Integer pageSize){
		pageNum = pageNum != null ? pageNum : 1;
		pageSize = pageSize != null ? pageSize : 10;
		PageHelper.startPage(pageNum, pageSize, true);
		List<Chapter> chapterList = chapterMapper.listChapter(chapter);
	
		List<ChapterPojo> chapterPojoList  = new ArrayList<ChapterPojo>();
    	for(int i = 0; i<chapterList.size(); i++){
    		ChapterPojo chapterPojo = new ChapterPojo();
    		chapterPojo.setId(chapterList.get(i).getId());
    		chapterPojo.setName(chapterList.get(i).getName());
    		Long parentId = chapterList.get(i).getParentId();
    		if(parentId == 0){
    			String courseName = courseMapper.selectByPrimaryKey(chapterList.get(i).getId()).getName();
        		chapterPojo.setCourseName(courseName);
    		}else{
    			chapterPojo.setParent_id(parentId);
        		chapterPojo.set_parentId(parentId);
    		}
    		chapterPojo.setUrl(chapterList.get(i).getUrl());
    		chapterPojoList.add(chapterPojo);
    	}
    	PageInfo<ChapterPojo> pageInfo = new PageInfo<ChapterPojo>(chapterPojoList);
        return  pageInfo;
	}



 
	
    public List<Chapter> findChapters(Map<String, Object> map) {

        return chapterMapper.findChapters(map);
    }

    public List<ChapterPojo> findChapterPojos(Integer page,Integer rows,Chapter chapter) {
    	page = page != null ? page : 1;
    	rows = rows != null ? rows : 10;
    	PageBean pageBean = new PageBean(page, rows);
    	
    	 Map<String, Object> map = new HashMap<String, Object>();
	        // 判断查询条件是否为空，如果是，对条件做数据库模糊查询的处理
	        if (chapter.getName() != null && !"".equals(chapter.getName().trim())) {
	            map.put("name", "%" + chapter.getName() + "%");
	        }
	        map.put("firstPage", pageBean.getFirstPage());
	        map.put("rows", pageBean.getRows());
    	List<Chapter> chpaterList  = chapterMapper.findChapters(map);
    	List<ChapterPojo> chpaterPojoList  = new ArrayList<ChapterPojo>();
    	for(int i = 0; i<chpaterList.size(); i++){
    		ChapterPojo chapterPojo = new ChapterPojo();
    		chapterPojo.setId(chpaterList.get(i).getId());
    		chapterPojo.setName(chpaterList.get(i).getName());
    		Long parentId = chpaterList.get(i).getParentId();
    		if(parentId == 0){
    			String courseName = courseMapper.selectByPrimaryKey(chpaterList.get(i).getId()).getName();
        		chapterPojo.setCourseName(courseName);
    		}else{
    			chapterPojo.setParent_id(parentId);
        		chapterPojo.set_parentId(parentId);
    		}
    		chapterPojo.setUrl(chpaterList.get(i).getUrl());
    		chpaterPojoList.add(chapterPojo);
    	}
    	
        return chpaterPojoList;
    }

    public Integer getCount(Map<String, Object> map) {

        return chapterMapper.getCount(map);
    }
    
    public List<Chapter> findChapter(Chapter chapter) {
        return chapterMapper.listChapter(chapter);
    }
    /**
     * 通过父ID查询章节列表
     * @param id
     * @return
     */
    public List<Chapter> findChapterById(Long id ) {
    	Chapter chapter = new Chapter();
    	chapter.setParentId(id);
        return chapterMapper.listChapter(chapter);
    }
    /**
     * 获取下拉菜单
     * @param chapter
     * @return
     */
    public List<ComboTreeModel> getTreeData(Chapter chapter){
    	//根据当前课程的ID查询出所有章节
    	List<Chapter> chapterList = chapterMapper.listChapter(chapter);  
	    List<ComboTreeModel> list = new ArrayList<ComboTreeModel>();  
	    for(int i=0; i<chapterList.size(); i++){  
	    	Long parentId = chapterList.get(i).getParentId();
	    	//章节中父节点为0的则是一级目录
	    	 if(parentId == 0){
	    		ComboTreeModel model = new ComboTreeModel(); 
	    		//获取章节的ID和名称
	 	        Long chapterId = chapterList.get(i).getId();  
	 	        String chapterName = chapterList.get(i).getName();  
	 	        model.setId(""+chapterId+"");   
	 	        model.setText(chapterName); 
	 	        //判断当前章节是否有子章节
	 	        if(hasChild(chapterId)){
	 	        	model.setChildren(createChild(chapterId));
	 	        }
	 	       list.add(model);
		      }
	    }  
	    return list;  
    	
    }
    /**
     * 根据父节点查询子章节
     * @param parentId
     * @return
     */
    private List<ComboTreeModel> createChild(Long parentId){
    	List<Chapter> chapterList =findChapterById(parentId); 
    	List<ComboTreeModel> list = new ArrayList<ComboTreeModel>();
    		for(int i=0; i<chapterList.size(); i++){  
    	    		ComboTreeModel model = new ComboTreeModel();  
    	 	        Long chapterId = chapterList.get(i).getId();  
    	 	        String chapterName = chapterList.get(i).getName();  
    	 	        model.setId(""+chapterId+"");   
    	 	        model.setText(chapterName); 
    	 	        if(hasChild(chapterId)){
    	 	        	model.setChildren(createChild(chapterId));
    	 	        }
    	 	       list.add(model);
    	 	    	  
    	 	       }
    	 	     return list;   
    	}
    	
    
    /**
     * 判断是否有子章节
     * @param parentId
     * @return
     */
    private boolean hasChild(Long parentId){
    	List<Chapter> chapterList = findChapterById(parentId); 
    	if(chapterList.size()>0){
    		return true;
    	}else{
    		return false;
    	}
    	
    }
    
	
}

