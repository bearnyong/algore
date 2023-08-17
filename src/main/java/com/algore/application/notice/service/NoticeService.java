package com.algore.application.notice.service;

import com.algore.application.notice.dao.NoticeMapper;
import com.algore.application.notice.dto.NoticeDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeService {

    private final NoticeMapper mapper;

    public NoticeService(NoticeMapper mapper) {
        this.mapper = mapper;
    }

    public List<NoticeDTO> noticeMainPage() {
        List<NoticeDTO> noticeDTO = mapper.noticeMainPage();
        return noticeDTO;
    }
}
