package com.algore.application.kitchenguide;

import com.algore.application.kitchenguide.dto.TrimDTO;
import com.algore.application.kitchenguide.dto.TrimProcedureDTO;
import com.algore.application.kitchenguide.service.KitchenguideService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class KitchenguideControllerTests {

    @Autowired
    public KitchenguideService kitchenguideService;

    @Test
    @DisplayName("여기는_삭제_서비스...")
    public void test1() {
        // 1. given: 검증을 위한 파라미터를 준비하는 단계
        int deleteNum = 999;

        // 2. when: 테스트를 진행할 메서드를 호출
//        KitchenguideController controller =
        int deleted = kitchenguideService.deleteTrimPost(deleteNum);

        // 3. then: 실행 결과를 검증
        Assertions.assertEquals(/*비교대상값*/deleteNum, /*예상값*/deleted, () -> "불일치한가?");
    }


    @Test
    @DisplayName("TrimProcedureDTO_동시에_여러가지_값에_대한_검증을_수행하는_경우_테스트")
    void test2() {
        // 1. given: 검증을 위한 파라미터를 준비하는 단계
        String tpPath = "dfadfdsfaf"; //저장경로
        String saveName = "0de3f677784c4d85af662817cdf301aa.png"; //저장이름
        int trimNum = 1; //손질번호

        // 2. when: 테스트를 진행할 메서드를 호출
        TrimProcedureDTO trimProcedureDTO = new TrimProcedureDTO(tpPath, saveName, trimNum);

        // 3. then: 실행 결과를 검증
        Assertions.assertAll("실패시 보여주는 그룹화된 테스트의 이름",
                () -> Assertions.assertEquals(tpPath, trimProcedureDTO.getTpPath(), () -> "tpPath가 잘못됨..."),
                () -> Assertions.assertEquals(saveName, trimProcedureDTO.getSaveName(), () -> "saveName가 잘못됨..."),
                () -> Assertions.assertEquals(trimNum, trimProcedureDTO.getTrimNum(), () -> "trimNum가 잘못됨..."));
    }


    @Test
    @DisplayName("여기는_무슨_테스트")
    public void test3() {
        // 1. given: 검증을 위한 파라미터를 준비하는 단계
        int trimNum = 90;
        // 2. when: 테스트를 진행할 메서드를 호출
        TrimDTO trimDTO = kitchenguideService.readTrim(trimNum);
        // 3. then: 실행 결과를 검증
        Assertions.assertNotNull(trimNum);
    }
}
