package com.algore.application.notice.dao;

import com.algore.application.notice.dto.NoticeDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeMapper {
    List<NoticeDTO> noticeMainPage();
}
