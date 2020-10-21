package com.company.project.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author :Libi
 * @version :1.0
 * @date :2020-10-21 16:11
 * 这里装解析token后的信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TokenInfo {
    private String userId;
    private String userName;
}
