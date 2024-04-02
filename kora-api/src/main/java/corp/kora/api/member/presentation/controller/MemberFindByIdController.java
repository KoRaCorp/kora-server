package corp.kora.api.member.presentation.controller;


import corp.kora.api.member.application.MemberFindByIdQueryManager;
import corp.kora.api.member.presentation.response.MemberFindByIdResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberFindByIdController {
    private final MemberFindByIdQueryManager memberFindByIdQueryManager;

    @GetMapping("/members/{memberId}")
    @ResponseStatus(HttpStatus.OK)
    public MemberFindByIdResponse findById(
        @PathVariable Long memberId
    ) {
        return memberFindByIdQueryManager.read(new MemberFindByIdQueryManager.Query(memberId));
    }

}
