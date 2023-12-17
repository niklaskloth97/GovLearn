package com.unimuenster.govlearnapi.group.controller;

import com.unimuenster.govlearnapi.common.responsewrapper.Response;
import com.unimuenster.govlearnapi.group.controller.wsto.AddMemberWsTo;
import com.unimuenster.govlearnapi.group.controller.wsto.GetGroupsWsTo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetGroupsByUserTest extends GroupTestBase {
    @BeforeEach
    void setUp() {
        setCurrentUser(initializerService.getUser2());

        createGroup();
        addMember();
    }

    @Override
    protected void addMember() {
        AddMemberWsTo addMemberWsTo = AddMemberWsTo
                .builder()
                .groupId(group.getId())
                .userId(initializerService.getUser1().getId())
                .build();

        groupMembersController.addMember(addMemberWsTo);

        AddMemberWsTo addMemberWsTo2 = AddMemberWsTo
                .builder()
                .groupId(group.getId())
                .userId(initializerService.getUser2().getId())
                .build();

        groupMembersController.addMember(addMemberWsTo2);
    }

    @Test
    void getContentByMember() {

        ResponseEntity responseEntity = groupController.getGroups();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        Response<GetGroupsWsTo> response = (Response<GetGroupsWsTo>) responseEntity.getBody();

        // Current user is member and admin of group with id 1
        assertEquals(group.getId(), response.getPayload().getAdminGroups().get(0));
        assertEquals(group.getId(), response.getPayload().getMemberGroups().get(0));
    }
}