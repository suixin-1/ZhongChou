package com.yh.mapper;
/**
 * 
 * 
 */
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yh.pojo.ClComment;

public interface ClCommentMapper {
List<ClComment> selectComment();
List<ClComment> selectCommentxq(@Param("cmPsId") int cmPsId);
boolean delcomment(int cmId);

}
