package com.algore.application.kitchenguide;

import com.algore.application.kitchenguide.dto.TrimDTO;
import com.algore.application.kitchenguide.dto.TrimProcedureDTO;
import com.algore.application.kitchenguide.service.KitchenguideService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Trim;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class KitchenguideServiceTest {
    
    /* @Test
     * ------- 테스트 클래스는 적어도 한 개 이상의 @Test 어노테이션이 달린 메소드를 가진 클래스이다.
     * ------- 테스트 클래스는 abstract(추상적)이면 안되고, 한 개의 생성자를 가지고 있어야 한다.
     * ------- 아무런 생성자도 작성하지 않으면 기본 생성자는 컴파일러가 자동으로 추가해준다.
     *
     * ------- Junit은 순서가 보장되지 않는다는 문제점을 가지고 있다.
     * ------- 그렇기에 순서가 보장되어야 하는 경우 해당 클래스에  @TestMethodOrder(MethodOrderer.OrderAnnotation.class) 어노테이션을 추가한 뒤
     * ------- 각 테스트 메소드에 @Order(n) 어노테이션으로 순서를 지정하여 테스트 순서를 설정해주어야 한다.
     *
     * ------- 반복적인 테스트가 필요할 경우 @RepeatedTest(n) 어노테이션을 추가하여 반복 횟수를 지정할 수 있다.
     * */

    /* TestCode 작성 순서
     * 1. given: 검증을 위한 파라미터를 준비하는 단계
     * 2. when: 테스트를 진행할 메서드를 호출
     * 3. then: 실행 결과를 검증 */

    // 1. given: 검증을 위한 파라미터를 준비하는 단계

    // 2. when: 테스트를 진행할 메서드를 호출

    // 3. then: 실행 결과를 검증

    @Autowired
    public KitchenguideService kitchenguideService;

    /*.....
    Trim_Read TestCode.....*/
    @Test
    @DisplayName("손질법 게시글 조회 테스트")
    public void trimReadTest() {
        // 1. given: 검증을 위한 파라미터를 준비하는 단계
        int tirmPostNum = 18;
        TrimDTO trimDTO = new TrimDTO(18, "미끌 통오징어 오징어야 안녕!", "오징어 손질법 수정하기...");

        // 2. when: 테스트를 진행할 메서드를 호출
        TrimDTO trimDTOTest = kitchenguideService.readTrim(tirmPostNum);

        // 3. then: 실행 결과를 검증
        Assertions.assertAll(
                ()-> Assertions.assertEquals(trimDTO.getTrimTitle(), trimDTOTest.getTrimTitle(), "게시글 제목이 같지 않습니다."),
                ()-> Assertions.assertEquals(trimDTO.getTrimDetail(), trimDTOTest.getTrimDetail(), "게시글 내용이 같지 않습니다.")
        );
    }

    @Test
    @DisplayName("손질법 게시글 손질 순서 조회 테스트")
    public void trimProcedureReadTest() {
        // 1. given: 검증을 위한 파라미터를 준비하는 단계
        int trimPostNum = 5;
        TrimProcedureDTO trimProDTO1 = new TrimProcedureDTO(5, "손질법 내용... 순서", "733c54a2e7134d388a408bacac83e4a7.png");
        TrimProcedureDTO trimProDTO2 = new TrimProcedureDTO(5, "손질법 내용... 순서", "733c54a2e7134d388a408bacac83e4a7.png");
        TrimProcedureDTO trimProDTO3 = new TrimProcedureDTO(5, "손질법 내용... 순서", "733c54a2e7134d388a408bacac83e4a7.png");
        TrimProcedureDTO trimProDTO4 = new TrimProcedureDTO(5, "손질법 내용... 순서", "733c54a2e7134d388a408bacac83e4a7.png");

        List<TrimProcedureDTO> trimPros = Arrays.asList(trimProDTO1, trimProDTO2, trimProDTO3, trimProDTO4);

        // 2. when: 테스트를 진행할 메서드를 호출
        List<TrimProcedureDTO> procedureList = kitchenguideService.readPost(trimPostNum);

        // 3. then: 실행 결과를 검증
        Assertions.assertAll(
                ()-> Assertions.assertEquals(trimPros.get(0).getTpDetail(), procedureList.get(0).getTpDetail(), "게시글 손질 순서 1번 내용이 같지 않습니다."),
                ()-> Assertions.assertEquals(trimPros.get(0).getSaveName(), procedureList.get(0).getSaveName(), "게시글 손질 순서 1번 사진이 같지 않습니다."),

                ()-> Assertions.assertEquals(trimPros.get(1).getTpDetail(), procedureList.get(1).getTpDetail(), "게시글 손질 순서 2번 내용이 같지 않습니다."),
                ()-> Assertions.assertEquals(trimPros.get(1).getSaveName(), procedureList.get(1).getSaveName(), "게시글 손질 순서 2번 사진이 같지 않습니다."),

                ()-> Assertions.assertEquals(trimPros.get(2).getTpDetail(), procedureList.get(2).getTpDetail(), "게시글 손질 순서 3번 내용이 같지 않습니다."),
                ()-> Assertions.assertEquals(trimPros.get(2).getSaveName(), procedureList.get(2).getSaveName(), "게시글 손질 순서 3번 사진이 같지 않습니다."),

                ()-> Assertions.assertEquals(trimPros.get(3).getTpDetail(), procedureList.get(3).getTpDetail(), "게시글 손질 순서 3번 내용이 같지 않습니다."),
                ()-> Assertions.assertEquals(trimPros.get(3).getSaveName(), procedureList.get(3).getSaveName(), "게시글 손질 순서 4번 사진이 같지 않습니다.")
        );
    }


    /*.....
    Kitchenguide Main Page TestCode.....*/
    @Test
    @DisplayName("메인 페이지 게시글 상태 테스트")
    public void MainPagePostStatusTest() {
        // 1. given: 검증을 위한 파라미터를 준비하는 단계
        int num = 14;
        String status = "Y";

        // 2. when: 테스트를 진행할 메서드를 호출
        List<TrimDTO> dtomainList = kitchenguideService.mainPost();

        // 3. then: 실행 결과를 검증
        org.assertj.core.api.Assertions.assertThat(dtomainList)
                //게시글 상태가 Y가 맞는지 확인하고 싶기..
                .filteredOn("trimStatus", status);

    }







    @Test //Test 메소드를 만들기 위한 @Test 어노테이션
    @DisplayName("여기는_삭제_서비스...") //테스트 이름을 설정
    public void test1() {
        // 1. given: 검증을 위한 파라미터를 준비하는 단계
        int deleteNum = 999;

        // 2. when: 테스트를 진행할 메서드를 호출
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
