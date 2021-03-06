/**
 * SPDX-FileCopyrightText: 2018-2021 SAP SE or an SAP affiliate company and Cloud Security Client Java contributors
 * 
 * SPDX-License-Identifier: Apache-2.0
 */
package sample.spring.xsuaa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Simple DataLayer interface that shows how Spring global message security
 * can be used to control access to data objects on a method level.
 */
@Service
public class DataService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * Reads sensitive data from the data layer.
     * User requires scope {@code Admin}
     * for this to succeed.
     *
     */
    @PreAuthorize("hasAuthority('Admin')")
    String readSensitiveData() {
        logger.info("Reading sensitive data.");
        return "You got the sensitive data";
    }

}
