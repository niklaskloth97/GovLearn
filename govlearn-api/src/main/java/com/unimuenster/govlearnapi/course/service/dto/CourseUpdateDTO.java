package com.unimuenster.govlearnapi.course.service.dto;

import com.unimuenster.govlearnapi.core.config.enums.Format;
import com.unimuenster.govlearnapi.core.config.enums.Skilllevel;

import java.util.Date;

public record CourseUpdateDTO(
        Long id,
        String name,
        String image,
        String description,
        String provider,
        String instructor,
        Boolean certificate,
        Skilllevel skilllevel,
        Integer durationInMinutes,
        Format format,
        Date startDate,
        Boolean costFree,
        Boolean domainSpecific,
        String link) {
}
