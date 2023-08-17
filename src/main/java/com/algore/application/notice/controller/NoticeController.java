package com.algore.application.notice.controller;

import com.algore.application.notice.dto.NoticeDTO;
import com.algore.application.notice.service.NoticeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/notice")
public class NoticeController {

    private final NoticeService noticeService;

    public NoticeController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    @GetMapping("/main")
    public ModelAndView noticeMainPage(ModelAndView mv, HttpServletRequest request/*요청*/, HttpServletResponse response) {
        List<NoticeDTO> noticeDTO = noticeService.noticeMainPage();
        mv.addObject("noticeDTO", noticeDTO);

        mv.setViewName("/notice/main");
        return mv;
    }

    @GetMapping("/write")
    public void write() {
    }

    @GetMapping("/read")
    public String read() {
        return "notice/read";
    }

}
