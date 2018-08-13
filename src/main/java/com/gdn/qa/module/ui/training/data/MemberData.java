package com.gdn.qa.module.ui.training.data;

import com.gdn.common.web.wrapper.response.GdnRestSingleResponse;
import com.gdn.x.member.rest.web.model.dto.response.MemberResponse;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component("com.gdn.qa.module.ui.training.data.MemberData")
public class MemberData {
    private String userId;
    private GdnRestSingleResponse<MemberResponse> memberResponse;
}
